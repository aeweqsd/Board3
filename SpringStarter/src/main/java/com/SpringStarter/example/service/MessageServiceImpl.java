package com.SpringStarter.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringStarter.example.domain.Message;
import com.SpringStarter.example.mapper.MemberMapper;
import com.SpringStarter.example.mapper.MessageMapper;

@Service("MessageServiceImpl")
public class MessageServiceImpl implements MessageService {
	@Autowired MessageMapper messagemapper;
	@Autowired MemberMapper membermapper;
	
	@Override
	public void insertmessage(Message info) {
		String id = info.getReceiver();
		membermapper.sendmessage(id);
		messagemapper.insertmessage(info);
		
	}
}
