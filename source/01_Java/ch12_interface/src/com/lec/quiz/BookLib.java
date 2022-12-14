package com.lec.quiz;

public class BookLib extends BookInfo implements ILendable {
	private String borrower; // ������
	private String checkOutDate; // ������
	private byte state; // ���Ⱑ��(0), ������(1)
	public BookLib(String bookNo, String bookTitle, String bookwriter) {
		super(bookNo, bookTitle, bookwriter);
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(getBookTitle() + " ������ �������Դϴ�");
			return;
		}
		// state�� 0(STATE_NORMAL)�̶� ���� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // "������" ���·� ��ȯ
		System.out.println(getBookTitle() + " ������ ���� ó�� �Ǿ����ϴ�");
		System.out.println("������ : " + borrower + "\t������ : " + checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "������ �ݳ��Ϸ�� å�Դϴ�. Ȯ���ϼ���");
			return;
		}
		// state�� ������(1:STATE_BORROWED)�̶� �ݳ� ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + " ������ �ݳ� �Ϸ�Ǿ����ϴ�");
	}
	@Override
	public void printState() {
//		if(state == STATE_NORMAL) {
//			System.out.println(bookNo + "\t" + bookTitle + "("+ writer + "��) - ���Ⱑ��");
//		}else if{
//			System.out.println(bookNo + "\t" + bookTitle + "("+ writer + "��) - ���� ��");
//		}
		String msg = getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + "��) - ";
		// msg = msg + "������";
		msg += state == STATE_NORMAL ? "���Ⱑ��" : "������";
		System.out.println(msg);
	}
	public byte getState() {
		// TODO Auto-generated method stub
		return 0;
	}
}
