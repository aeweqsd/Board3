package com.SpringStarter.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.SpringStarter.example.domain.*;
import com.SpringStarter.example.mapper.BoardMapper;
import com.SpringStarter.example.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@org.springframework.stereotype.Controller
@SessionAttributes({"page","member"})
public class Controller {
	@Autowired BoardService boardservice;
	@Autowired PagingService pagingservice;
	@Autowired CommentService commentservice;
	@Autowired MemberService memberservice;
	@Autowired ObjectMapper objectmapper;
	
	
	@RequestMapping("login")
	public String login(Model model,HttpServletRequest request) throws JsonProcessingException{
		Member info = new Member();
		Member check = new Member();
	
		info.setMemberid(request.getParameter("id"));
		info.setPassword(request.getParameter("password"));
		String a = objectmapper.writeValueAsString(info);
		check=memberservice.selectmember(info);
		if(check.getPassword().equals(info.getPassword())) {
			model.addAttribute("member", info.getMemberid());
			return "/board";
			
		}
		return "";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		Member info = new Member();
		String id = (String) session.getAttribute("member");
		info.setMemberid(id);
		memberservice.logout(info);
		session.invalidate();
		return "/board";
		
	}
	@RequestMapping("/")
	public String home(Model model,HttpServletRequest req,HttpSession session) {
		Paging paging = new Paging();
		paging = pagingservice.initpagservice();
		List<Board> list = pagingservice.selectBoardList(paging);
		model.addAttribute("page", paging);
		model.addAttribute("list",list);
		model.addAttribute("pagenumber", pagingservice.pagenumber(paging));
	
		return "/board";
	}
	@RequestMapping("/board")
	public String board(@RequestParam(value = "pagenum", required=false) String pagenum, Model model) {
		int page= 1;
		Paging paging  = (Paging)model.getAttribute("page");
		if(!(pagenum ==null)) {
			page = Integer.parseInt(pagenum);
		}
		pagingservice.changepage(paging,page);
		List<Board> list=pagingservice.selectBoardList(paging);
		model.addAttribute("pagenumber", paging.getTotalpage());
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
	@RequestMapping("writing")
	public String insertboard(HttpServletRequest request) {
		Board board = new Board();
		board.setName(request.getParameter("name"));
		board.setContent(request.getParameter("content"));
		board.setHit(Integer.parseInt(request.getParameter("hit")));
		boardservice.insertBoard(board);
		return "/board";
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
	public String Create_member(HttpServletRequest request) {
		Member info = new Member();
		String Birthday = request.getParameter("birth_year")+request.getParameter("birth_month")+request.getParameter("birth_day");
		info.setBirthday(Birthday);
		info.setgender(request.getParameter("gender"));
		info.setMemberid(request.getParameter("id"));
		info.setName(request.getParameter("name"));
		info.setPassword(request.getParameter("password"));
		memberservice.insertmember(info);
		return "/Success";
	}
	
	

	@RequestMapping("Check_overlap") 
	public @ResponseBody String Check_id(@RequestParam("id")String id) throws JsonProcessingException {
		Map<String,Object> map = new HashMap<String, Object>();
		int exist = memberservice.overlapMember(id);
		map.put("overlap", exist);
		
		String json = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);

		return json;
		
	}
}
