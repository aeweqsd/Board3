package com.SpringStarter.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.*;
import com.SpringStarter.example.domain.Board;
import com.SpringStarter.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper boardMapper;
	
	@Override
	public List<Board> selectBoardList(){
		return boardMapper.selectBoardList();
		
	}
	@Override
	public List<Board> showBoardList(){
		return boardMapper.showBoardList();
	}
}
