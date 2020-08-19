package com.SpringStarter.example.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringStarter.example.domain.*;

import com.SpringStarter.example.service.*;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired BoardService boardservice;
	@Autowired PagingService pagingservice;
	@Autowired CommentService commentservice;
	@Autowired MemberService memberservice;
	
	@RequestMapping("login")
	public Member login(HttpServletRequest request){
		Member info = new Member();
		Member check = new Member();
		info.setMemberid(request.getParameter("id"));
		info.setPassword(request.getParameter("password"));
		check=memberservice.selectmember(info);
		if(check.getPassword().equals(info.getPassword())) {
			return check;
			
		}
		return info;
	}
	@RequestMapping("/")
	public String home(Model model) {
		
		pagingservice.initpagservice();
		List<Board> list = pagingservice.selectBoardList();
		model.addAttribute("list",list);
		System.out.println(pagingservice.pagenumber());
		model.addAttribute("pagenumber", pagingservice.pagenumber());
	
		return "/board";
	}
	@RequestMapping("/board")
	public String board(@RequestParam("pagenum") String pagenum,Model model) {
		int page = Integer.parseInt(pagenum);
		pagingservice.changepage(page);
		List<Board> list=pagingservice.selectBoardList();
		model.addAttribute("pagenumber", pagingservice.pagenumber());
		model.addAttribute("list",list);
		return "/board";
	}
	@RequestMapping("boardsee")
	public String boardsee(@RequestParam("boardnumber")String boardnumber,Model model) {
		int boardnum =Integer.parseInt(boardnumber);
		model.addAttribute("board", boardservice.selectBoard(boardnum));
		return "/boardsee";
	}
	@RequestMapping("write")
	public String boardwrite(Model model) {
		return "/write";
	}
	@RequestMapping("show_comment")
	public String show_comment(@RequestParam(value = "idboard",required=true)String idboard,Model model) {
		List<Comment> list = commentservice.selectcomment(Integer.parseInt(idboard));
		model.addAttribute("list", list);
		return "/comment";
	}
	@RequestMapping("Register")
	public String Register() {
		return "/Register";
	}
	@RequestMapping("Create_member")
	public void Create_member(HttpServletRequest request) {
		Member info = new Member();
		String Birthday = request.getParameter("birth_year")+request.getParameter("birth_month")+request.getParameter("birth_day");
		info.setBirthday(Birthday);
		info.setgender(request.getParameter("gender"));
		info.setMemberid(request.getParameter("id"));
		info.setName(request.getParameter("name"));
		info.setPassword(request.getParameter("password"));
		memberservice.insertmember(info);
	}
}
