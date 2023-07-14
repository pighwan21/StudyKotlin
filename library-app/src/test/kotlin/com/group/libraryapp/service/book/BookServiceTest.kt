package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.book.BookType
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import com.group.libraryapp.dto.book.response.BookStatResponse
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
) {

    @AfterEach
    fun clean() {
        bookRepository.deleteAll()
        userRepository.deleteAll()
    }

    @Test
    @DisplayName("책 등록이 정상 동작한다.")
    fun saveBookTest() {
        // given
        val request = BookRequest("토라도라", BookType.SOCIETY)

        // when
        bookService.saveBook(request)

        // then
        val books = bookRepository.findAll()
        assertThat(books).hasSize(1)
        assertThat(books[0].name).isEqualTo("토라도라")
        assertThat(books[0].type).isEqualTo(BookType.SOCIETY)
    }

    @Test
    @DisplayName("책 대출이 정상 동작한다.")
    fun loanBookTest() {
        // given
        bookRepository.save(Book.fixture("늑대와 향신료"))    // 여긴 코틀린 코드이기 때문에 default parameter를 인식해서
                                                          // 따로 id부분을 적어주지않아도 됨.
        val savedUser = userRepository.save(User("호로", null))
        val request = BookLoanRequest("호로", "늑대와 향신료")

        // when
        bookService.loanBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].bookName).isEqualTo("늑대와 향신료")
        assertThat(results[0].user.id).isEqualTo(savedUser.id)
        assertThat(results[0].status).isEqualTo(UserLoanStatus.LOANED)
    }

    @Test
    @DisplayName("책이 진작 대출되어 있다면, 신규 대출이 실패한다.")
    fun loanBookFailTest() {
        // given
        bookRepository.save(Book.fixture("나의 라임 오렌지 나무"))
        val savedUser = userRepository.save(User("제제", 12))
        userLoanHistoryRepository.save(UserLoanHistory.fixture(savedUser, "나의 라임 오렌지 나무"))
        val request = BookLoanRequest("제제", "나의 라임 오렌지 나무")

        // when & then
        val message = assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.message
        assertThat(message).isEqualTo("진작 대출되어 있는 책입니당.")
    }

    @Test
    @DisplayName("책 반납이 정상 동작한다.")
    fun returnBookTest() {
        // given
        bookRepository.save(Book.fixture("세상의 중심에서 사랑을 외치다"))
        val savedUser = userRepository.save(
            User(
                "나가사와 마사미",
                19
            )
        )
        userLoanHistoryRepository.save(UserLoanHistory.fixture(savedUser, "세상의 중심에서 사랑을 외치다"))
        val request = BookReturnRequest("나가사와 마사미", "세상의 중심에서 사랑을 외치다")

        // when
        bookService.returnBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].status).isEqualTo(UserLoanStatus.RETURNED)
    }

    @Test
    @DisplayName("책 대여 권수를 정상 확인한다.")
    fun countLoanedBookTest() {
        // given
        // 1) 대출 중인 상태인 것, 대출 중인 상태가 아닌 것
        val savedUser = userRepository.save(User("김부익", 31))
        userLoanHistoryRepository.saveAll(listOf(
            UserLoanHistory.fixture(savedUser, "노드"),
            UserLoanHistory.fixture(savedUser, "postgresql", UserLoanStatus.RETURNED),
            UserLoanHistory.fixture(savedUser, "최애의아이", UserLoanStatus.RETURNED),
        ))

        // when
        val result = bookService.countLoanedBook()

        // then
        assertThat(result).isEqualTo(1)
    }

    @Test
    @DisplayName("분야별 책 권수를 정상 확인한다.")
    fun getBookStatisticsTest() {
        // given
        bookRepository.saveAll(listOf(
            Book.fixture("노드", BookType.COMPUTER),
            Book.fixture("postgesql", BookType.COMPUTER),
            Book.fixture("최애의아이", BookType.MYSTERY)
        ))

        // when
        val results = bookService.getBookStatistics()

        // then
        assertThat(results).hasSize(2)
//        val computerDto = results.first { result -> result.type == BookType.COMPUTER }
//        assertThat(computerDto.count).isEqualTo(2)
        assertCount(results, BookType.COMPUTER, 2L)

//        val mysteryDto = results.first { result -> result.type == BookType.MYSTERY }
//        assertThat(mysteryDto.count).isEqualTo(1)
        assertCount(results, BookType.MYSTERY, 1L)
    }

    private fun assertCount(results: List<BookStatResponse>, type: BookType, count: Long) {
        assertThat(results.first { result -> result.type == type}.count).isEqualTo(count)
    } // 요 함수를 맹글어 위의 코드를 리팩토링 가능.
      // (then절에 있는 반복된 구문을 private function으로 통일함으로써 좀더 깔끔한 코드를 맹글 수 잇다~)
}