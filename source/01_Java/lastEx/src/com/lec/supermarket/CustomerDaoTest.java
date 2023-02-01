package com.lec.supermarket;

import java.util.ArrayList;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> customers;
//		System.out.println("=== 1. ȸ������ ===");
		String ctel = "010-1111-1111", cname = "�̼���";
//		result = dao.insertCustomer(ctel, cname);
//		System.out.println(result==CustomerDao.SUCCESS? cname+"�� ȸ������ ����. ����Ʈ 1000�� �־� �帲":
//														cname+"�� ȸ������ ����");
//		ctel = "010-2222-1111"; cname="������";
//		result = dao.insertCustomer(new CustomerDto(0, ctel, cname, 0, 0, null, 0));
//		System.out.println(result==CustomerDao.SUCCESS? cname+"�� ȸ������ ����. ����Ʈ 1000�� �־� �帲":
//														cname+"�� ȸ������ ����");
		System.out.println("=== 2. ��ȭ��ȣ �˻� ===");
		ctel = "9999";
		customers = dao.ctelGetCustomers(ctel);
		if(customers.isEmpty()) {
			System.out.println(ctel+" ��ȭ��ȣ�� �˻��� ���� �����ϴ�. ȸ�������ϼ���");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
			for(CustomerDto customer : customers) {
				System.out.println(customer);
			}
		} // if
		System.out.println("=== 3. ��ǰ���� ===");
		result = dao.buy(1, 200000); // 1�� ���� 20���� ����
		if(result==CustomerDao.SUCCESS) { // ��ǰ���Ű� �����Ǹ� �����޼����� �Բ� ������ ���
			CustomerDto customer = dao.getCustomer(1);
			System.out.println("��ǰ���� �����մϴ�. ���� ������ �Ʒ��� ���� ������Ʈ �Ǿ����ϴ�");
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
			System.out.println(customer);
		} else {
			System.out.println("cid�� ��ȿ���� �ʽ��ϴ�");
		}
		System.out.println("=== 4. ������ ��� ===");
		System.out.println("�������� : " + dao.getLevelNames());
		customers = dao.levelNameGetCustomers("normal");
		if(customers.size()==0) {
			System.out.println("NORMAL ���� ���� �����ϴ�");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
			for(CustomerDto customer : customers) {
				System.out.println(customer);
			}
		}
		System.out.println("=== 5. ��ü ��� ===");
		customers =dao.getCustomers();
		if(customers.isEmpty()) {
			System.out.println("���� �����ϴ�");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
			for(CustomerDto customer : customers) {
				System.out.println(customer);
			} // for
		} // if
		System.out.println("=== 6. ȸ��Ż�� ===");
		result = dao.deleteCustomer("010-7777-7777");
		System.out.println(result==CustomerDao.SUCCESS? "��������":"��ȿ�� ��ȭ��ȣ�� �ƴմϴ�");
		System.out.println("=== 5. ��ü ��� ===");
		customers =dao.getCustomers();
		if(customers.isEmpty()) {
			System.out.println("���� �����ϴ�");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t��������������õ���ž�");
			for(CustomerDto customer : customers) {
				System.out.println(customer);
			} // for
		} // if
	}
}
