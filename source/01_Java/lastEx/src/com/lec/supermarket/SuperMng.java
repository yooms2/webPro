package com.lec.supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMng {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn;
		ArrayList<CustomerDto> customers;
		do {
			System.out.print("1:ȸ������, 2:����2�ڸ�(FULL)�˻�, 3:��ǰ����, 4:���������, 5:��ü���, 6:Ż��, �׿�:���� ��");
			fn = scanner.next();
			switch(fn) {
			case "1":
				System.out.print("������ ȸ���� ��ȭ��ȣ : ");
				String ctel = scanner.next();
				System.out.print("������ ȸ���� �̸�");
				String cname = scanner.next();
				// int result = dao.insertCustomer(ctel, cname);
				int result = dao.insertCustomer(new CustomerDto(0, ctel, cname, 0, 0, null, 0));
				System.out.println(result==CustomerDao.SUCCESS? cname+"�� ȸ������ ����. ����Ʈ 1000�� ����":
																cname+"�� ȸ������ ����");
				break;
			case "2":
				System.out.print("�˻��� ��ȭ��ȣ ��4�ڸ��� ��ȭ��ȣ ��ü : ");
				String searchTel = scanner.next();
				customers = dao.ctelGetCustomers(searchTel);
				if(customers.isEmpty()) {
					System.out.println(searchTel+"��ȭ��ȣ�� �˻��� ���� �����ϴ�. ȸ������ �ϼ���");
				} else {
					System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "3":
				System.out.println("�����̵� (�����̵� �� ���, �˻��ϼ���) : ");
				int cid = scanner.nextInt();
				System.out.print("��ǰ���� : ");
				int price = scanner.nextInt();
				result = dao.buy(cid, price);
				if(result==CustomerDao.SUCCESS) {
					System.out.println("��ǰ���� �����մϴ�" + price + "�� �����Ͽ� ���� �����Ͱ� �Ʒ��� ���� ���׷��̵�");
					CustomerDto customer = dao.getCustomer(cid);
					System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
					System.out.println(customer);
				} else {
					System.out.println(cid + "�� ��ȿ�� �����̵� �ƴմϴ�");
				}
				break;
			case "4":
				System.out.println("�˻��ϰ��� �ϴ� ����" + dao.getLevelNames() + " : ");
				String levelName = scanner.next();
				customers = dao.levelNameGetCustomers(levelName);
				if(customers.size()==0) {
					System.out.println("�ش� ���� " + levelName + "�� ���� �˻����� �ʽ��ϴ�");
				} else {
					System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "5":
				customers = dao.getCustomers();
				if(customers.isEmpty()) {
					System.out.println("���� �˻����� �ʽ��ϴ�");
				} else {
					System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "6":
				System.out.print("Ż���� �� ��ȭ��ȣ : ");
				ctel = scanner.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result==CustomerDao.SUCCESS? "ȸ��Ż�� ��1��Ǿ����ϴ�":"��ȿ�� ��ȭ��ȣ�� �ƴմϴ�");
			}
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4") || fn.equals("5") || fn.equals("6"));
		System.out.println("BYE");
	}
}
