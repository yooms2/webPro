package com.lec.ch17.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lec.ch17.dao.BoardDao;
import com.lec.ch17.dto.Board;

public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public List<Board> boardList(String pageNum) {
		return null;
	}
	@Override
	public int boardTotCnt() {
		return 0;
	}
	@Override
	public int boardWrite(Board board) {
		return 0;
	}
	@Override
	public Board boardContent(int bid) {
		return null;
	}
	@Override
	public Board boardModifyReplyView(int bid) {
		return null;
	}
	@Override
	public int boardReply(Board board) {
		return 0;
	}
	@Override
	public int boardModify(Board board) {
		return 0;
	}
	@Override
	public int boardDelete(int bid) {
		return 0;
	}
}
