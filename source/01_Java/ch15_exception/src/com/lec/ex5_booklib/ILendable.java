package com.lec.ex5_booklib;

public interface ILendable {
	public byte STATE_BORROWED = 1; // "������"�� �ǹ�
	public byte STATE_NORMAL = 0; // "���Ⱑ��"�� �ǹ�
	public void checkOut(String borrower); // ����
	public void checkIn() throws Exception; // �ݳ�
}
