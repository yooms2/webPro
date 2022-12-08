package com.lec.quiz;
// name, computePay, computIncentive
public abstract class Employee {
	private String name;
	public Employee(String name) {
		this.name = name;
	}
	
	public abstract int computePay(); // 월급
	
	public final int computeIncentive() { // 상여
		if(computePay() >= 3000000) {
			return (int)(computePay() * 0.05);
		}else {
			return 0;
		}
	}
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
