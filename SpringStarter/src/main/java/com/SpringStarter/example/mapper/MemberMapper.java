package com.SpringStarter.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.SpringStarter.example.domain.Member;

@Mapper
public interface MemberMapper {
	public Member selectMember(Member info);
	public void insertMember(Member info);
	public int overlapMember(String id);
}
