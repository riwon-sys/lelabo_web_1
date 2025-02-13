package web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.MemberDto;
import web.model.dto.PointDto;


// @Getter // 클래스 내 모든 멤버변수에 getter 적용 
@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE) // 클래스 내 디폴트생성자를 PRIVATE 적용
public class MemberDao extends Dao {
	
	@Getter // 클래스가 아닌 지정된 멤버변수에 lombok 을 사용하면 지정된 멤버변수만 적용 가능
	private static MemberDao instance = new MemberDao();
	// private MemberDao(){}
	
	// [1] 회원가입 등록
	  // [1]. 회원가입 SQL 처리 메소드 
    public int signup( MemberDto memberDto ) {
            try {
                    // [1] SQL 작성한다.
                    String sql ="insert into member( mid , mpwd , mname , mphone , mimg ) values( ? , ? , ? , ? , ? )";
                    // [2] DB와 연동된 곳에 SQL 기재한다.                 
                    PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS );
                    ps.setString( 1 , memberDto.getMid() );
                    ps.setString( 2 , memberDto.getMpwd() );
                    ps.setString( 3 , memberDto.getMname() );
                    ps.setString( 4 , memberDto.getMphone() );
                    ps.setString( 5 , memberDto.getMimg() );
                    // [3] 기재된 SQL를 실행하고 결과를 받는다. .         
                    int count = ps.executeUpdate();
                    // [4] 결과에 따른 처리 및 반환를 한다.
                    if( count == 1 ) { 
                            ResultSet rs = ps.getGeneratedKeys();
                            if( rs.next() ) {
                                      int mno = rs.getInt( 1 );
                                      return mno; // 회원가입 성공후 등록한 회원번호 반환 
                            }
                    }
            }catch( SQLException e ) { System.out.println( e ); }
            return 0; // 회원가입 실패시 0 반환
    } // f end 
	
	// [2] 로그인 SQL 처리 메소드
	public int login(MemberDto memberDto) {
		try {
			// [1] SQL 작성한다.
			String sql = "select mno from member where mid =? and mpwd =? ";
			// [2] DB와 연동된 곳에 SQL 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			// [*] 기재된 SQL 에 매개변수 값 대입한다.
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			// [3] 기재된 SQL 실행하고 결과를 받는다.
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환을 한다
			if(rs.next()) {
				int mno =rs.getInt("mno");
				return mno; // 0 초과이면 로그인 성공한 회원번호
			}
		} catch (Exception e) {System.out.println(e);}
		return 0; // 0 이면 로그인 실패
	}
	// [3]. 내정보 보기 SQL 처리 메소드 
    public MemberDto myInfo( int loginMno ) {
            try {
                    String sql ="select * from member where mno = ? "; // [1] SQL 작성한다.
                    PreparedStatement ps = conn.prepareStatement(sql); // [2] DB와 연동된 곳에 SQL 기재한다.
                    ps.setInt(  1 , loginMno); // [*] 기재된 SQL 에 매개변수 값 대입한다.
                    ResultSet rs = ps.executeQuery(); // [3] 기재된 SQL 실행하고 결과를 받는다.
                    if( rs.next() ) { // [4] 결과에 따른 처리 및 반환를 한다.
                            MemberDto memberDto = new MemberDto();
                            memberDto.setMno(rs.getInt("Mno") );
                            memberDto.setMid( rs.getString("mid") );
                            memberDto.setMname( rs.getString("mname" ) );
                            memberDto.setMphone( rs.getString("mphone") );
                            memberDto.setMdate( rs.getString("mdate") );
                            memberDto.setMimg(rs.getString("mimg") );
                            return memberDto; // 조회된 회원정보를 반환한다.
                    }
            }catch(SQLException e ) { System.out.println(e);}
            return null; // 조회된 회원정보가 없을때. null 반환한다
    } // f end
    // [4]. 회원 탈퇴 SQL 처리 메소드
    public boolean delete( int loginMno ) {
    	try {
			String sql = "delete from member where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 ,loginMno);
			int count = ps.executeUpdate();
			if( count ==1) return true;
		} catch (Exception e) {System.out.println(e);}
    	return false;
    }
    // [5] 회원수정 SQL 처리 메소드
    public boolean update( MemberDto memberDto ) {
    	try {
    	// [1] sql 작성한다.
    	String sql ="update member set mpwd =? , mname =? , mphone =? where mno = ? ";
    	// [2] DB와 연동된 곳(conn) 에 SQL 기재한다.
    	PreparedStatement ps = conn.prepareStatement(sql);
    	// [*] 기재된 SQL 에 매개변수 값 대입한다.
    	ps.setString(1, memberDto.getMpwd());
    	ps.setString(2, memberDto.getMname());
    	ps.setString(3, memberDto.getMphone());
    	ps.setInt(4, memberDto.getMno());
    	// [3] 기재된 SQL 실행하고 결과를 받는다.
    	int count = ps.executeUpdate();
    	// [4] 결고에 따른 처리 및 반환을 한다.
    	if(count ==1) {return true;} // 수정 성공 했을때
    	}catch (SQLException e) {System.out.println(e);}
    	return false; // 수정 실패 했을때
    } //fe
    
    // [6] 내 포인트 로그 전체 조회
    public ArrayList< PointDto > getPointLog( int loginMno ) {
            ArrayList< PointDto > list = new ArrayList<PointDto>();
            try {
                    String sql ="select * from pointlog where mno = ? "; // [1] SQL 작성한다.
                    PreparedStatement ps = conn.prepareStatement(sql); // [2] DB와 연동된 곳에 SQL 기재한다.
                    ps.setInt(  1 , loginMno); // [*] 기재된 SQL 에 매개변수 값 대입한다.
                    ResultSet rs = ps.executeQuery(); // [3] 기재된 SQL 실행하고 결과를 받는다.
                    while( rs.next() ) {
                            PointDto pointDto = new PointDto();
                            pointDto.setPono( rs.getInt("pono") );
                            pointDto.setPocomment( rs.getString("pocomment") );
                            pointDto.setPocount( rs.getInt("pocount") );
                            pointDto.setPodate( rs.getString("podate") );
                            pointDto.setMno( rs.getInt("mno") );
                            list.add(pointDto);
                    }
            }catch(SQLException e ) { System.out.println(e);}
            return list; // 조회된 회원정보가 없을때. null 반환한다
    } // f end 
 // [7] 현재 남은 포인트 조회
    public int getPoint( int loginMno ) {
            try {
                    String sql ="select sum(pocount) as mpoint  from pointlog where mno = ? "; // [1] SQL 작성한다.
                    PreparedStatement ps = conn.prepareStatement(sql); // [2] DB와 연동된 곳에 SQL 기재한다.
                    ps.setInt(  1 , loginMno); // [*] 기재된 SQL 에 매개변수 값 대입한다.
                    ResultSet rs = ps.executeQuery(); // [3] 기재된 SQL 실행하고 결과를 받는다.
                    if( rs.next() ) {
                            return rs.getInt( "mpoint" );
                    }
            }catch(SQLException e ) { System.out.println(e);}
            return -1; 
    }
    // [8] 현재 남은 포인트 조회
    public boolean setPoint( PointDto pointDto ) {
            try {
                    String sql ="insert into pointlog( pocomment, pocount, mno )values(?,?,?)"; // [1] SQL 작성한다.
                    PreparedStatement ps = conn.prepareStatement(sql); // [2] DB와 연동된 곳에 SQL 기재한다.
                    ps.setString(  1 , pointDto.getPocomment() );
                    ps.setInt(  2 , pointDto.getPocount() );
                    ps.setInt(  3 , pointDto.getMno() );
                    int count =  ps.executeUpdate(); // [3] 기재된 SQL 실행하고 결과를 받는다.
                    if( count == 1  ) return true;
            }catch(SQLException e ) { System.out.println(e);}
            return false;
    }
}
