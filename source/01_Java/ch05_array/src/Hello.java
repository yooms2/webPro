// javac.exe Hello.jva
// java.exe Hello 진 RM 정국 뷔
public class Hello {
	public static void main(String[] args) { // args는 배열을 뜻함 -- 진 RM 정국 뷔(배열 방 개수 4개)
		System.out.print("Hello");
		for(int i=0 ; i<args.length ; i++) {
			System.out.print(", " + args[i]);
		}
	}

}
