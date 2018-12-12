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
		PreparedStatement cs;

		try {
			cs = conn.prepareStatement("insert into prod_info values (?,?,?)");

			System.out.println("입력확인");

			cs.setInt(1, vo.getProd_code());
			cs.setString(2, vo.getProd_name());
			cs.setInt(3, vo.getProd_price());
			cs.executeQuery();
//			cs.close();
//			conn.close();
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
					System.out.println(vo.getProd_code() + "\t" + vo.getProd_name() + "\t" + vo.getProd_price());
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
			cs = conn.prepareCall("{call UPDATE_PROD(?,?,?,?)}");

			cs.setInt(1, vo.getProd_code());
			cs.setString(2, vo.getInven_name());
			System.out.println(vo.getInven_name());
			cs.setInt(3, vo.getProd_in());
			cs.setInt(4, vo.getProd_out());
			cs.execute();
			System.out.println("재고가 변경이 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void phead(InvenVO vo) {
		conn = DBConnection.getConnection();
		CallableStatement cs;

		try {
			cs = conn.prepareCall("{ ? = call create_purchase_no()}");
			
			cs.registerOutParameter(1, java.sql.Types.VARCHAR); 
			cs.execute();
//			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			System.out.println(cs.getString(1));
			
//			System.out.println(r + "구매번호 생성되었습니다.");
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

					System.out.print(rs.getInt("prod_code")+ "\t");
					System.out.print(rs.getString("inven_name")+ "\t");
					System.out.println(rs.getInt("prod_sum"));

				} while (rs.next());
			}
			System.out.println("--------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void purchaseHead (InvenVO vo) {
		conn = DBConnection.getConnection();
		CallableStatement cs;
		String sql = ("insert into head_info values (?,sysdate,?)");
		try {
			cs = conn.prepareCall("{ ? = call create_purchase_no()}");
			cs.registerOutParameter(1, java.sql.Types.VARCHAR); 
			cs.execute();
			System.out.println(cs.getString(1));
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cs.getString(1));
			pstmt.setString(2, vo.getBuyer());
			pstmt.executeUpdate();
			
			vo.setPid(cs.getString(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void purchaseLine(InvenVO vo) {
		conn = DBConnection.getConnection();
		CallableStatement cs;
		String sql = ("insert into headline values (?,?,?,?)");
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPid());
			pstmt.setString(2, vo.getProd_name());
			pstmt.setInt(3, vo.getProd_code());
			pstmt.setInt(4, vo.getQty());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
