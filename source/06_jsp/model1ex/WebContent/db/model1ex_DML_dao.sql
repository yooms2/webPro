-- CustomerDao(아이디중복체크, 회원가입, 상세보기(pk로 dto 가져오기), 로그인, 정보수정, top-N 리스트, 회원수)
-- 1. 아이디 중복체크 : public int confirmId(String cid)
SELECT COUNT(*) FROM CUSTOMER WHERE CID='aaa';
-- 2. 회원가입 : public int joinCustomer(CustomerDto dto)
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('aaa', '111', '홍길동', '010-1111-1111', 'hong@hong.com', '경기 성남시', 'm', '1992/03/12');
-- 3. 상세보기(pk로 dto 가져오기) : public CustomerDto getCustomer(String cid)
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- 4. 로그인 : public int loginCustomer(String cid, String cpw)
SELECT CID, CPW FROM CUSTOMER WHERE CID = 'aaa' AND CPW = '111';
-- 5. 정보수정 : public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET CPW = '111',
                    CNAME = '홍길동',
                    CEMAIL = 'ho@ho.com',
                    CADDRESS = '성남시 분당구',
                    CGENDER = 'f',
                    CBIRTH = '1999/09/09'
    WHERE CID = 'aaa';
-- 6. top-N 리스트
SELECT * FROM CUSTOMER ORDER BY CRDATE DESC;
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM CUSTOMER ORDER BY CRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 3;
-- 7. 회원수
SELECT COUNT(*) FROM CUSTOMER;


-- FileboardDao(top-N 리스트, 글개수, 글쓰기(원글1, 답변글2개query), hit올리기, 글상세보기, 글수정, 글삭제)
-- 1. 글목록(top-N 리스트 : startRow부터 endRow까지)
    SELECT F.*, CNAME, CEMAIL
        FROM FILEBOARD F, CUSTOMER C  
        WHERE F.CID = C.CID
        ORDER BY FREF DESC, FRE_STEP; -- 전체 출력
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
            FROM (SELECT F.*, CNAME, CEMAIL
                        FROM FILEBOARD F, CUSTOMER C  
                        WHERE F.CID = C.CID
                        ORDER BY FREF DESC, FRE_STEP) A )
    WHERE RN BETWEEN 3 AND 4; -- 완성된 top-N
    
-- 2. 등록된 글 수
SELECT COUNT(*) FROM FILEBOARD;

-- 3. 원글쓰기
INSERT INTO FILEBOARD (fNUM, CID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '글3','본문3',null,'1', 
            FILEBOARD_SEQ.CURRVAL, 0,0,'198.12.1.1');
SELECT * FROM FILEBOARD WHERE FNUM=4; -- 방금 쓴 원글 4번글

-- 4. 답변글 쓰기전 step A -- 4번글에 대한 답변글 쓰기 전작업
UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1 WHERE fREF=4 AND fRE_STEP>0;

-- 5. 답변글 쓰기 -- 4번글의 답변
INSERT INTO FILEBOARD (fNUM, CID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', '글3-답1', null,null, '1', 4, 1, 1, '192.1.1.1');
    
SELECT * FROM FILEBOARD WHERE fREF = 4 ORDER BY FRE_STEP; -- 4번 그룹 확인

-- 6. 글 상세보기(fnum으로 dto가져오기)
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID=C.CID AND fNUM=4;

-- 7. 조회수 올리기
UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM=4;

-- 8. 글 수정하기
UPDATE FILEBOARD SET fSUBJECT = '수정된 제목',
                    fCONTENT = '수정된 본문',
                    fFILENAME = NULL,
                    fPW = '1',
                    fIP = '192.168.10.30'
                WHERE fNUM=4;
                
-- 9. 글 삭제하기
COMMIT;
DELETE FROM FILEBOARD WHERE fNUM=1 AND fPW='1';
ROLLBACK;


-- BookDao(top-N 리스트, 책개수, 책등록, 상세보기)
-- 1. top-N 리스트
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 3;
-- 2. 책개수
SELECT COUNT(*) FROM BOOK;
-- 3. 책등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '작은 아씨들',2000,'114.jpg','noImg.png','좋다 ',10);
-- 4. 상세보기(pk로 dto 가져오기)
SELECT * FROM BOOK WHERE BID = 21;

COMMIT;