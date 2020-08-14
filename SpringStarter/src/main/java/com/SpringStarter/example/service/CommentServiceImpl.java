package com.SpringStarter.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringStarter.example.domain.Comment;
import com.SpringStarter.example.mapper.CommentMapper;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {
	@Autowired CommentMapper commentmapper;
	@Override
	public List<Comment> selectcomment(int idboard){
		return commentmapper.selectcomment(idboard);
		
		
	}
}
