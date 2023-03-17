package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.FileBoardDao;
import com.lec.ex.dto.FileBoardDto;

public class BoardReplyViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		FileBoardDao fDao = FileBoardDao.getInstance();
		FileBoardDto oriBoard = fDao.modifyViewBoard_replyViewBoard(fid);
		request.setAttribute("oriBoard", oriBoard);
	}
}
