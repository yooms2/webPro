package com.lec.ch06.ex2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class ProxyClass2 {
	// around advice : �ٽɱ�� ���ķ� ������ ����
//	@Pointcut("within(com.lec.ch06.ex2.*)")
//	private void aroundM() {}
//	@Around("aroundM")
	@Around("within(com.lec.ch06.ex2.*)")
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
	@Before("execution(* com.lec.ch06.ex2.Student2.*())")
	public void beforeAdvice() {
		System.out.println("�ٽɱ�� �����ϱ� �� beforeAdvice() �ڵ� ����");
	}
	// after advice : �ٽɱ�� ���� �� ������ ����
	@After("bean(stude*)")
	public void afterAdvice() {
		System.out.println("�ٽɱ�� ���� �� afterAdvice() �ڵ� ����");
	}
	// afterReturning advice : �ٽɱ���� �������� ���� �� ������ ����
	@AfterReturning("within(com.lec.ch06.ex2.Worker2)")
	public void afterReturningAdvice() {
		System.out.println("�ٽɱ�� �������� ���� �� afterReturningAdvice() �ڵ� ����");
	}
	// afterThrowing advice : �ٽɱ�ɿ� ���� �߻� �� ������ ����
	@AfterThrowing("execution(void com.lec.ch06.ex2.Worker2.get*())")
	public void afterThrowingAdvice() {
		System.out.println("�ٽɱ�� ���� �߻� �� afterReturningAdvice() �ڵ� ����");
	}
}
