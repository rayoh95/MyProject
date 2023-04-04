package com.project.odw.like.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.odw.like.service.LikeService;

@Controller
@RequestMapping("/like")
public class LikeController {
	
	@Autowired
	private LikeService likeService;

	@RequestMapping(value="/send", method=RequestMethod.POST)
	public ResponseEntity<Object> send(HttpServletRequest request, @RequestParam("likeReceive") String likeReceive) throws Exception {
		
		HttpSession session = request.getSession();
		
		likeService.likeSend((String)session.getAttribute("loginUser"), likeReceive);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/receiveList", method=RequestMethod.GET)
	public ModelAndView receiveList(HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		
		mv.setViewName("like/rList");
		mv.addObject("likeReceiveList", likeService.getLikeReceiveList((String)session.getAttribute("loginUser")));
		
		return mv;
	}

}
