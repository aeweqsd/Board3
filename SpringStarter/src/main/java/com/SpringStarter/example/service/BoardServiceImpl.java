package com.SpringStarter.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.*;
import com.SpringStarter.example.domain.Board;
import com.SpringStarter.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper boardmapper;
	
	@Override
	public List<Board> selectBoardList(){
		return boardmapper.selectBoardList();
		
	}
	@Override
	public List<Board> showBoardList(){
		return boardmapper.showBoardList();
	}
	@Override
	public Board selectBoard(int boardnum) {
		boardmapper.updateBoardhit(boardmapper.selectBoard(boardnum));
		return boardmapper.selectBoard(boardnum);
	}
	@Override
	public void insertBoard(Board board) {
		String time =boardmapper.updatetime();
		board.setTime(time);
		boardmapper.insertBoard(board);
	}
}
