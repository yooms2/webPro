package com.lec.ch17.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch17.dto.Board;

@Mapper
public interface BoardDao {
	public List<Board> boardList(Board board);
	public int boardTotCnt();
	public int boardWrite(Board board);
	public void boardHitUp(int bid);
	public Board boardDetail(int bid);
	public void boardReplyPreStep(Board board);
	public int boardReply(Board board);
	public int boardModify(Board board);
	public int boardDelete(int bid);
	public Board boardContent(int bid);
	public Board boardModifyReplyView(int bid);
}
