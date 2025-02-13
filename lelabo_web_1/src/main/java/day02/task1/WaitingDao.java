package day02.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaitingDao {
	private Connection conn;
	//+ 싱글톤을 만들어요
	private static WaitingDao instance = new WaitingDao();
	private WaitingDao() {
	
		// + DB 연동해요
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Waiting0116",
					"root" , "1234");
			
		} catch (Exception e) { System.out.println(e);}
	}
	
	public static WaitingDao getInstance() {return instance;}
	
	// 1. 등록 SQL
	public boolean write( String phone , int count ) {
		try {
			String sql = "insert into waiting(phone,count)values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString( 1 , phone );
			ps.setInt( 2 , count );
			int array = ps.executeUpdate();
			if( array == 1 ) return true;
		}catch( SQLException e ) { System.out.println(e);}
		
		return false;
	} // f end 
	
	// 4. 삭제 SQL 
		public boolean delete( int num ) {
			try {
				String sql = "delete from waiting where num =? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt( 1 , num );
				int array = ps.executeUpdate();
				if( array == 1 ) return true;
			}catch( SQLException e ) { System.out.println(e); }
			
			return false;
		} // f end 
	
	}

