package quiz.modularization;

import quiz.interfaces.JobStudy;

public class Student extends Person {
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudy());
		System.out.println("아이디 : " + id + "\t이름 : " + name + "\t반 : " + ban);
	}
}
