package com.project.odw.board.dao;

import java.util.List;

import com.project.odw.board.dto.BoardDto;

public interface BoardDao {

	public void insert(BoardDto boardDto) throws Exception;
	public List<BoardDto> selectAll() throws Exception;
	public BoardDto selectOne(int num) throws Exception;
	public void updateReadCount(int num) throws Exception;
	public void updateBoard(BoardDto boardDto) throws Exception;
	public void deleteBoard(int num) throws Exception;
}
