package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.model.Photo;

@Controller
@RequestMapping("/image/upload.do")
public class ImageController {

	@GetMapping
	public String form() {
		return "image/image";  //뷰를 보여주자
	}
	
	@PostMapping
	public String submit(Photo photo, HttpServletRequest request){
		/*
		1. Photo DTO 타입으로 데이터 받기
		1.1 자동 위해서 : name 속성값이 Photo 클래스 타입의 멤버 필드 명과 동일
		2. public String submit(Photo photo)내부적으로....
		-> Photo photo = new Photo();
		-> photo.setName("홍길동");
		-> photo.setAge(20);
		-> photo.setImage();  -> 자동 주입 안되요 ->  수동으로 -> 가공 coomonsMultipartFile 추출 (이름)
		-> photo.setFile(coomonsMultipartFile file) 파일 자동으로 들어와요
		 */
		System.out.println(photo.toString());
		
		CommonsMultipartFile imagefile = photo.getFile(); //업로드한 파일정보
		System.out.println("이미지파일 이름 : " + imagefile.getName());
		System.out.println("이미지파일 컨텐츠 타입 : " + imagefile.getContentType());
		System.out.println("이미지파일 오리진 파일이름 : " + imagefile.getOriginalFilename());
		System.out.println("이미지파일 바이트 크기 : " + imagefile.getBytes().length);
		
		//POINT DB에 들어갈 파일명 추출
		photo.setImage(imagefile.getName());
		
		//cos.jar 자동 파일 업로드 
		//C:\Spring\Labs\.metadata\.pluginsorg.eclipse.wst.server.core\tmp0wtpwebapps\SpringMVC_Basic03_Annotationupload
		//실제 파일 업로드 구현 (upload 업로드)
				String filename = imagefile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/upload"); //배포된 서버 경로 
				String fpath = path + "\\" + filename;
				System.out.println(fpath);
				
				FileOutputStream fs =null;
				try {
					     fs = new FileOutputStream(fpath);
					     fs.write(imagefile.getBytes());
					     
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					 try {
						fs.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				//DB작업 .... 파일 업로드 완료
				return "image/image";
	}
}
