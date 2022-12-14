package quiz.modularization;

import quiz.interfaces.JobLec;

public class Lecturer extends Person {
	private String subject;
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());
		System.out.println("���̵� : " + id + "\t�̸� : " + name + "\t���� : " + subject);
	}
}
