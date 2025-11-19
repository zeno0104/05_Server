package edu.kh.jsp2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드 초기화용 생성자
// @Data 
// 이거 하나만 쓰면
// getter, setter, toString 쓰는 것과 마찬가지임!
// 모든 필드 초기화용 생성자
public class Book {
	private String title; // 제목
	private String writer; // 저자
	private int price; // 가격
	
	// 메서드 (생성자, getter/setter/toString)
}
