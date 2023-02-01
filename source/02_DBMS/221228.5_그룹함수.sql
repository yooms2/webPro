-- [ V ] �׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV(ǥ������), VARIANCE(�л�)
SELECT MAX(SAL) FROM EMP;
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- �μ���
SELECT MAX(SAL) FROM EMP; -- �ִ� �޿��� �޴� ����� �̸��� �ִ�޿� VI. ��������
SELECT ENAME, SAL FROM EMP WHERE SAL = (SELECT MAX(SAL) FROM EMP);

-- �� 1. �׷��Լ��� �ǽ�
SELECT ROUND(AVG(SAL),2) FROM EMP;
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT SUM(COMM) FROM EMP; -- ��� : 2200/14(157.14) OR 2200/4(550)
SELECT SUM(COMM), COUNT(COMM), AVG(COMM) FROM EMP; -- ��� �׷��Լ��� NULL���� ����
SELECT COUNT(*) FROM EMP; -- ���̺� ���

-- SAL�� ���, ��, �ּҰ�, �ִ밪, �л�, ǥ������, ����(���, �л�, ǥ������ �Ҽ��� ���ڸ����� �ݿø�)
SELECT ROUND(AVG(SAL),1), SUM(SAL), MIN(SAL), MAX(SAL), 
        ROUND(VARIANCE(SAL),1), ROUND(STDDEV(SAL),1), MIN(HIREDATE) 
    FROM EMP;
SELECT AVG(SAL)-2*STDDEV(SAL), AVG(SAL)+2*STDDEV(SAL) FROM EMP; -- 95.44%�� SAL

-- źźex1. �Ի����� ���� ������ ����� �Ի��ϰ� ���� �ֱٿ� �Ի��� ����� �Ի����� ���.
SELECT MIN(HIREDATE), MAX(HIREDATE) FROM EMP;
-- źźex2. (���) 80/12/17:14620��° 83/01/12:13864��°
SELECT MIN(HIREDATE)||':'||TRUNC(SYSDATE-MIN(HIREDATE))||'��°',
    MAX(HIREDATE)||':'||TRUNC(SYSDATE-MAX(HIREDATE))||'��°' FROM EMP;
-- źźex3.  (���) 80��12��17�� �����Ի�:14,620��° 83��01��12�� �ֱ��Ի� :13,864��°
SELECT MIN(TO_CHAR(HIREDATE, 'RR"��"MM"��"DD"�� �����Ի�:"')) ||
        TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)), '99,999')) || '��°' FIRST,
    MAX(TO_CHAR(HIREDATE, 'RR"��"MM"��"DD"�� �����Ի�:"')) ||
        TRIM(TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)), '99,999')) || '��°' LAST
    FROM EMP; -- TO_CHAR�� ���Ῥ���ڸ� ������ ' ' �ڵ� �߰�
-- źźex4. 10�� �μ� �Ҽ��� ��� �߿��� Ŀ�̼��� �޴� ����� ���� ���� ���ÿ�.
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO=10 AND COMM>0;
--                   1        2

-- �� 2. GROUP BY ��
-- �μ���ȣ�� �ִ� �޿�
SELECT DEPTNO, MAX(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO;
    -- GROUP BY�������� �÷��� ��Ī�� ����� �� ����(ORDER BY�������� �÷���Ī ��밡��)
SELECT DEPTNO �μ�, MAX(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO ORDER BY �μ�;
--             3                        1         2                4

-- �μ��̸��� �ִ�޿�, ��ձ޿� (��ձ޿��� ����)
SELECT DNAME, MAX(SAL), AVG(SAL) AVG_SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    ORDER BY AVG_SAL;

    -- ex. SAL�� 5000�̸��� ����� ���ؼ��� �μ���ȣ�� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�
        -- (�μ���ȣ �� ����)
SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL)
    FROM EMP
    WHERE SAL<5000
    GROUP BY DEPTNO
    ORDER BY DEPTNO;

-- �� 3. HAVING �� : �׷��Լ��� ��� ����
    -- �μ���ȣ�� ��� �޿�(��ձ޿��� 2000�̻��� �μ��� ���)
SELECT DEPTNO, AVG(SAL) AVG_SAL
    FROM EMP
    GROUP BY DEPTNO
    HAVING AVG(SAL) > 2000 -- HAVING������ �ʵ��� ��Ī ��� �Ұ�
    ORDER BY DEPTNO; -- �ʵ��� ��Ī�� ORDER BY�������� ��� ����
    -- ex. SAL�� 5000�̸��� ����� ���� �μ��� �ּұ޿�, �ִ�޿�, ��ձ޿�
        -- (��, ��ձ޿��� 1800�̻��� �μ��� ���ؼ� ��ձ޿������� ���� ���)
    SELECT DNAME, MIN(SAL), MAX(SAL), AVG(SAL)
        FROM EMP E, DEPT D 
        WHERE E.DEPTNO=D.DEPTNO AND SAL<5000
        GROUP BY DNAME
        HAVING AVG(SAL) >= 1800
        ORDER BY AVG(SAL);

-- �� 4. ��� ���� �� ���谪 ����
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO); -- ROLLUP�� �ڵ����� ��������
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);

-- ��<�� ��������>

-- 1. �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ���
SELECT COUNT(*) �ο���, MAX(SAL) �ִ�޿�, MIN(SAL) �ּұ޿�, SUM(SAL) "�޿��� ��" FROM EMP;
-- 2. ������ �ο����� ���Ͽ� ���
SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB;
-- 3. �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL)-MIN(SAL) "�ִ�,�ּ� �޿� ����" FROM EMP;
-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���(�޿��� ���� ���� ������)
SELECT DEPTNO, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;
-- 5. �μ���, (������) �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���(�μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;
-- 6. ������, (�μ���) �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;
-- 7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*) >= 5;
-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(ENAME)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(ENAME) >= 5;
-- 9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���
SELECT JOB, AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL) >= 3000;
-- 10. �޿� ���� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿����� ���(�޿� �հ�� �������� ����)
SELECT JOB, SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL) > 5000
    ORDER BY SUM(SAL) DESC;
-- 11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT DEPTNO, AVG(SAL), SUM(SAL), MIN(SAL) 
    FROM EMP
    GROUP BY DEPTNO;
-- 12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ���
SELECT MAX(AVG(SAL)), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;
-- 13. ��� ���̺��� �Ʒ��� ����� ���
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE, 'RR') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'RR')
    ORDER BY H_YEAR;
-- 14.  �Ʒ��� ����� ���(�Ի�⵵�� �����)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'total') �⵵, COUNT(*) 
    FROM EMP 
    GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'));
SELECT NVL(TO_CHAR(EXTRACT(YEAR FROM HIREDATE)),'total'), COUNT(*) 
    FROM EMP 
    GROUP BY ROLLUP(EXTRACT(YEAR FROM HIREDATE));
--15. �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���
SELECT MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL) FROM EMP;
--16. �μ��� �ο��� ���
SELECT COUNT(*) FROM EMP GROUP BY DEPTNO;
--17. �μ��� �ο����� 6���̻��� �μ���ȣ ���
SELECT DEPTNO FROM EMP GROUP BY DEPTNO HAVING COUNT(*) >= 6;
--18. �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--����
SELECT E1.ENAME, E1.SAL, E2.ENAME, E2.SAL
    FROM EMP E1, EMP E2
    WHERE E1.SAL<E2.SAL(+); -- 1�ܰ� : SELF JOIN

SELECT E1.ENAME, COUNT(E2.ENAME)+1 "RANK"
    FROM EMP E1, EMP E2
    WHERE E1.SAL<E2.SAL(+)
    GROUP BY E1.ENAME
    ORDER BY RANK; -- 2�ܰ� : RANL ���ϱ�

SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "RANK",
        DENSE_RANK() OVER(ORDER BY SAL DESC) "DENSE_RANK",
        ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUM"
    FROM EMP;









