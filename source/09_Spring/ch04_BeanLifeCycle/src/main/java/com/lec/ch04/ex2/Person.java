package com.lec.ch04.ex2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements EnvironmentAware, InitializingBean, DisposableBean {
	private String name;
	private String tel;
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("Person�� �� ��ü �������ڸ��� ����1 : setEnvironment(env)");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Person�� �� ��ü �������ڸ��� ����2 : afterPropertiesSet()");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Person�� �� ��ü �Ҹ�Ǳ� �� ���� : destroy()");
	}
}
