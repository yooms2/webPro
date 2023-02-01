-- SHOPPING

DROP TABLE ORDERDETAIL;
DROP TABLE CART;
DROP TABLE PRODUCT;
DROP TABLE ORDERS;
DROP TABLE MEMBER;

DROP SEQUENCE CART_NO;
CREATE SEQUENCE CART_NO
    MAXVALUE 999
    NOCACHE
    NOCYCLE;

CREATE TABLE MEMBER (
    mID VARCHAR2(50) PRIMARY KEY,
    mNAME VARCHAR2(20) NOT NULL,
    mPW VARCHAR2(30),
    mTEL VARCHAR2(15) UNIQUE,
    mADDR VARCHAR2(150) NOT NULL,
    mEMAIL VARCHAR2(100) UNIQUE
);
INSERT INTO MEMBER VALUES ('abc', 'ȫ�浿','hong123', '010-9999-9999', '����� ���빮�� ������', 'hong@naver.com');
INSERT INTO MEMBER VALUES ('def', '��赿', 'kim123', '010-8888-8888', '��⵵ ������', 'kim@naver.com');
SELECT * FROM MEMBER;

CREATE TABLE ORDERS (
    oNO NUMBER(11) PRIMARY KEY,
    oNAME VARCHAR2(15),
    oADDR VARCHAR2(150) NOT NULL,
    oTEL VARCHAR2(15),
    oDATE DATE DEFAULT SYSDATE,
    mID VARCHAR2(50),
    FOREIGN KEY(mID) REFERENCES MEMBER(mID)
);
DELETE FROM ORDERS;
INSERT INTO ORDERS VALUES (230110001, 'ȫ�浿', '����� ���빮�� ������', '010-9999-9999', '23/01/10', 'abc');
INSERT INTO ORDERS VALUES (230110002, '��赿', '��⵵ ������', '010-8888-8888', '23/01/10', 'def');
INSERT INTO ORDERS VALUES (230112003, 'ȫ�ƺ�', '���ֵ� ���ֽ�', '010-7777-9999', '23/01/12', 'abc');
SELECT * FROM ORDERS;

CREATE TABLE PRODUCT (
    pCODE VARCHAR2(20) PRIMARY KEY,
    pNAME VARCHAR2(200),
    PRICE NUMBER(9),
    STOCK NUMBER(5)
);
INSERT INTO PRODUCT VALUES ('A1', '����', 3000, 1000);
INSERT INTO PRODUCT VALUES ('A2', '����ũ', 200, 10000);
INSERT INTO PRODUCT VALUES ('B1', '����', 3000, 5000);
INSERT INTO PRODUCT VALUES ('B2', '��¡��', 5000, 3000);
INSERT INTO PRODUCT VALUES ('C1', '�ҵ���', 7000, 7000);
SELECT * FROM PRODUCT;

CREATE TABLE ORDERDETAIL (
    QTY NUMBER(3),
    COST NUMBER(9),
    oNO NUMBER(11) NOT NULL,
    pCODE VARCHAR2(20) NOT NULL,
    FOREIGN KEY(oNO) REFERENCES ORDERS(oNO),
    FOREIGN KEY(pCODE) REFERENCES PRODUCT(pCODE)
);
INSERT INTO ORDERDETAIL VALUES (3, 9000, 230110001, 'A1');
INSERT INTO ORDERDETAIL VALUES (1, 3000, 230110001, 'B1');
INSERT INTO ORDERDETAIL VALUES (20, 4000, 230110002, 'A2');
INSERT INTO ORDERDETAIL VALUES (2, 10000, 230110002, 'B2');
INSERT INTO ORDERDETAIL VALUES (1, 7000, 230110002, 'C1');
INSERT INTO ORDERDETAIL VALUES (2, 6000, 230112003, 'A1');
INSERT INTO ORDERDETAIL VALUES (1, 3000, 230112003, 'B1');
INSERT INTO ORDERDETAIL VALUES (1, 7000, 230112003, 'C1');
SELECT * FROM ORDERDETAIL;
UPDATE PRODUCT SET STOCK=STOCK-5 WHERE pCODE='A1';
UPDATE PRODUCT SET STOCK=STOCK-20 WHERE pCODE='A2';
UPDATE PRODUCT SET STOCK=STOCK-2 WHERE pCODE='B1';
UPDATE PRODUCT SET STOCK=STOCK-2 WHERE pCODE='B2';
UPDATE PRODUCT SET STOCK=STOCK-2 WHERE pCODE='C1';
SELECT * FROM PRODUCT;

CREATE TABLE CART(
    NO NUMBER(3),
    mID VARCHAR2(50) NOT NULL,
    pCODE VARCHAR2(20) NOT NULL,
    QTY NUMBER(3),
    COST NUMBER(9),
    FOREIGN KEY(mID) REFERENCES MEMBER(mID),
    FOREIGN KEY(pCODE) REFERENCES PRODUCT(pCODE)
);
INSERT INTO CART (NO, mID, pCODE) VALUES (CART_NO.NEXTVAL, 'abc', 'A1');
INSERT INTO CART (NO, mID, pCODE) VALUES (CART_NO.NEXTVAL, 'abc', 'B1');
SELECT * FROM CART;

SELECT O.pCODE, pNAME, PRICE, QTY, COST 
    FROM ORDERDETAIL O, PRODUCT P
    WHERE O.pCODE=P.pCODE
    AND oNO=230110001;

SELECT O.pCODE, pNAME, PRICE, QTY, COST 
    FROM ORDERDETAIL O, PRODUCT P
    WHERE O.pCODE=P.pCODE
    AND oNO=230110002;
    
SELECT O.pCODE, pNAME, PRICE, QTY, COST 
    FROM ORDERDETAIL O, PRODUCT P
    WHERE O.pCODE=P.pCODE
    AND oNO=230112003;