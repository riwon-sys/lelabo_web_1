	package day05.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
	private Connection conn;
	
	// 싱글톤 패턴 적용
	private static BoardDao instance = new BoardDao();
	private BoardDao() {
		try {
			// (1) jdbc 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// (2) db 연결
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0122",
					"root",
					"1234"
					);
	    } catch (Exception e) {
			System.out.println("DB 연결 실패 : " + e);
		}
	}
	public static BoardDao getInstance() {
		return instance;
	}
 
	// [1] 게시물 등록
	public boolean boardWrite( BoardDto boardDto ) {
		try {
			String sql = "insert into board(btitle , bcontent , bwriter , bpwd) values (? , ? , ? , ?)";
		    PreparedStatement ps =conn.prepareStatement(sql);
		    ps.setString(1, boardDto.getBtitle());
		    ps.setString(2, boardDto.getBcontent());
		    ps.setString(3, boardDto.getBwriter());
		    ps.setString(4, boardDto.getBpwd());
		    int count = ps.executeUpdate();
		    if (count ==1) return true;
	   } catch (Exception e) {System.out.println(e);
			
	   }
	   return false;
	} //fe
	
	// [2] 게시물 전체 조회
	public ArrayList<BoardDto>findAll(){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			 String sql ="select * from board";
			 PreparedStatement ps =conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 BoardDto boardDto = new BoardDto();
				 boardDto.setBno(rs.getInt("bno"));
				 boardDto.setBtitle(rs.getString("btitle"));
				 boardDto.setBwriter(rs.getString("bwriter"));
				 boardDto.setBdate(rs.getString("bview"));
				 boardDto.setBview(rs.getInt("bview"));
				 list.add(boardDto);
			 }
		} catch (Exception e) { System.out.println(e);}
		  return list;
		} //fe
	
	// [3] 게시물 개별 조회
	public BoardDto findById (int bno) {
		try {
			String sql = "select * from board where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if( rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBwriter(rs.getString("bwriter"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setBpwd(rs.getString("bpwd"));
				boardDto.setBcontent(rs.getString("bcontent"));
				return boardDto;
			}
		} catch (Exception e) { System.out.println(e);
			
		} return null;
	} // fe
	
	// [5] 삭제
	public boolean delete( int bno ) {
		try {
			String sql = "delete from board where bno =?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if(count ==1) return true;
					
		} catch (Exception e) {System.out.println(e);}
		 return false; 	
	} // fe
	
	// [6] 수정
	public boolean update( BoardDto boardDto ) {
		try {
			String sql = "update board set btitle =? , bcontent =? "+ "where bno =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getBno());
			int count = ps.executeUpdate();
			if(count ==1)return true;
			
		} catch (Exception e) {System.out.println(e);
			// TODO: handle exception
		}
		return false;
	}
	
} //ce
