package com.lec.ex1_store;
// �߻�Ŭ���� : �ϳ� �̻��� �߻�޼ҵ带 ���� ������ �߻�Ŭ����
public abstract class HeadQuarterStore {
	private String storeName;
	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	// �߻�޼ҵ� : ���� ����� Ŭ�������� �ݵ�� override �ض�.
	//			  �޼ҵ��� ���� 
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void gongibab();
	public String getStoreName() {
		return storeName;
	}
}

