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
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.FileBoardDao;
import com.lec.ex.dto.FileBoardDto;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardReplyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
				String path = request.getRealPath("fileBoardUp");
				int maxSize = 1024*1024*2;
				String ffilename = "";
				try {
					MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
					Enumeration<String> params = mRequest.getFileNames();
					String param = params.nextElement();
					ffilename = mRequest.getFilesystemName(param);
					// mId, fTitle, fContent,  fileName, fIp
					HttpSession session = request.getSession();
					MemberDto member = (MemberDto)session.getAttribute("member");
					if(member ==null) {
						request.setAttribute("repleyResult", "로그인 후에만 답글쓰기 가능");
						return;
					}
					String mid = member.getMid();
					String ftitle = mRequest.getParameter("ftitle");
					String fcontent = mRequest.getParameter("fcontent");
					String fip = request.getRemoteAddr();
					int fgroup = Integer.parseInt(mRequest.getParameter("fgroup"));
					int fstep = Integer.parseInt(mRequest.getParameter("fstep"));
					int findent = Integer.parseInt(mRequest.getParameter("findent"));
					FileBoardDao fDao = FileBoardDao.getInstance();
					FileBoardDto dDto = new FileBoardDto(0, mid, ftitle, fcontent, ffilename, null, 0, fgroup, fstep, findent, fip);
					int result = fDao.reply(mid, ftitle, fcontent, ffilename, fgroup, fstep, findent, fip);
					if(result == FileBoardDao.SUCCESS) { 
						request.setAttribute("replyResult", "답글쓰기 성공");
					}else {
						request.setAttribute("replyResult", "답글쓰기 실패");
					}
					request.setAttribute("pageNum", mRequest.getParameter("pageNum"));
				} catch (IOException e) {
					System.out.println(e.getMessage());
					request.setAttribute("replyResult", "답글쓰기 실패");
				}
				if(ffilename!=null) {
					InputStream  is = null;
					OutputStream os = null;
					try {
						File serverFile = new File(path + "/" + ffilename);
						is = new FileInputStream(serverFile);
						os = new FileOutputStream("C:/webPro/source/07_jQuery/model2ex/WebContent/fileBoardUp/" + ffilename);
						byte[] bs = new byte[(int)serverFile.length()];
						while(true) {
							int nByteCnt = is.read(bs);
							if(nByteCnt==-1) break;
							os.write(bs, 0, nByteCnt);
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					} finally {
						try {
							if(os!=null) os.close();
							if(is!=null) is.close();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
		}
