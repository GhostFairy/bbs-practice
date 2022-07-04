package com.example.demo.login.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.dto.MemberDTO;

@Mapper
public interface IMemberDAO {

	public MemberDTO selectMember(String id);

}
