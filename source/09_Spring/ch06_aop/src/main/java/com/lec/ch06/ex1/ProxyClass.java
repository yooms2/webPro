package com.lec.ch06.ex1;

import org.aspectj.lang.ProceedingJoinPoint;

public class ProxyClass {
	// around advice : �ٽɱ�� ���ķ� ������ ����
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("-------------------------------");
		String signatureName = joinPoint.getSignature().toString(); // �ٽɱ�� �޼ҵ��
		System.out.println(signatureName + "�� ���۵Ǿ����ϴ�");
		long startTime = System.currentTimeMillis(); // ���� ������ �и�����
		try {
			Object object = joinPoint.proceed(); // �ٽ� ��� ����
			return object;
		} finally {
			long endTime = System.currentTimeMillis(); // �ٽɱ�� ���� �� ����
			System.out.println(signatureName + "�� ����Ǵ� ��� �ð� : " + (endTime-startTime));
		}
	}
	// before advice : �ٽɱ�� ���� �� ������ ����
	public void beforeAdvice() {
		System.out.println("�ٽɱ�� �����ϱ� �� beforeAdvice() �ڵ� ����");
	}
	// after advice : �ٽɱ�� ���� �� ������ ����
	public void afterAdvice() {
		System.out.println("�ٽɱ�� ���� �� afterAdvice() �ڵ� ����");
	}
	// afterReturning advice : �ٽɱ���� �������� ���� �� ������ ����
	public void afterReturningAdvice() {
		System.out.println("�ٽɱ�� �������� ���� �� afterReturningAdvice() �ڵ� ����");
	}
	// afterThrowing advice : �ٽɱ�ɿ� ���� �߻� �� ������ ����
	public void afterThrowingAdvice() {
		System.out.println("�ٽɱ�� ���� �߻� �� afterReturningAdvice() �ڵ� ����");
	}
}
