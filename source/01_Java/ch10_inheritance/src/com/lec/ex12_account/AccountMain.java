package com.lec.ex12_account;

public class AccountMain {
	public static void main(String[] args) {
		Account acc1 = new Account("111-111", "ȫ�浿");
		CheckingAccount acc2= new CheckingAccount("222-222", "������", 2000, "1111-2222-3333-4444");
		CreditLineAccount acc3 = new CreditLineAccount("333-333", "�̸���", 2000, "5555-6666-7777-8888", 10000);
		acc1.deposit(10000);
		acc2.withdraw(10000);
		acc2.pay("1111-2222-3333-4444", 10000);
		acc3.pay("1111-1111-1111-1111", 2000);
	}
}
