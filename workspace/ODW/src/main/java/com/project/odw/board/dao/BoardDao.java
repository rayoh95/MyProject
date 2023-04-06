package com.project.odw.board.dao;

import java.util.List;
import java.util.Map;

import com.project.odw.board.dto.BoardDto;

public interface BoardDao {

	public void insert(BoardDto boardDto) throws Exception;
	public List<BoardDto> selectAll(Map<String, Integer> map) throws Exception;
	public int getCount() throws Exception;
	public BoardDto selectOne(int num) throws Exception;
	public void updateReadCount(int num) throws Exception;
	public void updateBoard(BoardDto boardDto) throws Exception;
	public void deleteBoard(int num) throws Exception;
}
