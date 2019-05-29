package com.neepu.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neepu.service.RainService;

@Controller
public class ExitController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	
	@RequestMapping(value="/exit")
	public ModelAndView Exit(ModelAndView mv,HttpSession session) {
		mv.setViewName("forward:/loginForm");
		session.invalidate();
		return mv;
	}
}
