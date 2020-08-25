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
		membermapper.login(info);
		return membermapper.selectMember(info);
	}
	@Override
	public void insertmember(Member info) {
		membermapper.insertMember(info);
	}
	@Override
	public int overlapMember(String id) {
		return membermapper.overlapMember(id);
		
	}
	@Override
	public void logout(Member info) {
		membermapper.logout(info);
	}
	@Override
	public int getmemberid(String memberid) {
		return membermapper.getmemberid(memberid);
	}
	@Override
	public Member memberinfo(Member info) {
		return membermapper.memberinfo(info);
	}
}
