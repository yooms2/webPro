package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.util.Paging;
import com.lec.ch19.vo.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	String backupPath = "C:/webPro/source/09_Spring/ch19_bookupMember_sch/src/main/webapp/bookImgFileUpload/";
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}
	@Override
	public List<Book> bookList(String pageNum, Book book) {
		Paging page = new Paging(bookDao.totCntBook(book), pageNum, 3, 3);
		book.setStartRow(page.getStartRow());
		book.setEndRow(page.getEndRow());
		return bookDao.bookList(book);
	}
	@Override
	public Book getDetailBook(int bnum) {
		return bookDao.getDetailBook(bnum);
	}
	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames();
		String[] bimg = {"",""};
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 연결된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath+bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					int result = fileCopy(uploadPath+bimg[idx], backupPath+bimg[idx]);
					System.out.println(result == 1? idx+"번째 백업성공" : idx+"번째 백업실패");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			idx++;
		}
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookDao.registerBook(book);
	}
	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames();
		String[] bimg = {"",""};
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath+bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					int result = fileCopy(uploadPath+bimg[idx], backupPath+bimg[idx]);
					System.out.println(result == 1? idx+"번째 백업성공" : idx+"번째 백업실패");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			idx++;
		}
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookDao.modifyBook(book);
	}
	@Override
	public int totCntBook(Book book) {
		return bookDao.totCntBook(book);
	}
	private int fileCopy(String serverFile, String backupFile) {
		int isCopy = 0;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			File sFile = new File(serverFile);
			byte[] buff = new byte[(int) sFile.length()];
			while(true) {
				int nRead = is.read(buff);
				if(nRead == -1) break;
				os.write(buff, 0, nRead);
			}
			isCopy = 1;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
}
