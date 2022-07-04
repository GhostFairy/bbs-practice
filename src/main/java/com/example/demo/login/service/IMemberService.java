package com.example.demo.login.service;

import com.example.demo.login.dto.MemberDTO;

public interface IMemberService {

	public MemberDTO selectMember(String id);

	public boolean loginMember(String id, String pw);

}
