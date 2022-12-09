package com.lec.quiz;

public interface ILendable {
	public byte STATE_BORROWED = 1;
	public byte STATE_NOMAL = 0;
	public void checkOut(String borrower, String checkOutDate);
	public void checkIn();
	public void printState();
}
