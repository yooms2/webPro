package quiz.modularization;

import quiz.interfaces.JobMng;

public class Staff extends Person {
	private String part;
	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		System.out.println("아이디 : " + id + "\t이름 : " + name + "\t부서 : " + part);
	}
}
