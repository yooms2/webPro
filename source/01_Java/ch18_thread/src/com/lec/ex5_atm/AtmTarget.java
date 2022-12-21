package com.lec.ex5_atm;

public class AtmTarget implements Runnable {
	private ATM atm;
	private boolean flag; // ó���� false�� ��������
	
	public AtmTarget(ATM atm) {
		this.atm = atm;
	}
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			if(flag) {
				atm.withdraw(1000, Thread.currentThread().getName());
				flag = false;
			} else {
				atm.deposit(1000, Thread.currentThread().getName());
				flag = true;
			} // if
		} // for
	} // run
}
