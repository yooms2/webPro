-- 회원(CUSTOMER) 테이블 - 6개(aaa,bbb,ccc,ddd,eee,fff)
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('aaa', '111', '홍길동', '010-1111-1111', 'hong@hong.com', '경기 성남시', 'm', '1992/03/12');
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('bbb', '111', '한길동', '010-2222-2222', 'hong@hong.com', '경기 수원시', 'm', '1994/05/31');
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('ccc', '111', '유길동', '010-3333-3333', 'hong@hong.com', '경기 용인시', 'f', '1998/07/17');
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('ddd', '111', '신길동', '010-4444-4444', 'hong@hong.com', '서울 강남구', 'm', '1999/08/12');
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('eee', '111', '장길동', '010-5555-5555', 'hong@hong.com', '서울 강서구', 'f', '2002/11/11');
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('fff', '111', '양길동', '010-6666-6666', 'hong@hong.com', '서울 서대문구', 'm', '2004/01/11');
    
-- 파일첨부게시판(FILEBOARD) 테이블 - 3개(글1, 글2, 글2-1) - 하나는 첨부파일 1.docx이 있는 걸로
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '글1', '본문', '1.docx', '111', 0, 1, 0, 0, '192.168.0.1');
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', '글2', '본문', NULL, '111', 0, 2, 0, 0, '192.168.0.1');
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '글2-1', '본문', NULL, '111', 0, 2, 1, 1, '192.168.0.1');
    
-- 도서(BOOK) 테이블 dummy data - 15개
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내일의 부', 16000, '100.jpg', 'noImg.png', '좋아', 10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '3층 서기실의 암호', 20000, '101.jpg', 'noImg.png', '태영호 증언', 10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '당신이 글을 쓰면 좋겠습니다', 14000, '102.jpg', 'noImg.png', '좋아', 5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '울트라러닝',16000,'103.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내가 왔다',11500,'104.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '나의 서툰 위로가 너에게 닿기를',13000,'105.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '아직 멀었다는 말',13500,'106.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '소금 지방 산열',33000,'107.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '디레버리징',20000,'108.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '너와 나의 암호말',18000,'109.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '오늘도 펭수, 내일도 펭수',17000,'110.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '지적대화를 위한 넓고 얕은 지식2',1600,'111.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '트렌드코리아 2020',2000,'112.jpg','noImg.png','2020 트렌드 키워드 ',15);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '여행의 이유',1800,'113.jpg','noImg.png','김영하의 여행 경험',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '작은 아씨들',2000,'114.jpg','noImg.png','좋다 ',10);

COMMIT;