package tukorea.web.club.persistence;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tukorea.web.club.domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

public class StudentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	
	private void disconnect() {
    	if(pstmt != null) {
    		try {
    			pstmt.close();
    		} catch(SQLException e) {
    			e.printStackTrace();
    			}
    		}
    		if(conn != null) {
    		try {
    			conn.close();
    		} catch(SQLException e) {
    			e.printStackTrace();
    			}
    		}

		
	}
	private void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, 
			"jspbook","passwd");
			} catch(Exception e) {
				e.printStackTrace();
			}

		
	}
	public boolean add( StudentVO vo ) {
		connect();
		String sql = "insert into student values (?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getUsername());
			pstmt.setString(4, vo.getSnum());
			pstmt.setString(5, vo.getDepart());
			pstmt.setString(6, vo.getMobile());
			pstmt.setString(7, vo.getEmail());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
		
	}
	
	public boolean update(StudentVO studentVO) {
		connect();
		String sql = "update student set values (?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentVO.getId());
			pstmt.setString(2, studentVO.getPasswd());
			pstmt.setString(3, studentVO.getUsername());
			pstmt.setString(4, studentVO.getSnum());
			pstmt.setString(5, studentVO.getDepart());
			pstmt.setString(6, studentVO.getMobile());
			pstmt.setString(7, studentVO.getEmail());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean delete(StudentVO studentVO) {
		connect();
		String sql = "delete form student where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public ArrayList<StudentVO> getStudentList() {
		connect();
		ArrayList<StudentVO> studentlist = new ArrayList<StudentVO>();
		String sql = "select * from student ";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setUsername(rs.getString("username"));
				vo.setSnum(rs.getString("snum"));
				vo.setDepart(rs.getString("depart"));
				vo.setMobile(rs.getString("mobile"));
				vo.setEmail(rs.getString("email"));
				studentlist.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return studentlist;
		
	}
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void delete(String strId) {
		// TODO Auto-generated method stub
		
	}

	public StudentVO read(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
