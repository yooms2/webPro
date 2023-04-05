package com.lec.ch05.ex3;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileTestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("DEV? RUN(�μ��׽�Ʈ)?");
		String answer = sc.next(); // DEV/RUN/xxx
		if(answer.equalsIgnoreCase("DEV")) {
			config = "dev";
		} else if(answer.equalsIgnoreCase("RUN")) {
			config = "run";
		} else {
			System.out.println("����� �� ȯ���� �Է����� �ʾҽ��ϴ�. Ȯ�ο��");
			System.exit(0); // ������¿��� ��������
		}
		sc.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		String loc1 = "classpath:META-INF/ex3/CTX_DEV.xml";
		String loc2 = "classpath:META-INF/ex3/CTX_RUN.xml";
		ctx.load(loc1, loc2);
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("IP : " + info.getIpNum());
		System.out.println("PORT : " + info.getPortNum());
		
	}
}
