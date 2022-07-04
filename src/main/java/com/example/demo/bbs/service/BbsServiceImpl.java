package com.example.demo.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bbs.dao.IBbsDAO;
import com.example.demo.bbs.dto.ArticleDTO;
import com.example.demo.bbs.dto.ArticleListDTO;

@Service("BbsService")
public class BbsServiceImpl implements IBbsService {

	private final IBbsDAO bbsDAO;

	public BbsServiceImpl(IBbsDAO bbsDAO) {
		this.bbsDAO = bbsDAO;
	}

	@Override
	public List<ArticleListDTO> getArticleList() {
		return bbsDAO.getArticleList();
	}

	@Override
	public ArticleDTO getArticle(int articleId) {
		return bbsDAO.getArticle(articleId);
	}

	@Override
	public int writeArticle(String title, String content, String id) {
		ArticleDTO dto = new ArticleDTO(title, content, id);
		if (bbsDAO.writeArticle(dto) == 1) {
			return dto.getArticleId();
		} else {
			return -1;
		}
	}

}
