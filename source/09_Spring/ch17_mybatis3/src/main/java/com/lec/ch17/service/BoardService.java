package com.lec.ch17.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.ch17.dto.Board;

public interface BoardService {
	public List<Board> boardList(String pageNum);
	public int boardTotCnt();
	public int boardWrite(Board board, HttpServletRequest request);
	public Board boardContent(int bid);
	public Board boardModifyReplyView(int bid);
	public int boardReply(Board board, HttpServletRequest request);
	public int boardModify(Board board, HttpServletRequest request);
	public int boardDelete(int bid);
}
