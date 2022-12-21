package com.lec.ex1_inputstreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// JSP나 Spring에서 파일첨부게시판 작성시 copy할 로직
// C:\webPro\note\bts.mp4 => C:\webPro\note/bts_copy.mp4 (8,075,033 byte)
public class Ex05_FileCopyStep3 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 1970.1.1 부터 시작시점까지의 밀리세컨
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File("C:\\webPro\\note\\bts.mp4");
			is = new FileInputStream(file); // 1. 스트림 객체 생성
			os = new FileOutputStream("C:/webPro/note/bts_copy.mp4"); // true(x) : 덮어쓰기, true(o) : 새로 추가 
			byte[] bs = new byte[(int)file.length()]; // 1킬로바이트
			int cnt = 0;
			while(true) { // 2 번쯤 수행
				cnt++;
				int count = is.read(bs); // 2. read(bs에 읽는다) & write : 
				if(count == -1) break;
				os.write(bs, 0, count); // bs배열을 0번 index부터 count 바이트 만큼 write
			}
			System.out.println(cnt + "번 while 실행하여 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println("파일이나 폴더를 못 찾음" + e.getMessage());
		} catch (IOException e) {
			System.out.println("read & writer" + e.getMessage());
		} finally {
			try {
				if(os!=null) os.close(); // 3. 파일 닫기(스트림 해제)
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		long end = System.currentTimeMillis(); // 1970.1.1 ~ 끝나는 시점까지의 밀리세컨
		System.out.println(end-start);
	} // main
}
