-- [VIII] Sequence : ������ȣ ������. ��κ� �������� PK ��� �뵵
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    START WITH 1 -- 1���� ����
    INCREMENT BY 1 -- 1�� ����
    MAXVALUE 9999 -- �ִ밪
    MINVALUE 1 -- �ּҰ�
    NOCACHE
    NOCYCLE;
SELECT FRIEND_SEQ.NEXTVAL FROM DUAL; -- ���� ������ȣ
SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- �������� ���� ��
DROP SEQUENCE FRIEND_SQ;
CREATE SEQUENCE FRIEND_SQ MAXVALUE 9999 NOCACHE NOCYCLE;
DROP TABLE FRIEND;
CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY, -- ������ �̿�
    NAME VARCHAR2(30) NOT NULL,
    TEL VARCHAR2(20) UNIQUE, -- UNIQUE:����, NULL ���
    ADDRESS VARCHAR2(250),
    LAST_MODIFIED DATE DEFAULT SYSDATE -- ����������
);
SELECT * FROM FRIEND;
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SQ.NEXTVAL, 'ȫ�浿', NULL, '����� ���빮��'); -- ���
SELECT * FROM FRIEND;
-- INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
   -- VALUES (FRIEND_SQ.NEXTVAL, NULL, '010-9999-9999', '����� ������'); -- ����(NOT NULL)
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SQ.NEXTVAL, '��浿', '010-9999-9999', '����� ������');
-- INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    -- VALUES (FRIEND_SQ.NEXTVAL, '�ű浿', '010-9999-9999', '����� ��������'); -- ����(UNIQUE)
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SQ.NEXTVAL, '���浿', '010-8888-8888', '������ ���뱸');
SELECT * FROM FRIEND;
    -- ex. �ʱⰪ 101���� �ִ밪 999,999���� 1�� �����ϴ� test_seq �������� �����ϰ� ������ ���� ����Ͻÿ�
CREATE SEQUENCE TEST_SEQ 
    START WITH 101
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;
SELECT TEST_SEQ.NEXTVAL FROM DUAL;
SELECT TEST_SEQ.CURRVAL FROM DUAL;

-- MEMBER && MEMBERLEVEL
DROP TABLE MEMBER;
DROP TABLE MEMBERLEVEL;
DROP SEQUENCE MEMBER_MNO_SQ;
CREATE SEQUENCE MEMBER_MNO_SQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;
CREATE TABLE MEMBER_LEVEL (
    LEVELNO NUMBER(1) PRIMARY KEY,
    LEVELNAME VARCHAR2(10) NOT NULL
);
INSERT INTO MEMBER_LEVEL VALUES (-1, 'black');
INSERT INTO MEMBER_LEVEL VALUES (0, '�Ϲ�');
INSERT INTO MEMBER_LEVEL VALUES (1, '�ǹ�');
INSERT INTO MEMBER_LEVEL VALUES (2, '���');
SELECT * FROM MEMBER_LEVEL;

CREATE TABLE MEMBER (
    mNO NUMBER(1) PRIMARY KEY,
    mNAME VARCHAR2(20) NOT NULL,
    mPW VARCHAR2(15) CHECK(1<=LENGTH(mPW) AND LENGTH(mPW)<=8),
    mEMAIL VARCHAR2(100) UNIQUE,
    mPOINT NUMBER(10) CHECK(mPOINT>=0),
    mRDATE DATE DEFAULT SYSDATE,
    LEVELNO NUMBER(1),
    FOREIGN KEY(LEVELNO) REFERENCES MEMBER_LEVEL(LEVELNO)
);
INSERT INTO MEMBER VALUES (MEMBER_MNO_SQ.NEXTVAL, 'ȫ�浿', 'aa', 'hong@hong.com', 0, '22/03/10', 0);
INSERT INTO MEMBER VALUES (MEMBER_MNO_SQ.NEXTVAL, '�ű浿', 'bb', 'sin@sin.com', 1000, '22/04/01', 1);
SELECT * FROM MEMBER;

SELECT mNO, mNAME, TO_CHAR(mRDATE, 'YYYY-MM-DD') mRDATE, mEMAIL, mPOINT point, LEVELNAME||'����' levelname
    FROM MEMBER M, MEMBER_LEVEL L
    WHERE M.LEVELNO=L.LEVELNO;



