package com.lec.ex03_speakertv;
// �������̽� - static final ����(���)�� �߻�޼ҵ� (���� : default�޼ҵ�, static �޼ҵ�)
// �۾����� ����
public interface IVolume {
	public void volumUp(); // ���� ������ 1�� up
	public void volumUp(int level); // ���� ������ level�� up
	public void volumDown(); // ���� ������ 1�� down
	public void volumDown(int level); // ���� ������ level�� down
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("����");
		}else {
			System.out.println("��������");
		}
	}
	public static void changeBattery() { // static �޼ҵ�
		System.out.println("�������� ��ȯ�մϴ�");
	}
}
