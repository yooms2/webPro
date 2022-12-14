package singleton1;
/* �޸� ���� ������ ���� 	|	 heap ����
 *  Ŭ���� & static 		|	 �Ϲ� ����     */
public class Single {
	private int i;
	private Single() {}
	private static Single INSTANCE = new Single();
	public static Single getInstance() {
		// ������ ��ü �ּҸ� return
		return INSTANCE;
	}
//	private static Single INSTANCE;
//	public static Single getInstance() {
//		// ��ü ���� ������ �� ��ü �ּҸ� return�ϰ�
//		// ��ü ���� �� ������ ��ü �����ϰ� �� �ּҸ� return
//		if(INSTANCE==null) {
//			INSTANCE = new Single(); // ��ü ����
//		}
//		return INSTANCE;
//	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
