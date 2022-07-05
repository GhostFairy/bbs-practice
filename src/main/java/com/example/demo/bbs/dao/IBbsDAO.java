package com.example.demo.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bbs.dto.ArticleDTO;
import com.example.demo.bbs.dto.ArticleListDTO;

@Mapper
public interface IBbsDAO {

	List<ArticleListDTO> getArticleList();

	ArticleDTO getArticle(int articleId);

	int writeArticle(ArticleDTO dto);
	
	int deleteArticle(int articleId);
	
	int editArticle(ArticleDTO dto);
}
