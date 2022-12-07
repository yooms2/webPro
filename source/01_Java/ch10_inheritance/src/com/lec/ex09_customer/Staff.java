package com.lec.ex09_customer;
// name, tel, infoString
public class Staff extends Person {
	private String hiredate; // �Ի���("2000-12-12") �����ֺ��� Date��
	private String department; // �μ�
	// Staff s = new Staff("ȫ���", "010-8888-8888", "2022-12-01", "�����");
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}
	@Override
	public String infoString() {
		return super.infoString() + "   [�μ�]" + department + "   [�Ի���]" + hiredate;
	}
}
