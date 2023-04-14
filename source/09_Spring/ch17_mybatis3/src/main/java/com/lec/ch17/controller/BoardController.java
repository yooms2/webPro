package com.lec.ch17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch17.dto.Board;
import com.lec.ch17.service.BoardService;
import com.lec.ch17.util.Paging;

@Controller
@RequestMapping("mvcBoard")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model) {
		model.addAttribute("list", boardService.boardList(pageNum));
		model.addAttribute("paging", new Paging(boardService.boardTotCnt(), pageNum));
		return "mvcBoard/list";
	}
	@RequestMapping(value="writeView", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeView(String pageNum, Model model) {
		model.addAttribute("boardList", boardService.boardList(pageNum));
		return "mvcBoard/write";
	}	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Board board, HttpServletRequest request, Model model) {
		try {
			model.addAttribute("writeResult", boardService.boardWrite(board, request));
		} catch (Exception e) {
			model.addAttribute("writeResult", "글쓰기 실패");
			return "forward:writeView.do";
		}
		return "forward:list.do";
	}
	@RequestMapping(value="content", method= {RequestMethod.GET, RequestMethod.POST})
	public String content(int bid, Model model) {
		model.addAttribute("content", boardService.boardContent(bid));
		return "mvcBoard/content";
	}
	@RequestMapping(value="modifyView", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyView(int bid, String pageNum, Board board, Model model) {
		model.addAttribute("board", boardService.boardModifyReplyView(bid));
		model.addAttribute("boardList", boardService.boardList(pageNum));
		return "mvcBoard/modify";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(Board board, Model model, HttpServletRequest request) {
		try {
			model.addAttribute("modifyResult", boardService.boardModify(board, request));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("modifyResult", "수정 실패");
			return "forward:modifyView.do";
		}
		return "forward:content.do";
	}
	@RequestMapping(value="replyView", method= {RequestMethod.GET, RequestMethod.POST})
	public String replyView(int bid, String pageNum, Model model) {
		model.addAttribute("board", boardService.boardModifyReplyView(bid));
		model.addAttribute("boardList", boardService.boardList(pageNum));
		return "mvcBoard/reply";
	}
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(Board board, Model model, HttpServletRequest request) {
		try {
			model.addAttribute("replyResult", boardService.boardReply(board, request));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("replyResult", "답글 달기 실패하였습니다");
			return "forward:replyView.do";
		}
		return "forward:list.do";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", boardService.boardDelete(bid));
		return "forward:list.do"; 
	}
}
