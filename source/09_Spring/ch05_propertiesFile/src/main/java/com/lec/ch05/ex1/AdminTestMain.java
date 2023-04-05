package com.lec.ch05.ex1;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class AdminTestMain {
	public static void main(String[] args) {
		// �����̳� ����
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		// env�� �Ӽ��� �Ӽ������� �Ǿ� �ִ� PS(propertySources)��
		MutablePropertySources propertySources =  env.getPropertySources();
		// PS�� �ڿ� admin.properties�� ������ �߰�
		String resourceLocation = "classpath:META-INF/ex1/admin.properties";
		try { // ���� ���� ������ ����ó��
			propertySources.addLast(new ResourcePropertySource(resourceLocation));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("admin.id : " + env.getProperty("admin.id"));
		System.out.println("admin.pw : " + env.getProperty("admin.pw"));
		// �� ���� (admin)�� ���� xml �Ľ��ϰ� ��ü����
		ctx.load("classpath:META-INF/ex1/CTX.xml");
		ctx.refresh();
		// admin �� ���
		Admin admin = ctx.getBean("admin", Admin.class);
		System.out.println("adminId : " + admin.getAdminId());
		System.out.println("adminPw : " + admin.getAdminPw());
		System.out.println("env : " + admin.getEnv());
		ctx.close();
	}
}
