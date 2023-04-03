---------------------------------------------------------------------------ADMIN
-- (1) AID 중복체크
SELECT * FROM ADMIN WHERE aID = 'admin1';
-- (2) ADMIN 등록
INSERT INTO ADMIN VALUES ('admin3', '1234', '관리자3');
-- (3) ADMIN 삭제
DELETE FROM ADMIN WHERE aID = 'admin3';
COMMIT;

--------------------------------------------------------------------------MEMBER
-- (1) MID 중복체크
SELECT * FROM MEMBER WHERE mID = 'aaaa';
-- (2) MEMAIL 중복체크
SELECT * FROM MEMBER WHERE mEMAIL = 'hong@naver.com';
-- (3) 회원가입
INSERT INTO MEMBER (mID, mPW, mNAME, mNICKNAME, mTEL, mEMAIL, mBIRTH, mGENDER, mADDRESS)
    VALUES ('eeee', '1111', '홍길정', '정정정', '010-4444-5678', 'hhhh@naver.com', '1999-12-25', 'f', '경기도 용인시');
-- (4) 로그인
SELECT * FROM MEMBER WHERE mID = 'aaaa' AND mPW = '1111';
-- (5) MID로 DTO가져오기(로그인 성공시 session 추가)
SELECT * FROM MEMBER WHERE mID = 'aaaa';
-- (6) 정보수정
UPDATE MEMBER
    SET mPW = '2222',
        mNICKNAME = 'HONG',
        mEMAIL = 'ho@ho.com',
        mADDRESS = '경기도 의정부시'
    WHERE mID = 'aaaa';
-- (7) 회원 리스트
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MEMBER ORDER BY mRDATE DESC) A)
    WHERE RN BETWEEN 1 AND 3; 
-- (8) 회원수
SELECT COUNT(*) CNT FROM MEMBER;
-- (9) 회원탈퇴
DELETE FROM MEMBER WHERE mID = 'eeee';
COMMIT;

---------------------------------------------------------------------------BOARD
-- (1) 글목록(startRow ~ endRow)
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT B.*, mNAME FROM BOARD B, MEMBER M
                                        WHERE B.mID=M.mID ORDER BY bGROUP DESC, bSTEP) A)
    WHERE RN BETWEEN 1 AND 2;
-- (2) 글개수
SELECT COUNT(*) FROM BOARD;
-- (3) 원글쓰기
INSERT INTO BOARD (bID, mID, bTITLE, bCONTENT, bFILENAME, bHIT, bGROUP, bSTEP, bINDENT)
    VALUES (BOARDNUM_SEQ.NEXTVAL, 'cccc', '제목3', '내용3', NULL, 0, BOARDNUM_SEQ.CURRVAL, 0, 0);
-- (4) 조회수 올리기
UPDATE BOARD SET bHIT = bHIT + 1 WHERE bID = '1';
-- (5) 글번호로 DTO가져오기(글 상세보기) + 글수정/답변글 VIEW
SELECT B.*, mNAME
    FROM BOARD B, MEMBER M WHERE B.mID=M.mID AND bID = '1';
-- (6) 글 수정하기
UPDATE BOARD
    SET bTITLE = '수정글',
        bCONTENT = '수정내용',
        bFILENAME = NULL,
        bRDATE = SYSDATE
    WHERE bID = '1';
-- (7) 답변글 쓰기 전(원글의bGROUP, 원글bSTEP보다 크면 fSTEP 증가)
UPDATE BOARD SET bSTEP = bSTEP + 1
    WHERE bGROUP = 1 AND bSTEP > 0;
-- (8) 답변글쓰기
INSERT INTO BOARD (bID, mID, bTITLE, bCONTENT, bFILENAME, bGROUP, bSTEP, bINDENT)
    VALUES (BOARDNUM_SEQ.NEXTVAL, 'cccc', '1답글', '답글내용', '3.docx', 1, 1, 1);
-- (10) 회원탈퇴시 작성글 모두 삭제
DELETE FROM BOARD WHERE mID = 'aaaa';

-------------------------------------------------------------------------PRODUCT
-- (1) 상품목록
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM PRODUCT ORDER BY pID DESC) A)
    WHERE RN BETWEEN 2 AND 3;
-- (2) 상품 검색
SELECT * FROM PRODUCT
    WHERE pNAME LIKE '%'||TRIM(UPPER(' 상 '))||'%';
-- (3) 상품등록
INSERT INTO PRODUCT VALUES (PRONUM_SEQ.NEXTVAL, '오렌지 맨투맨', 40000, 'M사이즈', '남성용', '5-1.png', '5-2.png', NULL);
-- (4) 상품수정
UPDATE PRODUCT
    SET pNAME = '검정 니트',
        pPRICE = '78000',
        pSIZE = '105사이즈',
        pCATEGORY = '남성용',
        pAIMAGE = '니트 대표사진',
        pBIMAGE = '니트 상세사진',
        pCONTENT = '검정색 울 니트'
    WHERE pID = '1';
-- (5) 상품삭제
DELETE FROM PRODUCT WHERE pID = '6';

------------------------------------------------------------------------WISHLIST
-- (1) 관심목록 리스트(startRow ~ endRow)
SELECT W.*, mNAME, pNAME
    FROM WISHLIST W, MEMBER M, PRODUCT P 
    WHERE W.mID=M.mID AND W.pID=P.pID;
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT W.*, mNAME, pNAME
                                        FROM WISHLIST W, MEMBER M, PRODUCT P 
                                        WHERE W.mID=M.mID AND W.pID=P.pID ORDER BY wID DESC) A)
    WHERE RN BETWEEN 1 AND 5 AND mID = 'bbbb';
-- (2) 관심목록 개수(mID)
SELECT COUNT(*) FROM WISHLIST WHERE mID = 'aaaa';
-- (3) 관심목록 삭제(wID)
DELETE FROM WISHLIST WHERE mID = 'aaaa' AND wID = '1';
-- (4) 회원탈퇴시 관심목록 모두 제거
DELETE FROM WISHLIST WHERE mID = 'aaaa';
COMMIT;




