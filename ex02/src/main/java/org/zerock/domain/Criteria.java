package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {
	//페이지 번호, 한페이지당 개수
	private int pageNum=1;
	private int amount=10;
	
	//검색에 관련된 정보 추가 (검색조건type,검색어 keyword)
	private String type;
	private String keyword;
	
	//기본생성자 ->기본값 1,10
	public Criteria() {
		
	}
	//추가 생성자->값을 넣어서 만들기
	
	//여러검색조건인 문자열을 분리해서 문자열배열로 만들기
	public String[] getTypeArr() {
		return type==null ? new String[] {} :type.split("");
	}
}
