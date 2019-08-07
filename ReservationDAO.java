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
	private String user = "kujun";
	private String password = "dkdlxl";
	
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
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getStartday());
			pstmt.setString(3, dto.getEndday());
			pstmt.setString(4, dto.getName());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getRoomNum());
			pstmt.setString(7, dto.getAdult());
			pstmt.setString(8, dto.getChild());
			pstmt.setInt(9, dto.getComeway());
			pstmt.setInt(10, dto.getPay());
			pstmt.setInt(11, dto.getSalepay());
			pstmt.setInt(12, dto.getTotalpay());
			pstmt.setString(13, dto.getPayway());
			
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
		
	
	
}
