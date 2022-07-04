package com.example.demo.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BbsController {

	@RequestMapping("/bbs")
	public String index() {
		return "bbs/main";
	}

	@GetMapping("/bbs/write")
	public String write(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("auth") == null) {
			return "redirect:/login?returnURL=/bbs/write";
		} else {
			return "bbs/write";
		}
	}

	@PostMapping("bbs/write")
	public String writeArticle() {
		return "bbs/read";
	}

}
