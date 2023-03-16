package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.FileBoardDao;
import com.lec.ex.dto.FileBoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardModifyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("fileBoardUp");
		int maxSize = 1024*1024*2;
		String ffilename = "", dbffilename = null;
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			System.out.println("글수정x");
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			ffilename = mRequest.getFilesystemName(param);
			dbffilename = mRequest.getParameter("dbfilename");
			if(ffilename==null) {
				ffilename = dbffilename;
				System.out.println("글수정x");
			}
			int fid = Integer.parseInt(mRequest.getParameter("fid"));
			String mid = mRequest.getParameter("mid");
			String ftitle = mRequest.getParameter("ftitle");
			String fcontent = mRequest.getParameter("fcontent");
			String fip = request.getRemoteAddr();
			System.out.println("글수정x");
			FileBoardDao fDao = FileBoardDao.getInstance();
			FileBoardDto fDto = new FileBoardDto(fid, mid, ftitle, fcontent, ffilename, null, 0, 0, 0, 0, fip);
			int result = fDao.modify(fid, ftitle, fcontent, ffilename, fip);
			if(result == FileBoardDao.SUCCESS) {
				request.setAttribute("fileResult", "글수정 성공");
			} else {
				request.setAttribute("fileResult", "글수정 실패");
			}
			request.setAttribute("pageNum", mRequest.getParameter("pageNum"));
		} catch (IOException e) {
			System.out.println(e.getMessage() + "글수정x");
		}
		if(dbffilename!=null && !ffilename.equals(dbffilename)) {
			InputStream is= null;
			OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + ffilename);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/webPro/source/07_jQuery/model2ex/WebContent/fileBoardUp/" + ffilename);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt==-1) break;
					os.write(bs, 0, readByteCnt);
				}
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
		}
	}
}
