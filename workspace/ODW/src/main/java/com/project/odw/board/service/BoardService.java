package com.project.odw.board.service;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.odw.board.dto.BoardDto;

public interface BoardService {

	public void insertBoard(BoardDto boardDto, HttpServletRequest request, MultipartHttpServletRequest mul) throws Exception;
	public void getBoardList(Model model, int page) throws Exception;
	public void getImage(OutputStream out, String filePath) throws Exception;
	public BoardDto getOneBoard(int num) throws Exception;
	public void updateBoard(BoardDto boardDto, MultipartHttpServletRequest mul) throws Exception;
	public void deleteBoard(int num) throws Exception;
}
