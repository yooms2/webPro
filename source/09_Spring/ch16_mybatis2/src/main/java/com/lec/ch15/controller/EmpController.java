package com.lec.ch15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.model.Emp;
import com.lec.ch15.service.EmpService;
import com.lec.ch15.util.Paging;

@Controller
public class EmpController {
	@Autowired
	private EmpService empSerivce;
	@RequestMapping(value="empList", method=RequestMethod.GET)
	public String empList(String pageNum, Model model) {
		// empList.do 또는 empList.do?pageNum=2
		model.addAttribute("empList", empSerivce.empList(pageNum));
		model.addAttribute("paging", new Paging(empSerivce.totCnt(), pageNum, 10, 5));
		return "empList";
	}
	@RequestMapping(value="dummyInsert", method=RequestMethod.GET)
	public String dummyInsert() {
		empSerivce.dummyDataInsert50();
		return "redirect:empDeptList.do";
	}
	@RequestMapping(value="empDeptList", method= {RequestMethod.GET, RequestMethod.POST})
	public String empDeptList(String pageNum, Model model) {
		model.addAttribute("empDeptList", empSerivce.empDeptList(pageNum));
		model.addAttribute("paging", new Paging(empSerivce.totCnt(), pageNum, 10, 10));
		return "empDeptList";
	}
	@RequestMapping(value="detail", method= {RequestMethod.GET, RequestMethod.POST})
	public String detail(int empno, Model model) {
		model.addAttribute("empDto", empSerivce.detail(empno));
		return "detail";
	}
	@RequestMapping(value="updateView", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateView(int empno, Model model) {
		model.addAttribute("empDto", empSerivce.detail(empno));
		model.addAttribute("deptList", empSerivce.deptList());
		return "update";
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Emp emp, Model model) {
//		empSerivce.update(emp);
//		return "redirect:detail.do";
		try {
			model.addAttribute("modifyResult", empSerivce.update(emp));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("modifyResult", "필드 값이 너무 길어요. 확인 요망");
			return "forward:updateView.do";
		}
		// return "forward:detail.do";
		return "forward:empDeptList.do";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int empno, Model model) {
		model.addAttribute("deleteResult", empSerivce.delete(empno));
		return "forward:empDeptList.do";
	}
	@RequestMapping(value="writeView", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeView(Model model) {
		model.addAttribute("managerList", empSerivce.managerList());
		model.addAttribute("deptList", empSerivce.deptList());
		return "write";
	}
	@RequestMapping(value="confirmNo", method=RequestMethod.GET)
	public String confirmNo(int empno, Model model) {
		if(empSerivce.detail(empno)==null) {
			model.addAttribute("confirmMsg", "사용가능한 사번 입니다");
		} else {
			model.addAttribute("confirmMsg", "중독된 사번은 사용불가 합니다");
		}
		return "forward:writeView.do";
	}
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Emp emp, Model model) {
		try {
			model.addAttribute("writeResult", empSerivce.insert(emp));
		} catch (Exception e) {
			model.addAttribute("writeResult", "필드값이 너무 길어 등록 불가");
			return "forward:writeView.do";
		}
		return "forward:empDeptList.do";
	}
}
