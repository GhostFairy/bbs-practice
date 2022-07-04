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

}
