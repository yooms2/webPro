package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.FileBoardDao;

public class BoardDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		FileBoardDao fDao = FileBoardDao.getInstance();
		int result = fDao.delete(fid);
		if(result == FileBoardDao.SUCCESS) {
			request.setAttribute("deleteResult", "글 삭제 성공");
		}else {
			request.setAttribute("deleteResult", "글 삭제 실패");
		}
	}
}
