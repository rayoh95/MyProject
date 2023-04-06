package com.project.odw.board.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.project.odw.board.dto.BoardDto;
import com.project.odw.board.service.BoardService;
import com.project.odw.reply.service.ReplyService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService; 
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public ModelAndView write() {
		return new ModelAndView("board/bWrite");
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public ModelAndView write(BoardDto boardDto, HttpServletRequest request, MultipartHttpServletRequest mul) throws Exception {
		
		boardService.insertBoard(boardDto, request, mul);
		
		return new ModelAndView("redirect:boardList");
	}
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String boardList(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) throws Exception {
		
		boardService.getBoardList(model, page);
		
		return "board/bList";
	}
	
	@RequestMapping(value="/image", method=RequestMethod.GET)
	public void image(@RequestParam("fileName") String fileName , HttpServletResponse response) throws Exception {
		
		OutputStream out = response.getOutputStream();
		String filePath = "/Users/oseunghwan/Desktop/Spring_project/workspace/ODW/src/main/webapp/WEB-INF/views/board/board_images/" + fileName;

		boardService.getImage(out, filePath);
	}
	
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public ModelAndView info(@RequestParam("num") int num) throws Exception {
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/bInfo");
		mv.addObject("boardDto", boardService.getOneBoard(num));
		mv.addObject("replyList", replyService.getReplyList(num));
		
		return mv;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam("num") int num) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/bUpdate");
		mv.addObject("boardDto", boardService.getOneBoard(num));
		
		return mv;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(BoardDto boardDto, MultipartHttpServletRequest mul, HttpServletRequest request, @RequestParam("num") int num) throws Exception {
		
		String htmlBody = "";
		boardDto.setNum(num);
		
		boardService.updateBoard(boardDto, mul);
		
		htmlBody = "<script>";
		htmlBody += "alert('updated successfuly!');";
		htmlBody += "location.href='"+ request.getContextPath()+"/board/boardList'";
		htmlBody += "</script>";
		
		return htmlBody;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public @ResponseBody String delete(HttpServletRequest request, @RequestParam("num") int num) throws Exception {
		
		String htmlBody = "";
		boardService.deleteBoard(num);
		
		htmlBody = "<script>";
		htmlBody += "alert('It has been deleted successfuly.');";
		htmlBody += "location.href='"+ request.getContextPath()+"/board/boardList'";
		htmlBody += "</script>";
		
		return htmlBody;
	}
	
}
