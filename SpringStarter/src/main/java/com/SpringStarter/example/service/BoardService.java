package com.SpringStarter.example.service;

import java.util.List;
import org.apache.ibatis.session.*;
import com.SpringStarter.example.domain.Board;

public interface BoardService {
	public List<Board> selectBoardList();
	public List<Board> showBoardList();
}
