package com.example.demo.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.login.service.IMemberService;

@Controller
public class LoginController {

	private final IMemberService memberService;

	public LoginController(IMemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("auth") == null) {
			return "login";
		} else {
			if (request.getAttribute("returnURL") != null) {
				return "redirect:" + request.getAttribute("returnURL");
			} else {
				return "redirect:/";
			}
		}
	}

	@PostMapping("/login")
	@ResponseBody
	public String loginProcess(HttpSession session, String id, String pw) {
		if (memberService.loginMember(id, pw)) {
			session.setAttribute("auth", id);
			return "true";
		} else {
			return "false";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
