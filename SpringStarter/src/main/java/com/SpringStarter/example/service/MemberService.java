package com.SpringStarter.example.service;

import java.util.List;
import com.SpringStarter.example.domain.Member;


public interface MemberService {
	public Member selectmember(Member info);
	public void insertmember(Member info);
}
