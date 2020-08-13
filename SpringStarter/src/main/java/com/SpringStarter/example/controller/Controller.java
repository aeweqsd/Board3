package com.SpringStarter.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringStarter.example.domain.Board;
import com.SpringStarter.example.service.*;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired BoardService boardservice;

	@RequestMapping("/")
	public String home(Model model) {
		List<Board> list=boardservice.showBoardList(); //we have to know about rowbound!!
	
		model.addAttribute("list",list);
		
	
		return "/index";
	}
}
