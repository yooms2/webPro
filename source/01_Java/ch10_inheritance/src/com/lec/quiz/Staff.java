package com.lec.quiz;

public class Staff extends Person {
	private String department;
	private static int cntStaff;
	public Staff(String no, String id, String name, String department) {
		super(id, name);
		this.department = department;
		setNo("staff" + (++cntStaff));
	}
	@Override
	public String infoString() {
		return super.infoString() + "\t(ºÎ¼­)" + department;
	}
}
