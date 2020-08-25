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
@SessionAttributes({"page","member","message"})
public class Controller {
	@Autowired BoardService boardservice;
	@Autowired PagingService pagingservice;
	@Autowired CommentService commentservice;
	@Autowired MemberService memberservice;
	@Autowired ObjectMapper objectmapper;
	@Autowired MessageService messageservice;
	
	@RequestMapping("login")
	@ResponseBody
	public String login(Model model,HttpServletRequest request) throws JsonProcessingException{
		Member info = new Member();
		Member check = new Member();
		info.setMemberid(request.getParameter("id"));
		info.setPassword(request.getParameter("password"));
		String a = objectmapper.writeValueAsString(info);
		check=memberservice.selectmember(info);
		if(check.getPassword().equals(info.getPassword())) {
			model.addAttribute("member", info.getMemberid());
			model.addAttribute("message", check.getMessage());
			return a;
		}
		return "";
		
	}
	@RequestMapping("logout")
	@ResponseBody
	public String logout(Model model,HttpServletRequest request,HttpSession session) {
		Member info = new Member();
		String id = (String) session.getAttribute("member");
		info.setMemberid(id);
		memberservice.logout(info);
		session.invalidate();
		return "";
		
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
	public String board(@RequestParam(value = "pagenum", required=false) String pagenum, Model model,HttpSession session) {
		Paging paging = (Paging)session.getAttribute("page");
		paging = pagingservice.initpagservice();
		int page= 1;
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
	public String insertboard(HttpServletRequest request,HttpSession session,Model model) {
		Board board = new Board();
		String id = (String)session.getAttribute("member");
		Paging paging = (Paging)session.getAttribute("page");
		int a =memberservice.getmemberid(id);
		board.setIdmember(a);
		board.setName(request.getParameter("name"));
		board.setContent(request.getParameter("content"));
		board.setHit(Integer.parseInt(request.getParameter("hit")));
		boardservice.insertBoard(board);
		paging = pagingservice.initpagservice();
		List<Board> list=pagingservice.selectBoardList(paging);
		model.addAttribute("pagenumber", paging.getTotalpage());
		model.addAttribute("list",list);
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
	@RequestMapping("memberinfo")
	public String memberinfo(@RequestParam(value = "idmember",required=true)String idmember,Model model) {
		Member info = new Member();
		Member info2 = new Member();
		info.setIdmember(Integer.parseInt(idmember));
		info2 = memberservice.memberinfo(info);
		model.addAttribute("info", info2);
		return "/memberinfo";
	}
	@RequestMapping("SendMessage")
	public String Send_Message(@RequestParam(value = "receiver",required=true)String receiver,
							   @RequestParam(value = "sender",required=true)String sender,
							   Model model) {
		Member info = new Member();
		info.setIdmember(Integer.parseInt(receiver));
		info = memberservice.memberinfo(info);
		model.addAttribute("info",info);
		model.addAttribute("sender", sender);
		return "/SendMessage";
		
	}
	@RequestMapping("sending")
	public String sending(Message message) {
		message.setIs_read(false);
		messageservice.insertmessage(message);
		return "/Success";
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
	@RequestMapping("insert_comment")
	public String insert_comment(@RequestParam(value = "id",required=true)String idboard,
			@RequestParam(value = "writer",required=true)String writer,
			@RequestParam(value = "content",required=true)String content,
			@RequestParam(value ="selfkey",required=false)String selfkey,
			Model model) {
		Comment info = new Comment();
		info.setBoard_idboard(Integer.parseInt(idboard));
		info.setContent(content);
		info.setIdmember(memberservice.getmemberid(writer));
		if(selfkey !=null) {
			info.setSelfkey(Integer.parseInt(selfkey));
		}else {
			info.setSelfkey(0);
		}
		commentservice.insertcomment(info);
		List<Comment> list = commentservice.selectcomment(Integer.parseInt(idboard));
		model.addAttribute("list", list);
		return "/comment";
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
