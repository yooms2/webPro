package com.lec.quiz;

public class Gangsa extends Person {
	private String subject;
	private static int cntGangsa;
	public Gangsa(String no, String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setNo("lecture" + (++cntGangsa));
	}
	@Override
	public String infoString() {
		return super.infoString() + "\t(°ú¸ñ)" + subject;
	}
}
