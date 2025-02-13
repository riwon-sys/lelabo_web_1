package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class BoardDto {
	private int bno;              
    private String btitle;                 
    private String bcontent;
    private int bview;
    private String bdate;
    private int mno; 
    private int cno;
// Dto 목적은? 데이터베이스에 있는 것을 화면단으로 옮기는 이동객체 데이터베이스 기준으로 확인
    private String mid; // html 출력시 회원번호가 아닌 회원아이디 출력
    private String cname; // html 출력시 카테고리번호가 아닌 카테고리명 출력
}
