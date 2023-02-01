-- DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL(제약조건, 시퀀스없음)
-- DML(outer join, and;&&, or;||, 일부단일행함수)
-- Java에서 쓸 데이터 넣고 연습해보기

show databases; -- database들의 리스트
-- ★ ★ ★ DCL
create user user01 identified by 'password'; -- 계정 생성
grant all on *.* to user01; -- 권한 부여
grant all privileges on *.* to user01;
flush privileges;
revoke all on *.* from user01; -- 권한 박탈
drop user user01; -- 계정 삭제

-- 데이터베이스로 들어가는 작업
show databases;
create database kimdb; -- 새로운 데이터 베이스 생성 (kimdb)
use kimdb;
select database(); -- 현재 들어와 있는 데이터 베이스
use world;
select database();
use kimdb;
show databases;
show tables; -- 현재 들어와 있는 데이터베이스 내의 테이블(대충 select * from tab;과 같음)

-- ★ ★ ★ DDL
create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique, -- 널 포함
    sal numeric(7,2) check(sal>0), -- 널 포함
    comm numeric(7,2) default 0
);
desc emp;
drop table if exists emp;
create table emp(
	empno numeric(4),
    ename varchar(20) not null,
    nickname varchar(20),
    sal numeric(7,2),
    comm numeric(7,2) default 0,
    primary key(empno),
    unique(nickname),
    check(sal>0)
);
select * from emp;
insert into emp values (1111, '홍', '천사', 900, null);
select * from emp;
drop table if exists emp;

-- MAJOR (mCode;pk학과번호, mName학과이름, mOffice학과사무실)
-- STUDENT (sNo학번, name이름, mCode학과번호)
create table major(
	mCode int primary key auto_increment, -- auto_increment 필드의 경우 int
    mName varchar(30),
	mOffice varchar(30)
);
create table student(
	sNo numeric(4) primary key,
    sName varchar(30),
    mCode int references major(mCode)
);
select * from student;
select * from major;
insert into major (mName, mOffice) values ('컴공', '203호'); -- 컴공번호 1
insert into major (mName, mOffice) values ('빅데이터', '303호'); -- 2
insert into major (mName, mOffice) values ('디자인', '403호'); -- 3
select * from major;
insert into student values (1111, '홍길동', 1);
insert into student values (1112, '신길동', 3);
insert into student values (1113, '김길동', 4);
select * from student;
drop table if exists major;
drop table if exists student;
create table major(
	mCode int primary key auto_increment, -- auto_increment 필드의 경우 int
    mName varchar(30),
	mOffice varchar(30)
);
create table student(
	sNo numeric(4),
    sName varchar(30),
    mCode int,
    primary key(sNo),
    foreign key(mCode) references major(mCode) -- 외래키 제약조건은 아래만
);
insert into major (mName, mOffice) values ('컴공', '203호'); -- 컴공번호 1
insert into major (mName, mOffice) values ('빅데이터', '303호'); -- 2
insert into major (mName, mOffice) values ('디자인', '403호'); -- 3
insert into student values (1111, '홍길동', 1);
insert into student values (1112, '신길동', 3);
insert into student values (1113, '김길동', 4); -- 에러
select * from student;
-- 학번, 이름, 학과번호, 학과명, 학과사무실
select sNo, sName, s.mCode, mName, mOffice
	from student s, major m
    where s.mCode=m.mCode;
-- 학번, 이름, 학과번호, 학과명, 학과사무실(학생이 없는 학과도 출력)
select sNo, sName, s.mCode, mName, mOffice
	from student s right outer join major m
    on s.mCode=m.mCode;
select sNo, sName, length(sName) from student;

-- ★ ★ ★ ★ ★ 자바(JDBC) 수업시간에 쓸 테이블 ★ ★ ★ ★ ★
drop table if exists personal;
drop table if exists division;
create table division(
	dno int, -- 부서번호
    dname varchar(20), -- 부서이름
    phone varchar(20), -- 부서전화
    position varchar(20), -- 부서위치
    primary key(dno)
);
create table personal(
	pno int, 					-- 사번
    pname varchar(20) not null, -- 사원명
    job varchar(20) not null,   -- 직책
    manager int, 				-- 상사의 사번
    startdate date,			    -- 입사일
    pay int,   -- 월급
    bonus int, -- 상여금
    dno int,   -- 부서번호
    primary key(pno),
    foreign key(dno) references division(dno)
);
insert into division values (10, 'finance', '02-393-4321', '서대문');
insert into division values (20, 'research', '02-555-4321', '강남');
insert into division values (30, 'sales', '02-717-4321', '마포');
insert into division values (40, 'cs', '031-4444-4321', '안양');
select * from division;
commit;
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
select pno, pname, pay, pay*12+ifnull(bonus,0) from personal;
select pno, pname, bonus, if(bonus is null, 0, bonus) from personal;
commit;

-- ★ ★ ★ DML ★ ★ ★
use kimdb;
select database();

-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal;

-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal where pay between 2000 and 5000;
select * from personal where 2000<=pay && pay<=5000; -- and

-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno 
	from personal
    where dno in (10,20);
    
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay
	from personal
    where bonus is null
    order by pay;

-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay
	from personal
	order by dno, pay desc;

-- 6. 사번, 이름, 부서명
select pno, pname, dname
	from personal p , division d
    where p.dno=d.dno;
    
-- 7. 사번, 이름, 상사이름
select w.pno, w.pname, m.pname manager
	from personal w, personal m
    where w.manager=m.pno;
    
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pno, w.pname, m.pname "manager"
	from personal w left outer join personal m
    on w.manager=m.pno;

-- 8.1 사번, 이름, 상사이름, 부서명
select w.pno, w.pname, m.pname "manager", dname
	from division d, personal w left outer join personal m
		on w.manager=m.pno
    where d.dno=w.dno;
    
-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal where pname like 's%';
select pname from personal where substr(pname, 1, 1)='s';

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, dname, m.pname manager
	from personal w, personal m, division d
    where w.manager=m.pno && w.dno=d.dno;

-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
	from personal
    group by dno;

-- 12. 부서명, 급여평균, 인원수
select dname, avg(pay), count(*)
	from personal p, division d
    where p.dno=d.dno
    group by dname;

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay), count(*)
	from personal
	group by dno
    having count(*)>=4;
        
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
	from personal
    where pay = (select max(pay) from personal);

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno
	from personal
    where pay > (select avg(pay) from personal);
        
-- 16. 회사 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서명을 출력(부서명순 정렬 같으면 급여 큰순 정렬)
select pno, pname, pay, dname
	 from personal p, division d
     where p.dno=d.dno
		and pay > (select avg(pay) from personal)
	order by dname, pay desc;

-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균
select pname, pay, dno, (select round(avg(pay)) from personal where p.dno=dno) "avg"
	from personal p
	where pay > (select avg(pay) from personal where p.dno=dno);
    
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
 select pname, pay, dname
	from personal p, division d
    where p.dno=d.dno
		and startdate = (select min(startdate) from personal);
    
-- 19. 이름, 급여, 해당부서평균
select pname, pay, (select avg(pay) from personal where p.dno=dno) dnoavg
	from personal p ; -- 서브쿼리 이용

-- 20. 이름, 급여, 부서명, 해당부서평균
select pname, pay, dname, (select avg(pay) from personal where p.dno=dno)
	from personal p, division d
    where p.dno=d.dno;
select pname, pay, dname, dnoavg
	from personal p, division d,
		(select dno, avg(pay) dnoavg from personal group by dno) a
    where p.dno=d.dno and p.dno=a.dno;

-- ★ ★ ★ Oracle에서의 단일행함수와 다른 부분
select curdate();
insert into personal values
	(1000, '홍길동', 'manager', 1001, curdate(), null, null, 40);
select * from personal where pno=1000;
set sql_safe_updates = 0;
delete from personal where pname='홍길동';

	-- ex. "이름은 job이다"
select concat(pname,'는 ', job, '이다') msg from personal;
select round(35.678); -- from절이 없이도 실행 가능

-- 시스템으로부터 현재 시점, 현재 날짜, 현재 시간
select sysdate(); -- 현재 시점
select now();
select year(sysdate()), month(now()), day(now()), hour(now()),
		minute(now()), second(now());
select case weekday(now())
	when '0' then '월요일'
	when '1' then '화요일'
    when '2' then '수요일'
    when '3' then '목요일'
    when '4' then '금요일'
    when '5' then '토요일'
	when '6' then '일요일' end dayofweek;
select dayname(now());
select pname, dayname(startdate) from personal; -- 이름, 입사한 날의 요일
select monthname(now());
select pname, monthname(now()) from personal;
select date(now()), time(now());
select pname, year(startdate), month(startdate), day(startdate) from personal;

-- 시스템으로부터 현재 날짜
select current_date();
select curdate();
-- 시스템으로부터 현재 시간
select current_time();
select curtime();

-- date_format(날짜/시간, 포맷) => 문자
-- date_format(문자, 포맷) => 날짜
	-- 포맷 : %Y 2023(년도4자리) %y 23(년도2자리)
	--   	 %m (01월, 02월, ...) %c (1,2, ...) %M 월이름(January), %b 짧은월이름(Jan)
    -- 		 %d (01, 02, 03, ..) %e (1, 2, 3, ..)
    -- 		 %H (24시간) %h (12시간) %p (오전, 오후) %i분 %s초
select date_format(now(), '%Y년 %c월 %e일 %p %h시 %i분 %s초') now;
select * from personal where startdate < '1990-08-08';
select * from personal
	where startdate < date_format('1990-08-10', '%Y-%m-%d');

-- format(숫자, 소수점자릿수) -> 문자
select pname, format(pay, 2) from personal; -- 소수점 2자리까지 나오고 세자리마다 ,
select pname, format(pay, 0) from personal;

-- 이름, 급여, 급여 3000이상인지 여부
select pname, pay, if(pay>=3000, '이상', '이하') result from personal;
select pname, pay, bonus, if(bonus is null, 0, bonus) from personal;
select pname, bonus, ifnull(bonus, 0) from personal;

-- ★ ★ ★ top-n 구문 (rownum이 없고, limit 이용)
select pname, pay from personal order by pay desc;
-- limit n (1 ~ n등)
select pname, pay from personal order by pay desc limit 5;
-- limit n1, n2 (n1번째부터 n2개)
select pname, pay from personal order by pay desc limit 0, 5; -- 1등부터 5개
select pname, pay from personal order by pay desc limit 5, 5; -- 6등부터 5개
select pname, pay from personal order by pay desc limit 6, 3; -- 7등부터 3개

use kimdb;
select * from personal;




