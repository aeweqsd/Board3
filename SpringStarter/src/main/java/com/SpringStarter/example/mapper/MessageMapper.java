package com.SpringStarter.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.SpringStarter.example.domain.Message;
@Mapper
public interface MessageMapper {
	public void insertmessage(Message info);
}
