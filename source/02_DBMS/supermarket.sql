DROP SEQUENCE CUSTOMER_CID_SEQ;
DROP TABLE CUSTOMER;
DROP TABLE CUS_LEVEL;


CREATE TABLE CUS_LEVEL (
    LEVELNO NUMBER(1) PRIMARY KEY,
    LEVELNAME VARCHAR2(20),
    LOW NUMBER(9),
    HIGH NUMBER(9)
);
CREATE TABLE CUSTOMER (
    CID NUMBER(6) PRIMARY KEY,
    CTEL VARCHAR2(20),
    CNAME VARCHAR2(30),
    CPOINT NUMBER(9) DEFAULT 1000,
    CAMOUNT NUMBER(9) DEFAULT 0,
    LEVELNO NUMBER(1) DEFAULT 1 NOT NULL,
    FOREIGN KEY(LEVELNO) REFERENCES CUS_LEVEL(LEVELNO)
);
CREATE SEQUENCE CUSTOMER_CID_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;

INSERT INTO CUS_LEVEL VALUES (1, 'NORMAL', 0, 999999);
INSERT INTO CUS_LEVEL VALUES (2, 'SILVER', 1000000, 1999999);
INSERT INTO CUS_LEVEL VALUES (3, 'GOLD', 2000000, 2999999);
INSERT INTO CUS_LEVEL VALUES (4, 'VIP', 3000000, 3999999);
INSERT INTO CUS_LEVEL VALUES (5, 'VVIP', 4000000, 999999999);
SELECT * FROM CUS_LEVEL;

INSERT INTO CUSTOMER (CID, cTEL, cNAME)
    VALUES (CUSTOMER_CID_SEQ.NEXTVAL, '010-9999-9999', 'ȫ�浿');
INSERT INTO CUSTOMER 
    VALUES (CUSTOMER_CID_SEQ.NEXTVAL, '010-8888-9999', '��浿', 0, 4000000, 5);
INSERT INTO CUSTOMER
    VALUES (CUSTOMER_CID_SEQ.NEXTVAL, '010-7777-7777', '�ű浿', 0, 100000, 1);
SELECT * FROM CUSTOMER;
COMMIT;

-- ���α׷��� �ʿ��� QUERY
-- 1. ȸ������ (ctel, cname �Է¹޾� insert)
    -- public int insertCustomer(String ctel, String cname)
    -- public int insertCustomer(CustomerDto dto)
INSERT INTO CUSTOMER (CID, CTEL, CNAME)
    VALUES (CUSTOMER_CID_SEQ.NEXTVAL, '010-6666-6666', '���浿');
COMMIT;
ROLLBACK; -- COMMIT�̳� ROLLBACK �� �ϳ��� ����

-- 2. ����4�ڸ�(Ǯ��ȣ) �˻� (ctel �Է¹޾� cid, ctel, cname, cpoint, camount, levelname, forLevelUp)
    -- public ArrayList<CustomerDto> ctelGetCustomers(String searchTel)
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, HIGH+1-CAMOUNT forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO; -- �ְ� ������ ��쿡 �߸� ���´�

SELECT CNAME, CAMOUNT, HIGH+1-CAMOUNT, (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID)
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO; -- �̿��� �������� �����

SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,
        (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||'9999'; -- DAO�� �� QUERY

-- 3. ��ǰ���� (cid, price �Է¹޾� cpoint, camount, levelno update)
    -- public int buy(int cid, int price)
    -- 1�ܰ� : CPOINT, CAMOUNT ����
    UPDATE CUSTOMER
        SET CPOINT = CPOINT + (1000000*0.05),
            CAMOUNT = CAMOUNT + 1000000
        WHERE CID = 1;
        
    -- 2�ܰ� : ������ CAMOUNT�� ���� LEVELNO ����
    SELECT CNAME, CAMOUNT, C.LEVELNO ������, L.LEVELNO �ٲ𷹺�, LOW, HIGH
        FROM CUSTOMER C, CUS_LEVEL L
        WHERE CAMOUNT BETWEEN LOW AND HIGH;

    SELECT L.LEVELNO
        FROM CUSTOMER, CUS_LEVEL L
        WHERE CAMOUNT BETWEEN LOW AND HIGH AND CID=1; -- CID�� 1�� �������� �ٲ𷹺�
    
    UPDATE CUSTOMER
        SET LEVELNO = (SELECT L.LEVELNO
                       FROM CUSTOMER, CUS_LEVEL L
                       WHERE CAMOUNT BETWEEN LOW AND HIGH AND CID=1)
        WHERE CID=1; -- LEVELNO����
        
    -- DAO�� �� QUERY �ϼ� (1�ܰ� + 2�ܰ�)
    UPDATE CUSTOMER
        SET CPOINT = CPOINT + (1000000*0.05),
            CAMOUNT = CAMOUNT + 1000000,
            LEVELNO = (SELECT L.LEVELNO
                       FROM CUSTOMER, CUS_LEVEL L
                       WHERE CAMOUNT+1000000 BETWEEN LOW AND HIGH
                            AND CID=1)
        WHERE CID = 1;
    SELECT * FROM CUSTOMER WHERE CID=1;
        
-- 3�� �� �ٲ� �� ������ ��� (cid, ctel, cname, cpoint, camount, levelname, forLevelUp)
    -- public CustomerDto getCustomer(int cid)
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,
        (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND CID=1;

-- 4�� �� ����޸�� ����
    -- public ArrayList<String> getLevelNames()
SELECT LEVELNAME FROM CUS_LEVEL;

-- 4. �� ��޺� ��� (levelname�� �Է¹޾� cid, ctel, cname, cpoint, camount, levelname, forLevelUp���)
    -- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,
        (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME=UPPER('normal')
    ORDER BY CAMOUNT DESC;

-- 5. �� ��ü ��� (cid, ctel, cname, cpoint, camount, levelname, forLevelUp���)
    -- public ArrayList<CustomerDto> getCustomers()
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,
        (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO
    ORDER BY CAMOUNT DESC;

-- 6. ȸ��Ż�� (ctel�� �Է¹޾� delete)
    -- public int deleteCustomer(String ctel)
DELETE FROM CUSTOMER WHERE CTEL='010-6666-6666';
SELECT * FROM CUSTOMER;
ROLLBACK;








