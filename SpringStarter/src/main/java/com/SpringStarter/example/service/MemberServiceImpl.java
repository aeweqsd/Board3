package com.SpringStarter.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringStarter.example.domain.Member;
import com.SpringStarter.example.mapper.MemberMapper;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper membermapper;
	@Override
	public Member selectmember(Member info) {
		return membermapper.selectMember(info);
	}

}
