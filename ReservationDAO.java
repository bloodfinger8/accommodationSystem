package roomReservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO {
	private static ReservationDAO instance;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "system";
	private String password = "oracle";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ReservationDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//DB singleton
	public static ReservationDAO getInstance() {
		if(instance == null){
			synchronized (ReservationDAO.class) {
				instance = new ReservationDAO();
			}
		}
		return instance;
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public int insertreservation(ReservationDTO dto) {
		int su = 0;
		getConnection();
		String sql = "insert into reservation values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getStartday());
			pstmt.setString(3, dto.getEndday());
			pstmt.setString(4, dto.getRoomNum());
			pstmt.setString(5, dto.getAdult());
			pstmt.setString(6, dto.getChild());
			pstmt.setInt(7, dto.getComeway());
			pstmt.setInt(8, dto.getPay());
			pstmt.setInt(9, dto.getSalepay());
			pstmt.setInt(10, dto.getTotalpay());
			pstmt.setString(11, dto.getPayway());
			
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
	
	public int moneycheak(ReservationDTO dto) {
		int term = 0;
		getConnection();
		String sql = "select endday-startday as term from reservation where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				term = rs.getInt("term");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return term;
		
	}
	
	
		
	
	
}
