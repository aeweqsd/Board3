package com.SpringStarter.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.SpringStarter.example.domain.*;
import com.SpringStarter.example.mapper.PagingMapper;



@Service("PagingServiceImpl")
public class PagingServiceImpl implements PagingService{
	@Autowired PagingMapper pagingmapper;
	Paging paging = new Paging();
	
	@Override
	public Paging totalpage() { 
		paging.setMaxnum(pagingmapper.totalpage());
		int maxnum = paging.getMaxnum();
			if(maxnum%paging.getPageScale()==0) {
				paging.setTotalpage(maxnum/paging.getPageScale());
			}else {
				paging.setTotalpage((maxnum/paging.getPageScale())+1);
			}

		return paging;
	}

	@Override
	public Paging initpagservice() { 
		paging.setNowpage(1);
		paging.setMaxnum(pagingmapper.totalpage());
		int maxnum = paging.getMaxnum();
		if(maxnum%paging.getPageScale()==0) {
			paging.setTotalpage(maxnum/paging.getPageScale());
		}else {
			paging.setTotalpage((maxnum/paging.getPageScale())+1);
		}
		return paging;
	}
	
	@Override
	public List<Board> selectBoardList(){ // 페이지에 해당하는 게시판 보여주기
		return pagingmapper.selectBoardList(paging);
		
	}
	@Override
	public int pagenumber() {
		return paging.getTotalpage();
		
	}
	@Override
	public Paging changepage(int page) {
		paging.setNowpage(page);
		return paging;
	}
	
}
