package com.service;

import org.springframework.stereotype.Service;

import com.model.NewArticleCommand;

/*
@Service  :  너는 빈(bean)객체로 생성되어야 해

xml 파일에
<context:component-scan base-package="com.service">
 */

@Service
public class ArticleService {
	public ArticleService() {
		System.out.println("ArticleService 생성자 호출");
	}
	
    public void writeAreicle(NewArticleCommand command) {
    	//DAO 가정하고
    	//Insert됬다 가정하고
    	System.out.println("글쓰기 작업완료 : " + command.toString());
    }
}
