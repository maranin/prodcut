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
			cs = conn.prepareCall("{call INSERT_PROD(?,?,?,?)}");

			System.out.println("상품정보입력");

			cs.setInt(1, vo.getProd_code());
			cs.setString(2, vo.getProd_name());
			cs.setInt(3, vo.getProd_price());
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);
			cs.execute();
			if (cs.getString(4).equals("Success"))
				System.out.println("Successfully Loaded Procesure");
			else
				System.out.println("Already exist");
			cs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectProd(int prod_code) {
		conn = DBConnection.getConnection();
		String sql;
		if (prod_code == 0)
			sql = "select * from prod_info";
		else
			sql = "select * from prod_info where prod_code = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			if (prod_code != 0)
				pstmt.setInt(1, prod_code);
			rs = pstmt.executeQuery();
			InvenVO vo = null;
			System.out.println("--------------------------------------");

			if (rs.next()) {
				do {

					vo = new InvenVO();
					vo.setProd_code(rs.getInt("prod_code"));
					vo.setProd_name(rs.getString("prod_name"));
					vo.setProd_price(rs.getInt("prod_price"));

					System.out.println(vo.toString());
				} while (rs.next());
			}
			System.out.println("--------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateSr(InvenVO vo) {
		conn = DBConnection.getConnection();
		CallableStatement cs;

		try {
			cs = conn.prepareCall("{call UPDATE_PROD(?,?,?,?,?)}");

			cs.setInt(1, vo.getProd_code());
			cs.setString(2, vo.getInven_name());
			cs.setInt(3, vo.getProd_in());
			cs.setInt(4, vo.getProd_out());
			cs.registerOutParameter(5, java.sql.Types.VARCHAR);

			cs.execute();
			System.out.println("재고가 변경이 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void phead() {
		conn = DBConnection.getConnection();
		CallableStatement cs;

		try {
			cs = conn.prepareCall("{ ? = call create_puchase_no()}");

			int r = cs.executeUpdate();
			System.out.println(r + "재고가 변경이 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectInven(int prod_code) {
		conn = DBConnection.getConnection();
		InvenVO vo = null;
		vo = new InvenVO();
		String sql;
		if (prod_code == 0)
			sql = "select * from prod_inven";
		else
			sql = "select * from prod_inven where prod_code = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			if (prod_code != 0)
				pstmt.setInt(1, prod_code);
			rs = pstmt.executeQuery();

			System.out.println("--------------------------------------");

			if (rs.next()) {
				do {

					vo.getProd_code();
					vo.getInven_name();
					vo.getProd_sum();

					System.out.println(vo.toString());
				} while (rs.next());
			}
			System.out.println("--------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
