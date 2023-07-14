package lec

// 34강. 다양한 SQL을 알아보자!

// 살펴볼 SQL 종류
// - sum, avg, count, group by, order by

// 1. sum 쿼리
// - 주어진 column의 합계를 계산한다.
// ex) select sum(age) from user;

// 2. avg 쿼리
// - 주어진 column의 평균을 계산한다.
// ex) select avg(age) from user;

// 3. count 쿼리
// - 주어진 column의 갯수를 센다.
// ex) select count(*) from user;

// 4. group by 쿼리
// - 주어진 column을 기준으로 데이터를 그룹핑 한다.(groupBy와 유사)
// ex) select type, count(1) from book group by type;

// 5. order by 쿼리
// - 주어진 column을 정렬을 한다. 내림차순, 오름차순을 지정할 수 있다.
// ex) select * from book order by type desc;
//     select * from book order by type asc;