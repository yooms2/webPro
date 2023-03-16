--------------------------------------------------------------------------------
---------------------------- MemberDao에 들어갈 query ----------------------------
--------------------------------------------------------------------------------
-- (1) 회원id 중복체크
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa';
-- (2) 회원 EMAIL 중복체크
SELECT COUNT(*) CNT FROM MVC_MEMBER WHERE MEMAIL = 'hong@naver.com';
-- (3) 회원가입
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('aaa','1','홍길동','hong@naver.com','NOIMG.JPG','1998/12/12','서대문');
COMMIT;
-- (4) 로그인
SELECT * FROM MVC_MEMBER WHERE mID='aaa' and mPW='1';
-- (5) mid로 dto가져오기(로그인 성공시 session에 넣기 위함)
SELECT * FROM MVC_MEMBER WHERE MID='aaa';
-- (6) 회원정보 수정
UPDATE MVC_MEMBER
    SET MPW = '1',
        MNAME = '송중기',
        MEMAIL = 'SONG@S,COM',
        MPHOTO = 'NOIMG.JPG',
        MBIRTH = '1995-12-12',
        MADDRESS = '서대문'
    WHERE MID = 'song';
-- (7) 회원 리스트(top-n)
SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC; -- 신입회원순
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A)
    WHERE RN BETWEEN 4 AND 6;
-- (8) 전체 등록된 회원수
SELECT COUNT(*) CNT FROM MVC_MEMBER;
-- (9) 회원탈퇴
DELETE FROM MVC_MEMBER WHERE MID = 'aaa';
COMMIT;

--------------------------------------------------------------------------------
----------------------------- BoardDao에 들어갈 query ----------------------------
--------------------------------------------------------------------------------
-- (1) 글목록(startRow ~ endRow)
SELECT * FROM FILEBOARD ORDER BY fGROUP DESC, fSTEP;
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM FILEBOARD ORDER BY fGROUP DESC, fSTEP) A)
    WHERE RN BETWEEN 1 AND 2;
-- (2) 글개수
SELECT COUNT(*) FROM FILEBOARD;
-- (3) 글쓰기(원글쓰기)
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'song', '제목2', '본문2', NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '198.168.0.5');
-- (4) hit 1회 올리기
UPDATE FILEBOARD SET fHIT = fHIT + 1 WHERE fID = '1';
-- (5) 글번호(fid)로 글전체 내용(BoardDto) 가져오기
SELECT * FROM MVC_MEMBER M, FILEBOARD F WHERE fID = '1';
SELECT F.*, mNAME
    FROM MVC_MEMBER M, FILEBOARD F
    WHERE M.mID=F.mID
        AND fID = '1';


SELECT F.*, mNAME
    FROM FILEBOARD F, MVC_MEMBER M
    WHERE F.mID=M.mID AND fID = 1;


-- (6) 글 수정하기(fid, ftitle, fcontent, ffilename, frdate(SYSDATE), fip 수정)
UPDATE FILEBOARD
    SET fTITLE = '수정제목',
        fCONTENT = '수정글',
        fFILENAME = '2.TXT',
        fIP = '198.168.0.0'
    WHERE fID = '1';
SELECT * FROM FILEBOARD;
-- (7) 글 삭제하기(fid로)
DELETE FROM FILEBOARD WHERE fID = '2';
-- (8) 답변글 쓰기 전 단계(원글의 fgroup과 같고, 원글의 fstep보다 크면 fstep을 하나 증가하기)
UPDATE FILEBOARD SET fSTEP = fSTEP + 1
    WHERE fGROUP = 3 AND fSTEP > 0;
-- (9) 답변글 쓰기
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'song', '제목', '본문', NULL, 1, 1, 1, '198.168.0.5');
-- (10) 회원탈퇴시 탈퇴하는 회원(mid)이 쓴 글 모두 삭제하기
DELETE FROM FILEBOARD WHERE mID = 'son';
COMMIT;

--------------------------------------------------------------------------------
----------------------------- AdminDao에 들어갈 query ----------------------------
--------------------------------------------------------------------------------
-- (1) admin 로그인
SELECT * FROM ADMIN WHERE aID = 'admin' AND aPW = '1';
-- (2) 로그인 후 세션에 넣을 용도 admin aid로 AdminDto 가져오기
SELECT * FROM ADMIN WHERE aID = 'admin';
COMMIT;










