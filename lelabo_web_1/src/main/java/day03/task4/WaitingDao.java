package day03.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // <-- 전체 조회 시 필요
import java.sql.SQLException;
import java.util.ArrayList; // <-- 전체 조회 결과를 담을 리스트

/**
 * WaitingDao (VisitDao) : (예시) 대기/방문 관련 DAO
 *  - 테이블명 : visit
 *  - 컬럼명 : num(PK), content, array
 *  - 현재 등록(write)과 삭제(delete)만 구현되어 있었음
 *  - 여기에 전체 조회(findAll), 개별 수정(update) 메서드를 추가합니다.
 */
public class WaitingDao {
    private Connection conn;
    
    // 싱글톤 패턴 적용
    private static WaitingDao instance = new WaitingDao();
    private WaitingDao() {
        try {
            // 1) JDBC 드라이버 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2) DB 연결
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb0116",
                "root",
                "1234"
            );
        } catch (Exception e) {
            System.out.println("DB 연결 실패 : " + e);
        }
    }
    public static WaitingDao getInstance() { 
        return instance; 
    }
    
    // -------------------------------------------------
    // 1. 방문록 등록 (CREATE)
    // -------------------------------------------------
    public boolean write(WaitingDto waitingDto) {
        try {
            // 테이블 컬럼이 (content, array)라고 가정
            // array 컬럼에 '나이' 정보를 저장
            String sql = "INSERT INTO waiting(content, array) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitingDto.getContent());
            ps.setInt(2, waitingDto.getAge());
            
            int count = ps.executeUpdate();
            if(count == 1) return true;
            
        } catch (SQLException e) {
            System.out.println("write() 에러 : " + e);
        }
        return false;
    }
    
    // -------------------------------------------------
    // 2. 방문록 전체 조회 (READ ALL) - 추가
    // -------------------------------------------------
    /**
     * findAll() : 테이블 'visit'에 존재하는 모든 레코드를 조회하여 ArrayList에 담아 반환
     *  - 컬럼 : num, content, array
     */
    public ArrayList<WaitingDto> findAll() {
        ArrayList<WaitingDto> list = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM visit ORDER BY num DESC"; 
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                // DB에서 컬럼값 꺼내서 DTO 객체 생성
                WaitingDto dto = new WaitingDto();
                dto.setNum(rs.getInt("num"));        // PK
                dto.setContent(rs.getString("content"));
                dto.setAge(rs.getInt("array"));      // 'array' 컬럼에 나이 저장
                
                // 리스트에 DTO 추가
                list.add(dto);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("findAll() 에러 : " + e);
        }
        return list;
    }
    
    // -------------------------------------------------
    // 3. 방문록 개별 수정 (UPDATE) - 추가
    // -------------------------------------------------
    /**
     * update() : num으로 특정 레코드를 찾아 content, array(나이) 수정
     */
    public boolean update(WaitingDto waitingDto) {
        try {
            String sql = "UPDATE visit SET content = ?, array = ? WHERE num = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, waitingDto.getContent());
            ps.setInt(2, waitingDto.getAge()); 
            ps.setInt(3, waitingDto.getNum());  // 조건 (PK)
            
            int count = ps.executeUpdate();
            if(count == 1) return true;
            
        } catch (SQLException e) {
            System.out.println("update() 에러 : " + e);
        }
        return false;
    }
    
    // -------------------------------------------------
    // 4. 방문록 개별 삭제 (DELETE)
    // -------------------------------------------------
    public boolean delete(int num) {
        try {
            String sql = "DELETE FROM visit WHERE num = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            
            int count = ps.executeUpdate();
            if(count == 1) return true;
            
        } catch (SQLException e) {
            System.out.println("delete() 에러 : " + e);
        }
        return false;
    }
    
} // class end

