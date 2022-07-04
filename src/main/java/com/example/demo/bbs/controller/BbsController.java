package com.example.demo.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bbs.service.IBbsService;

@Controller
public class BbsController {

	private final IBbsService bbsService;

	public BbsController(IBbsService bbsService) {
		this.bbsService = bbsService;
	}

	@RequestMapping("/bbs")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("articleList", bbsService.getArticleList());
		mv.setViewName("bbs/main");
		return mv;
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

	@PostMapping("/bbs/write")
	@ResponseBody
	public String writeArticle(HttpSession session, String title, String content) {
		String id = (String) session.getAttribute("auth");
		return String.valueOf(bbsService.writeArticle(title, content, id));
	}

	@RequestMapping("/bbs/read")
	public ModelAndView read(int articleId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("article", bbsService.getArticle(articleId));
		mv.setViewName("bbs/read");
		return mv;
	}

}
