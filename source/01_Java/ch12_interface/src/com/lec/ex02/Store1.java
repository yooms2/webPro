package com.lec.ex02;
// 1ȣ��: ��ġ�-4,500 �δ��-5,000 �����-6,000 ���뱹-���Ⱦ� �����-1,000��
public class Store1 implements HeadQuarterStore {
	private String storeName;
	public Store1(String storeName) {
		this.storeName = storeName;
	}
	@Override
	public void bude() {
		System.out.println("�δ�� : 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹  �� �Ⱦ�");
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� : 4,500��");
	}
	@Override
	public void bibim() {
		System.out.println("����� : 6,000��");
	}
	@Override
	public void gongibab() {
		System.out.println("����� : 1,000��");
	}
	public String getStoreName() {
		return storeName;
	}
}
