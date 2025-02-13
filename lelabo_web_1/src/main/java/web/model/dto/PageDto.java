package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor
public class PageDto { // 페이징 처리된 데이터들의 이동객체
	private int totalCount; // 전체 자료개수(검색결과 조회시 사용)
	private int page; // 현재 페이지
	private int totalpage; // 전체 페이지 수
	private int startbtn; // 페이징 버튼 시작번호
	private int endbtn; // 페이징 버튼 끝 번호
	private Object data; // 페이징된 자료

}
