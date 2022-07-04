package com.example.demo.bbs.service;

import java.util.List;

import com.example.demo.bbs.dto.ArticleDTO;
import com.example.demo.bbs.dto.ArticleListDTO;

public interface IBbsService {

	public List<ArticleListDTO> getArticleList();

	public ArticleDTO getArticle(int articleId);

	public int writeArticle(String title, String content, String id);

}
