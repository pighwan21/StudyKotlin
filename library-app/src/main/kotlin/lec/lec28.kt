package lec

// 28강. SQL join에 대해 알아보자.

// 쿼리 한 번으로 두 테이블의 결과를 한 번에 볼 수 없을까?
// -> join을 이용하자!
// ex)
// select * from user join user_loan_history    // user: 기준 테이블, user_loan_history: 합쳐지는 테이블 - user테이블을 기준으로 user_loan_history을 합친다.
// on user.id = user_loan_history.user_id       // 합쳐지는 조건

// join을 사용할 때 '별칭'을 줄 수도 있다. - 별칭은 마치 변수처럼 우리가 임의로 정할 수 있음.
// ex)
// select * from user u join user_loan_history ulh
// on u.id = ulh.user_id

// 그런데 이렇게 하면 3번 유저에 대한 결과가 없다. 사실은 우리가 사용한 join이 inner join이었기 때문이다.
// * inner join : 테이블 양쪽에 데이터가 모두 존재하는 경우에만 하나로 합쳐준다.
// 위의 select * from user u join user_loan_history ulh
//     on u.id = ulh.user_id
// 사실은 select * from user u inner join user_loan_history ulh
//       on u.id = ulh.user_id 였기 때문이다.

// 합쳐지는 테이블에는 데이터가 없더라도 보여주고 싶다면?
// -> left join
// - left join을 사용하면 위의 inner join 한 데이터에 추가로 데이터가 없던 3번 유저에 대한 정보도 나온다.(대신 데이터에는 null값이 들어감)
// ex)
// select * from user u left join user_loan_history ulh
// on u.id = ulh.user_id
// User를 기준으로 데이터를 조회하였기 때문에 3번 유저에 대해 null로써 정보가 존재한다.(기준테이블이 left join에서는 중요함!!!!)




