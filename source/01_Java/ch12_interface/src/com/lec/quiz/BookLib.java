package com.lec.quiz;

public class BookLib extends BookInfo implements ILendable {
	public BookLib(String bookNo, String bookTitle, String bookwriter) {
		super(bookNo, bookTitle, bookwriter);
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {

	}

	@Override
	public void checkIn() {

	}

	@Override
	public void printState() {

	}
}
