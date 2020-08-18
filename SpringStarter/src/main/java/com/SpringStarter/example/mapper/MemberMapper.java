package com.SpringStarter.example.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.SpringStarter.example.domain.Member;

@Mapper
public interface MemberMapper {
	public Member selectMember(Member info);
}
