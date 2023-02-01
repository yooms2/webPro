-- 테이블 및 시퀀스 삭제
DROP SEQUENCE PERSON_NO_SQ;
DROP TABLE PERSON;
DROP TABLE JOB;

-- 테이블 및 시퀀스 생성
CREATE TABLE JOB (
    jNO NUMBER(2,0) PRIMARY KEY,
    jNAME VARCHAR2(50)
);
CREATE TABLE PERSON (
    pNO NUMBER(5) PRIMARY KEY,
    pNAME VARCHAR2(50) NOT NULL,
    jNO NUMBER(2,0) NOT NULL,
    KOR NUMBER(3) CHECK(KOR>0),
    ENG NUMBER(3) CHECK(ENG>0),
    MAT NUMBER(3) CHECK(MAT>0),
    FOREIGN KEY(jNO) REFERENCES JOB(jNO)
);
CREATE SEQUENCE PERSON_NO_SQ
    NOCACHE
    NOCYCLE;
    
-- 더미데이터 insert (정우성 ~ 송혜교)
INSERT INTO JOB VALUES (10, '배우');
INSERT INTO JOB VALUES (20, '가수');
SELECT * FROM JOB;

INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, '정우성', 10, 90, 80, 81);
INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, '박세영', 10, 80, 90, 80);
INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, '배수지', 20, 20, 90, 90);
INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, '설수현', 20, 95, 95, 95);
INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, '송혜교', 10, 100, 100, 100);
SELECT * FROM PERSON;
COMMIT;

-- 기능별 query 작성 (1, 2, 3)
INSERT INTO PERSON 
    VALUES (PERSON_NO_SQ.NEXTVAL, '홍길동', (SELECT JNO FROM JOB WHERE JNAME='가수'), 81, 83, 85);

SELECT JNO, JNAME FROM JOB WHERE JNO=30;
-- SELECT PNAME||'('||PNO||'번'||')' 이름, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
--    FROM PERSON P , JOB J WHERE P.JNO=J.JNO
--    ORDER BY SUM DESC;
SELECT ROWNUM RN, A.*
    FROM (SELECT PNAME||'('||PNO||'번'||')' 이름, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
        FROM PERSON P , JOB J WHERE P.JNO=J.JNO AND JNAME='배우'
        ORDER BY SUM DESC) A;

SELECT ROWNUM RN, A.*
    FROM (SELECT PNAME||'('||PNO||'번'||')' 이름, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
        FROM PERSON P , JOB J WHERE P.JNO=J.JNO
        ORDER BY SUM DESC) A;


SELECT JNAME FROM JOB;





