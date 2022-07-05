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
		bbsDAO.increaseViewCount(articleId);
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

	@Override
	public boolean deleteArticle(int articleId, String id) {
		ArticleDTO dto = bbsDAO.getArticle(articleId);

		if (dto != null && dto.getAuthor().equals(id)) {
			if (bbsDAO.deleteArticle(articleId) == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean editArticle(int articleId, String title, String content, String id) {
		ArticleDTO dto = bbsDAO.getArticle(articleId);

		if (dto != null && dto.getAuthor().equals(id)) {
			dto.setTitle(title);
			dto.setContent(content);
			if (bbsDAO.editArticle(dto) == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
