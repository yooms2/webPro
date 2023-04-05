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
		System.out.println("Person屈 后 按眉 积己窍磊付磊 角青1 : setEnvironment(env)");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Person屈 后 按眉 积己窍磊付磊 角青2 : afterPropertiesSet()");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Person屈 后 按眉 家戈登扁 傈 角青 : destroy()");
	}
}
