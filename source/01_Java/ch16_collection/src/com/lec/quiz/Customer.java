package com.lec.quiz;

public class Customer {
	private String name;
	private String tel;
	private String address;
	public Customer(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	@Override
	public String toString() {
		return "[�̸�]" + name + "\t[��ȭ��ȣ]" + tel + "\t[�ּ�]" + address;
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && getClass() == obj.getClass()) {
			Customer other = (Customer) obj;
			boolean nameChk = name==other.name;
			boolean telChk = tel==other.tel;
			boolean addressChk = address==other.address;
			return nameChk && telChk && addressChk;
		}
		return false;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
}
