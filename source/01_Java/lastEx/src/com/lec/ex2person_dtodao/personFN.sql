-- ���α׷� �䱸���׿� �ʿ��� DML
-- ��ɺ� query �ۼ� (1, 2, 3)
INSERT INTO PERSON 
    VALUES (PERSON_NO_SQ.NEXTVAL, 'ȫ�浿', (SELECT JNO FROM JOB WHERE JNAME='����'), 81, 83, 85);

SELECT JNO, JNAME FROM JOB WHERE JNO=30;
-- SELECT PNAME||'('||PNO||'��'||')' �̸�, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
--    FROM PERSON P , JOB J WHERE P.JNO=J.JNO
--    ORDER BY SUM DESC;
SELECT ROWNUM RN, A.*
    FROM (SELECT PNAME||'('||PNO||'��'||')' pname, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
        FROM PERSON P , JOB J WHERE P.JNO=J.JNO AND JNAME='���'
        ORDER BY SUM DESC) A;

SELECT ROWNUM RN, A.*
    FROM (SELECT PNAME||'('||PNO||'��'||')' �̸�, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
        FROM PERSON P , JOB J WHERE P.JNO=J.JNO
        ORDER BY SUM DESC) A;

-- 1���� 2��
SELECT JNAME FROM JOB;




