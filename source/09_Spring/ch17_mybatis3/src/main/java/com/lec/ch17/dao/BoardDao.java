package com.lec.ch17.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch17.dto.Board;

@Mapper
public interface BoardDao {
	public List<Board> boardList(Board board);
	public int boardTotCnt();
	public int boardWrite(Board board);
	public Board boardContent(int bid);
	public Board boardModifyReplyView(int bid);
	public int boardReply(Board board);
	public int boardModify(Board board);
	public int boardDelete(int bid);
}
