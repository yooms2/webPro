package com.lec.ex2_parkingsystem;

import com.lec.constant.Constant;

public class Parking {
	private String no;
	private int inTime;// 12
	private int outTime; // 14
	private int fee;
	// private final int HOURLYPARKINGRATE = 2000; // ��� (final ����) final �� ������ �빮�ڷ�
	public Parking() {}
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.println(no + "�� �������  �����ð� : " + inTime + "��");
	}
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime) * Constant.HOURLYPARKINGRATE;
//		fee���
		System.out.println();
		System.out.println(no + "�� �̿�ð� : " + (outTime-inTime) + "�ð�\n" + "������� : " + fee + "��");
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	public int getOutTime() {
		return outTime;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	// setter & getter
	
}
