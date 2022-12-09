package com.lec.ex04_actor;

public class Actor implements Chef, FireFighter, PoliceMan {
	private String name;	
	public Actor(String name) {
		this.name = name;
	}
	@Override
	public void canCatchCriminal() {
		System.out.println(name + "�� �������Դϴ�. ������ ����ϴ�");
	}
	@Override
	public void canSearch() {
		System.out.println(name + "�� �������Դϴ�. ������ ã���ϴ�");
	}
	@Override
	public void outFire() {
		System.out.println(name+ "�� �ҹ���Դϴ�. ���� ���ϴ�");
	}

	@Override
	public void saveMan() {
		System.out.println(name + "�� �ҹ���Դϴ�. ����� ������");
	}
	@Override
	public void makePizza() {
		System.out.println(name + "�� �丮���Դϴ�. ���ڸ� ����ϴ�");
	}
	@Override
	public void makeSpaghetti() {
		System.out.println(name + "�� �丮���Դϴ�. ���İ�Ƽ�� ����ϴ�");
	}
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
