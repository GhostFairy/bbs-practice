package com.example.demo.login.service;

import org.springframework.stereotype.Service;

import com.example.demo.login.dao.IMemberDAO;
import com.example.demo.login.dto.MemberDTO;

@Service("MemberService")
public class MemberServiceImpl implements IMemberService {

	private final IMemberDAO memberDAO;

	public MemberServiceImpl(IMemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public MemberDTO selectMember(String id) {
		return memberDAO.selectMember(id);
	}

	@Override
	public boolean loginMember(String id, String pw) {
		MemberDTO dto = memberDAO.selectMember(id);

		if (dto != null && dto.getPw().equals(pw)) {
			return true;
		} else {
			return false;
		}
	}

}
