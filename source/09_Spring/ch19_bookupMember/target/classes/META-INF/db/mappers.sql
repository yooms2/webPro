-- ★ ★ ★ ★ ★ book.xml ★ ★ ★ ★ ★
-- id = mainList (신간도서순 bookList)
SELECT * FROM BOOK ORDER BY bRDATE DESC;
-- id =bookList (startRow~endRow까지 bookList) 출력순서:bTITLE 기준
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bTITLE) A)
    WHERE RN BETWEEN 2 AND 4;
-- id totCntBook (등록된 책 개수)
SELECT COUNT(*) FROM BOOK;
-- id public Book getDetailBook(int bnum)
SELECT * FROM BOOK WHERE bNUM = 1;
-- id registerBook (책등록)
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'AOP', '홍현', SYSDATE, 'noImg.png', 'noImg.png', 'aop 개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'API', '제이', SYSDATE, 'noImg.png', '리소스 개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'ORACLE', '홍가', SYSDATE, 'noImg.png', '디비개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'SPRING', '이바', SYSDATE, '스프링개념서');
-- public int modifyBook (책수정)
UPDATE BOOK SET bTITLE = '수정제목',
                bWRITER = '수정가'
    WHERE bNUM = '1';
-- ★ ★ ★ ★ ★ member.xml ★ ★ ★ ★ ★
-- id = idConfirm (mid가 id인 데이터 개수) : public int idConfirm(String mid);
SELECT COUNT(*) FROM MEMBER WHERE MID = 'aaa';
-- id = joinMember(회원가입)
INSERT INTO MEMBER VALUES ('aaa', '1', '홍길동', 'hong@naver.com', '12345', '서울');
-- id = getDetailMember(mid로 Member dto가져오기)
SELECT * FROM MEMBER WHERE MID = 'aaa';
-- id = modifyMember(회원정보 수정)
UPDATE MEMBER SET mPW = '1111',
                mNAME = '홍길동',
                mMAIL = 'hong@hong.com'
    WHERE mID = 'aaa';