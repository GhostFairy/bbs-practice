package com.example.demo.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bbs.dto.ArticleDTO;
import com.example.demo.bbs.dto.ArticleListDTO;

@Mapper
public interface IBbsDAO {

	List<ArticleListDTO> getArticleList();

	ArticleDTO getArticle(int articleId);

	int writeArticle(String title, String content, String id);
}
