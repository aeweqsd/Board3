package com.SpringStarter.example.service;

import java.util.List;

import com.SpringStarter.example.domain.*;


public interface PagingService {
	
	public Paging totalpage();  //���� �Խ����� �ִ� ������ ���� ���ϱ�
	public Paging initpagservice(); //ó�� ����Ʈ�� ������ ������ ��
	public List<Board> selectBoardList();// �������� �ش��ϴ� �Խ��� �����ֱ�
	public int pagenumber();
	public Paging changepage(int page);
}
