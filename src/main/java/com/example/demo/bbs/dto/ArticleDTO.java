package com.example.demo.bbs.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDTO {

	private int articleId;
	private String title;
	private String content;
	private String author;
	private Date writeDate;
	private int viewCount;

	public ArticleDTO() {
	}

	public ArticleDTO(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
