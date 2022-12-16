package com.model;

import lombok.Data;

//DB에 Article테이블이 있다고 가정 1:1 매핑된다고 가정

@Data
public class NewArticleCommand {
	private int parentId;
	private String title;
	private String content;
}