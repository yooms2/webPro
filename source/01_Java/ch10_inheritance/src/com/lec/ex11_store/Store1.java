package com.lec.ex11_store;
// 1ȣ�� : �δ��-5,000  ���뱹-���Ⱦ�
public class Store1 extends HeadQuarterStore {

	public Store1(String storeName) {
		super(storeName);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void bude() {
		System.out.println("�δ�� : 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹  �� �Ⱦ�");
	}
}
