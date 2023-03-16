package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.FileBoardDao;
import com.lec.ex.dto.FileBoardDto;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("fileBoardUp");
		int maxSize = 1024*1024*2;
		String ffilename = null;
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			String param = paramNames.nextElement();
			ffilename = mRequest.getFilesystemName(param);
			HttpSession session = request.getSession();
			MemberDto member = (MemberDto)session.getAttribute("member");
			if(member!=null) {
				String mid = member.getMid();
				String ftitle = mRequest.getParameter("ftitle");
				String fcontent = mRequest.getParameter("fcontent");
				String fip = request.getRemoteAddr();
				FileBoardDao fDao = FileBoardDao.getInstance();
				int result = fDao.write(mid, ftitle, fcontent, ffilename, fip);
				if(result==FileBoardDao.SUCCESS) {
					request.setAttribute("boardResult", "글쓰기 성공");
				} else {
					request.setAttribute("boardResult", "글쓰기 실패");
				}
			} else {
				request.setAttribute("boardResult", "글쓰기는 로그인 후 작성이 가능합니다");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if(ffilename!=null) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File serverFile = new File(path + "/" + ffilename);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/webPro/source/07_jQuery/model2ex/WebContent/fileBoardUp/" + ffilename);
				byte[] bs = new byte[(int)serverFile.length()];
				int readByteCnt;
				while((readByteCnt = is.read(bs)) != -1) {
					os.write(bs, 0 , readByteCnt);
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
