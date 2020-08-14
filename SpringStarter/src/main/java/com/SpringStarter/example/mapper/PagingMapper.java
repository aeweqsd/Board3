package com.SpringStarter.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.SpringStarter.example.domain.Board;
import com.SpringStarter.example.domain.Paging;

@Mapper
public interface PagingMapper {
	
	public int totalpage();
	public List<Board> selectBoardList(Paging paging);
}
