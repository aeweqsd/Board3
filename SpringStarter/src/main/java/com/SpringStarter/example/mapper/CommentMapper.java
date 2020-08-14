package com.SpringStarter.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.SpringStarter.example.domain.Comment;

@Mapper
public interface CommentMapper {
	public List<Comment> selectcomment(int idboard);
}
