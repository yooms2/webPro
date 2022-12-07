package com.lec.ex4_boxorrect;

// ������ : width(����), height(����), depth(����), volume
// �簢�� : width, height, depth=0, volume(����) : BoxOrRect r=new BoxOrRect(2, 3);
// ������ü : width, height, depth, volume(����) : BoxOrRect b=new BoxOrRect(2, 3, 3);
// �޼ҵ� : calVolume(), infoPrint(), infoString()
public class BoxOrRect {
//	private int width, height, depth, volume ;
	private int width;
	private int height;
	private int depth;
	private int volume;

	public BoxOrRect() {
	} // ����Ʈ ������

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		calVolume();
	}

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		calVolume();
	}

	private void calVolume() {
		if (depth == 0)
			volume = width * height;
		else
			volume = width * height * depth;
	}

	public void infoPrint() {
		if(depth==0) {
			System.out.printf("�簢�� - ����:%d, ����:%d, ����:%d\n", width, height, volume);
		}else {
			System.out.printf("������ü - ����:%d, ����:%d, ����:%d, ����:%d\n", width, height, depth, volume);
		}
	}
	public String infoString() {
		if(depth==0) {
			return String.format("�簢�� - ����:%d, ����:%d, ����:%d\n", width, height, volume);
		}else {
			return String.format("������ü - ����:%d, ����:%d, ����:%d, ����:%d", width, height, depth, volume);
		}
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
		calVolume();
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
		calVolume();
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
		calVolume();
	}
	public int getVolume() {
		return volume;
	}
}
