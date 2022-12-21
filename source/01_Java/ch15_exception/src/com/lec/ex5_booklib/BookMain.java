package com.lec.ex5_booklib;

import java.util.Scanner;
public class BookMain {
	public static void main(String[] args) throws Exception {
		Book[] books = {new Book("890��-01-11", "java", "ȫ�浿"),
						new Book("890��-01-12", "oracle", "���浿"),
						new Book("890��-02-01", "mysql", "���浿"),
						new Book("890��-01-01", "jdbc", "���̵�"),
						new Book("890��-01-01", "html", "�̿���")};
		Scanner scanner = new Scanner(System.in);
		String fn; // ��ɹ�ȣ(1:����/2:�ݳ�/3:ålist/0:����)
		int idx; // �����ϰų� �ݳ��� ��, ��ȸ�� å�� index
		String bTitle, borrower; // ����ڿ��� ���� å�̸�, ������
		do {
			System.out.println("0:ålist / 1:���� / 2:�ݳ� / �׿�:����");
			fn = scanner.next();
			switch(fn) {
			case "1": // ���� : 1.å�̸��Է� 2.å��ȸ 3.å����Ȯ�� 4.�������Է� 5.�������Է� 6.����޼ҵ� ȣ��
				// 1.å�̸��Է�
				System.out.println("�����ϰ��� �ϴ� å�̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				// 2.å��ȸ
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle()) ) {
						break;
					}
				} // for
				if(idx == books.length) {
					System.out.println("���� �������� �ʴ� �����Դϴ�");
				}else { // books[idx] ������ ����
					// 3.å����Ȯ��
					if(books[idx].getState() == Book.STATE_BORROWED) {
						System.out.println("���� ���� ���� �����Դϴ�");
					}else {
						// 4.�������Է�
						System.out.print("�������� ? ");
						borrower = scanner.next(); // ȫ�浿
						// 5.�������Է�
//						checkOutDate = scanner.next(); // 2022.12.01(O), 2022 12 01(X)
						// 6.����޼ҵ� ȣ��
						books[idx].checkOut(borrower);
					} // if-����Ȯ��
				} // if - ���� ��ȸ
				// idx��° å���� ����
				break;
			case "2": // �ݳ����� : 1.å�̸��Է� 2.å��ȸ 3.�ݳ��޼ҵ� ȣ��
				// 1.å�̸��Է�
				System.out.println("�ݳ��ϰ��� �ϴ� å�̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				// 2.å��ȸ
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle()) ) {
						break;
					}
				} // for
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�");
				}else {
					// 3. �ݳ��޼ҵ� ȣ��
					try {
						books[idx].checkIn();
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "0": // å list ��� : for���� �̿��Ͽ� printState()�޼ҵ� ȣ��
				for(Book book : books) {
					System.out.println(book);
				}
			}
		}while(fn.equals("0") || fn.equals("1") || fn.equals("2"));
		System.out.println("0,1,2 �� �Է½� ����");
		scanner.close();
	}
}
