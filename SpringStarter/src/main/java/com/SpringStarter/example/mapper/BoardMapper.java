package com.SpringStarter.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.SpringStarter.example.domain.Board;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList();
	public List<Board> showBoardList();
	public Board selectBoard(int boardnum);
	public void updateBoardhit(Board board);
}
