-- [ II ] SELECT�� - ��ȸ
-- 1. SELECT ���� �ۼ���
-- ���� ����(���� : CTRL + ENTER)
SHOW USER;
SELECT * FROM TAB; -- �� ������ ������ �ִ� ���̺� ����
SELECT * FROM EMP; -- EMP ���̺��� ��� ��(�ʵ�), ��� ��
SELECT * FROM DEPT; -- DEPT ���̺��� ��� ��(�ʵ�), ��� ��
SELECT * FROM SALGRADE;

-- 2. Ư�� ���� ���
-- EMP ���̺��� ����
DESC EMP; 
SELECT EMPNO, ENAME, SAL, JOB FROM EMP; -- EMPNO, ENAME, SAL, JOB�ʵ� ��� �� �˻�
SELECT EMPNO, ENAME, SAL, JOB, MGR, SAL, COMM FROM EMP;
SELECT EMPNO AS "�� ��", ENAME AS "�̸�", SAL AS "�޿�", JOB AS "��å" FROM EMP;
SELECT EMPNO "�� ��", ENAME "�̸�", SAL "�޿�", JOB "��å" FROM EMP;
SELECT EMPNO "�� ��", ENAME �̸�, SAL �޿�, JOB ��å FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY, JOB FROM EMP; -- �ʵ忡 ��Ī�� �δ� ���

-- 3. Ư�� �� ��� : WHERE ��(������)-- �񱳿����� : ����(=), �ٸ���(!=, ^=, <>)
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL = 3000; -- ����
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL != 3000; -- �ٸ���
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL ^= 3000; -- �ٸ���
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL <> 3000; -- �ٸ���
    -- �� �����ڴ� ����, ����, ��¥�� ��� ����
    -- ex1. ����̸�(ENAME)�� 'A','B','C'�� �����ϴ� ����� ��� �ʵ�
    -- A < AA < AAA < AAAA < AAAAA < AAAAAA < AAAAAAA < AAAAAAAA < AA..A < A...AB ..
SELECT * FROM EMP WHERE ENAME < 'D';
    -- ex2. 81�⵵ ������ �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
    -- ex3. �μ���ȣ(DEPTNO)�� 10�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO=10;
    -- ex4. �̸�(ENAME)�� FORD�� ������ EMPNO, ENAME, MGR(����� ���)�� ���
    -- SQL�� ��ҹ��� ��������. �����ʹ� ��ҹ��� ����
select empno, ename, mgr from emp where ename='FORD';

-- 4. �������� �������� : AND OR NOT
    -- ex1. �޿�(SAL)�� 2000�̻� 3000������ ������ ��� �ʵ�
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<=3000;
    -- ex2. 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE>='82/01/01' AND HIREDATE<='82/12/31';
-- ��¥ ǥ��� ���� (���� : YY/MM/DD �Ǵ� RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YYYY';
SELECT * FROM EMP WHERE HIREDATE>='01-01-1982' AND HIREDATE<='12-31-1982';
SELECT * FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD')>='82/01/01' 
        AND TO_CHAR(HIREDATE, 'RR/MM/DD')<='82/12/31';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
    -- ex3. ���� 2400�̻��� ���� ENAME, SAL, ����(SAL*12)�� ���
SELECT ENAME, SAL, SAL*12 ANNUALSAL 
    FROM EMP                    -- (1)
    WHERE ANNUALSAL >= 2400;    -- (2) WHERE������ �ʵ� ��Ī ��� �Ұ�
SELECT ENAME, SAL, SAL*12 ANNUALSAL -- (3)��°
    FROM EMP                    -- (1)��°
    WHERE SAL*12 >= 2400;       -- (2)��°
    -- ex4. ������ 10,000 �̻��� ������ ENAME, SAL, ����(����������)
SELECT ENAME, SAL, SAL*12 "����" -- (3)
    FROM EMP                -- (1)
    WHERE SAL*12 >= 10000   -- (2)
    ORDER BY ����;           -- (4)
    -- ex5. 10�� �μ�(DEPTNO)�̰ų� JOB�� MANAGER�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
    -- ex6. �μ���ȣ�� 10�� �μ��� �ƴ� ������ ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE NOT DEPTNO = 10;

-- 5. ���������
SELECT EMPNO, ENAME, SAL, SAL*1.1 UPGRADESAL FROM EMP;
    -- ex. ��� ����� �̸�(ename), ����(sal), ��(comm), ����(sal*12+comm)�� ���
SELECT ENAME, SAL, COMM, SAL*12+COMM ���� FROM EMP;
    -- ��������� ����� NULL�� �����ϸ� ����� NULL
    -- NVL(NULL�� ���� �ִ� �ʵ��, ��ġ��)�� �̿� ; �ʵ��� ��ġ���� Ÿ���� ��ġ
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) ���� FROM EMP;
    -- ��� ����� ENAME, MGR(�����)�� ��� (��簡 ������ CEO�� ���)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;

-- 6. ���Ῥ����(||) : �ʵ峪 ���ڸ� ����
SELECT ENAME || '�� ' || JOB EMPLOYEES FROM EMP;
    -- ex. ��� ����� ���Ͽ� 'SMITH : ANNUAL SALARY = XXXX' �������� ��� (����=SAL*12+COMM)
SELECT ENAME || ' : ANNUAL SALARY = ' || (SAL*12+NVL(COMM, 0)) MESSAGE FROM EMP;

-- 7. �ߺ�����
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

SELECT * FROM EMP;
SELECT * FROM DEPT;

-- �� �������� �� Ǯ��
--1. emp ���̺��� ���� ���
DESC EMP;
--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;
--3. �� scott �������� ��밡���� ���̺� ���
SHOW USER;
SELECT * FROM TAB;
--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000;
--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'YY/MM')>'81/02';

-- �س�¥������ RR/MM/DD�� �ƴ� ����� ���
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') >= '81/02/01';
--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN';
--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';
--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30;
--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='SALESMAN' OR SAL>=3000;
--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=2500 AND JOB='MANAGER';
--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM)
SELECT ENAME || '��(��) ' || JOB || '�����̰� ������ ' || (SAL*12+NVL(COMM, 0)) || '��' MESSAGE FROM EMP;
-- CF. "ENAME�� �󿩴� 800" (���Ῥ���ڷ� �ϸ� NULL�� ��� �� ��)
SELECT ENAME || '�� �󿩱��� ' || NVL(COMM, 0) FROM EMP;

-- 8. SQL������(BETWEEN, IN, LIKE, IS NULL)
    -- (1) BETWEEN A AND B ; A���� B���� (A, B ����)
        -- ex. SAL�� 1500�̻� 3000������ ������ ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 1500; -- �Ұ�
    -- ex. SAL�� 1500�̸�, 3000�ʰ�
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
    -- ex. �̸��� 'A','B','C'�� �����ϴ� ������ ��� �ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D' AND ENAME~='D'; -- 'A'~'D'����/'D'�� ����
    -- ex. 82�⵵�� �Ի��� ������ ��� �ʵ� ���
SELECT * FROM EMP;
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';

    -- (2) IN
        -- ex. �μ���ȣ�� 10, 20, 40�� �μ��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=40;
SELECT * FROM EMP WHERE DEPTNO IN (10,20,40);
    -- ex. �μ���ȣ�� 10,20,40���� ������ �μ� ������ ��� �ʵ�
SELECT * FROM EMP WHERE NOT (DEPTNO=10 OR DEPTNO=20 OR DEPTNO=40);
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20,40);
    -- ex. ����� 7902, 7788, 7566�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);
    -- ex. ��å�� MANAGER�̰ų� ANALYST�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE JOB IN ('MANAGER', 'ANALYST');

    -- (3) LIKE %(0�����̻�), _(�ѱ���)�� ������ ����
        -- ex. �̸��� M���� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE 'M%'; -- M, MA, MAA, ..MZZZ
    -- ex. �̸��� N�� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%N%';
    -- ex. �̸��� N�� ���ų� JOB�� N�� ���� ����� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%N%' OR JOB LIKE '%N%';
    -- ex. �̸��� 'S'�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S';
    -- ex. SAL�� 5�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL LIKE '%5';
    -- ex. 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/%';
    -- ex. 1���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
    -- ex. �̸��� '%'�� �� ����� ��� �ʵ�
SELECT * FROM DEPT;
INSERT INTO EMP VALUES (9999, 'LISA%', NULL, NULL, NULL, 6000, 1500, 40);
SELECT * FROM EMP WHERE ENAME='LISA%';
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
ROLLBACK; -- DML(������ ���۾�;�߰�, ����, ����, �˻�)�� ���

    -- (4) IS NULL
        -- ex. �󿩱��� ���� ����� ��� �ʵ�(COMM�� NULL, 0)
SELECT * FROM EMP WHERE COMM IS NULL OR COMM=0;
    -- ex. �󿩱��� �޴� ����� ��� �ʵ�
SELECT * FROM EMP WHERE NOT (COMM IS NULL OR COMM=0);
SELECT * FROM EMP WHERE NOT COMM IS NULL AND COMM!=0;
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM!=0;
-- SELECT * FROM EMP WHERE NOT IS NULL AND COMM!=0; �Ұ�
-- SELECT * FROM EMP WHERE COMM != NULL AND COMM!=0; �Ұ�

-- 9. ����(��������, ��������) ; ORDER BY ��
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL; -- �޿� �������� ����
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC; -- �޿� �������� ���� (�⺻�� ASC)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC, HIREDATE DESC;
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY ENAME; -- ABC������ ����
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY HIREDATE;
SELECT ENAME, SAL, SAL*12+NVL(COMM,0) ANNUALSAL FROM EMP ORDER BY ANNUALSAL;
SELECT ENAME, SAL, SAL*12+NVL(COMM,0) ANNUALSAL FROM EMP ORDER BY SAL*12+NVL(COMM,0);


-- ����ȯ �Լ�
-- ��¥��(HIREDATE)�� ���������� ��ȯ : TO_CHAR(��¥��������, ����)
SELECT TO_CHAR(HIREDATE, 'MON-DD-YYYY') FROM EMP;
-- �������� ��¥������ ��ȯ : TO_DATE(���ڵ�����, ����)
SELECT TO_DATE('01-12-1996', 'MM-DD-YYYY') FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

-- <���� ��������>
--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP 
    WHERE SAL>=3000;
--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO 
    FROM EMP 
    WHERE EMPNO='7788';
--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL 
    FROM EMP 
    WHERE SAL*12+NVL(COMM,0)>=24000 
    ORDER BY SAL;
--4.	�Ի����� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի����� ��� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE 
    FROM EMP 
    WHERE HIREDATE 
    BETWEEN '81/02/20' AND '81/05/01' ORDER BY HIREDATE;
--5.	deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP 
    WHERE DEPTNO 
    IN (10,20) 
    ORDER BY ENAME;
--6.	sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME EMPLOYEE, SAL MONTHLY_SALARY FROM EMP
    WHERE SAL>=1500 AND DEPTNO IN (10,30); 
--7.	hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP
    WHERE HIREDATE LIKE '82%';
SELECT * FROM EMP
    WHERE TO_CHAR(HIREDATE, 'YYYY') = 1982;
--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP 
    WHERE ENAME BETWEEN 'C%' AND 'P%'
    ORDER BY SAL, ENAME;
--9.	comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, SAL*1.1 COMM FROM EMP;
SELECT ENAME, SAL, COMM FROM EMP
    WHERE COMM>SAL*1.1;
--10.	job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP
    WHERE JOB IN ('CLERK','ANALYST') AND SAL NOT IN (1000,3000,5000);
--11.	ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP
    WHERE ENAME LIKE '%L%L%' AND (DEPTNO=30 OR MGR=7782);
--12.	�Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
    WHERE HIREDATE LIKE '81/%';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
    WHERE TO_CHAR(HIREDATE, 'RR') = 81;
--13.	�Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
    WHERE HIREDATE LIKE '81/%' AND JOB != 'SALESMAN';
--14.	���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
    ORDER BY SAL DESC, HIREDATE ASC;
--15.	������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP
    WHERE ENAME LIKE '__N%';
--16.	����� 'A'�� �� ����� ���, ������� ���
SELECT EMPNO, ENAME FROM EMP
    WHERE ENAME LIKE '%A%';
--17.	����(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL*12 ���� FROM EMP
    WHERE SAL*12>=35000;










