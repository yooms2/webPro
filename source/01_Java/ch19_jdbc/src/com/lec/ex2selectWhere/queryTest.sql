-- Ex1. �μ���ȣ �ް� ����ϱ�
SELECT * FROM DEPT WHERE DEPTNO=40;

-- Ex2. �μ���ȣ �ް� �μ������� ������� ���(���, �̸�, �޿�, ����)
SELECT * FROM DEPT WHERE DEPTNO=40;
SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER 
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=20;
    
-- Ex3 �μ��̸� �˻�
SELECT * FROM DEPT WHERE DNAME=UPPER('sales');

-- Ex4