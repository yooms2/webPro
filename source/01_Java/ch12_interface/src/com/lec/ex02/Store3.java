package com.lec.ex02;
// 3È£Á¡ : ±èÄ¡Âî°³-6,000 ºÎ´ëÂî°³-7,000 ºñºö¹ä-7,000 ¼ø´ë±¹-6,000  °ø±â¹ä-1,000¿ø
public class Store3 implements HeadQuarterStore {
	private String storeName;
	public Store3(String storeName) {
		this.storeName = storeName;
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ : 6,000¿ø");
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ : 7,000¿ø");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä : 7,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¾óÅ«¼ø´ë±¹ : 6,000¿ø");
	}
	@Override
	public void gongibab() {
		System.out.println("°ø±â¹ä : 1,000¿ø");
	}
	public String getStoreName() {
		return storeName;
	}
}
