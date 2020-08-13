package com.SpringStarter.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringStarter.example.domain.Paging;
import com.SpringStarter.example.mapper.PagingMapper;



@Service("PagingServiceImpl")
public class PagingServiceImpl implements PagingService{
	@Autowired PagingMapper pagingmapper;
	public int maxnum() {
		return pagingmapper.maxnum();
	}
}
