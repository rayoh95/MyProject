package com.project.odw.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.odw.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(BoardDto boardDto) throws Exception {
		sqlSession.insert("mapper.board.insertBoard", boardDto);
	}

	@Override
	public List<BoardDto> selectAll() throws Exception {
		return sqlSession.selectList("mapper.board.getBoardList");
	}

	@Override
	public BoardDto selectOne(int num) throws Exception {
		return sqlSession.selectOne("mapper.board.getOneBoard", num);
	}

	@Override
	public void updateReadCount(int num) throws Exception {
		sqlSession.update("mapper.board.increaseReadCount", num);
	}

	@Override
	public void updateBoard(BoardDto boardDto) throws Exception {
		sqlSession.update("mapper.board.updateBoard", boardDto);
	}

	@Override
	public void deleteBoard(int num) throws Exception {
		sqlSession.delete("mapper.board.deleteBoard", num);
	}

}
