package com.SpringStarter.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringStarter.example.domain.Comment;
import com.SpringStarter.example.mapper.CommentMapper;


public interface CommentService {
	public List<Comment> selectcomment(int idboard);
	public void insertcomment(Comment comment);
}
