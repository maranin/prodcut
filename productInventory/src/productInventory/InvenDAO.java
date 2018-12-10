package productInventory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvenDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public void insertProd(InvenVO vo) {
		conn = DBConnection.getConnection();
		CallableStatement cs;
		
		try {
			cs = conn.prepareCall("{call INSERT_PROD(?,?,?,?,?)}");
			
			System.out.println("재고입력");
			cs.setString(1, vo.getProd_inven());
			cs.setString(2, vo.getProd_inven_loc());
			cs.setInt(3, vo.getProd_code());
			cs.setInt(4, vo.getProd_stored());
			cs.setString(5, vo.getProd_name());
			
			
			cs.execute();
			System.out.println("Successfully Loaded Procesure");
			cs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectProd() {
		conn = DBConnection.getConnection();
		String sql = "select * from prod_info";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			InvenVO emp = null;
			System.out.println("--------------------------------------");

			if (rs.next()) {
				do {

					emp = new InvenVO();
					emp.setProd_name(rs.getString("prod_name"));
					emp.setProd_code(rs.getInt("prod_code"));
					emp.setProd_price(rs.getInt("prod_price"));

					System.out.println(emp.toString());
				} while (rs.next());
			}
			System.out.println("--------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateProd(InvenVO vo) {
		conn = DBConnection.getConnection();
		String sql = "update prod_inven_info set prod_code = ? where prod_inven=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getProd_code());
			pstmt.setString(2, vo.getProd_inven());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
