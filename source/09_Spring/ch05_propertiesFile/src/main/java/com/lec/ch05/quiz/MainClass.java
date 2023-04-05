package com.lec.ch05.quiz;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("devv? run?");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("DEVV")) {
			config = "devv";
		} else if(answer.equalsIgnoreCase("RUN")) {
			config = "run";
		} else {
			System.out.println("È®ÀÎ¿ä¸Á");
			System.exit(0);
		}
		sc.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		String loc1 = "classpath:META-INF/quiz/devv.xml";
		String loc2 = "classpath:META-INF/quiz/run.xml";
		ctx.load(loc1, loc2);
		ctx.refresh();
		EnvInfo info = ctx.getBean("envInfo", EnvInfo.class);
		System.out.println("IP : " + info.getIpNum());
		System.out.println("PORT : " + info.getPortNum());
		System.out.println("ID : " + info.getUserId());
		System.out.println("PW : " + info.getUserPw());
	}
}
