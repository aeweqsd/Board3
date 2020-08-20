package com.SpringStarter.example.service;

import java.util.List;

import com.SpringStarter.example.domain.*;


public interface PagingService {
	
	public Paging totalpage(Paging paging);  //���� �Խ����� �ִ� ������ ���� ���ϱ�
	public Paging initpagservice(); //ó�� ����Ʈ�� ������ ������ ��
	public List<Board> selectBoardList(Paging paging);// �������� �ش��ϴ� �Խ��� �����ֱ�
	public int pagenumber(Paging paging);
	public Paging changepage(Paging paging,int page);
}
