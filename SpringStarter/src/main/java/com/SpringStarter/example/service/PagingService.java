package com.SpringStarter.example.service;

import java.util.List;

import com.SpringStarter.example.domain.*;


public interface PagingService {
	
	public Paging totalpage();  //현재 게시판의 최대 페이지 개수 구하기
	public Paging initpagservice(); //처음 사이트에 들어갔을때 페이지 설
	public List<Board> selectBoardList();// 페이지에 해당하는 게시판 보여주기
	public int pagenumber();
	public Paging changepage(int page);
}
