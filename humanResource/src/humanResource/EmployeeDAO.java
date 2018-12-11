package humanResource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public void createEmp(int emp_id, String last_name, String email, String hire_date, String job_id, int dept_id) {
		conn = DBConnection.getConnection();
		CallableStatement cs;
		
		try {
			cs = conn.prepareCall("{call CREATE_EMP(?,?,?,?,?,?)}");
			
			System.out.println("부서번호");
			cs.setInt(1, emp_id);
			cs.setString(2, last_name);
			cs.setString(3, email);
			cs.setString(4, hire_date);
			cs.setString(5, job_id);
			cs.setInt(6, dept_id);
			
			cs.execute();
			System.out.println("Successfully Loaded Procesure");
			cs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getEmployeeList(String searchCondition) { // 전체 HR계정 조회
//		DBConnection dbconn = new DBConnection();
		conn = DBConnection.getConnection();

		String sql = "select * from employees where first_name = ?||'%' ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchCondition);
			rs = pstmt.executeQuery();
			EmployeeVO emp = null;
			System.out.println("--------------------------------------");

			if (rs.next()) {
				do {

					emp = new EmployeeVO();
					emp.setEmployeeId(rs.getInt("employee_id"));
					emp.setLastName(rs.getString("last_name"));
					emp.setFirstName(rs.getString("first_name"));
					emp.setPhoneNumber(rs.getString("phone_number"));
					emp.setHireDate(rs.getString("hire_date"));
					emp.setJobId(rs.getString("job_id"));
					emp.setSalary(rs.getInt("salary"));
					emp.setCommissionPct(rs.getDouble("commission_pct"));
					emp.setManagerId(rs.getInt("manager_id"));
					emp.setDepartmentId(rs.getInt("department_id"));

					System.out.println(emp.toString());
				} while (rs.next());
			}
			System.out.println("--------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public EmployeeVO getEmployee(int emp_id) { // 전체 HR계정 조회
		conn = DBConnection.getConnection();
		EmployeeVO emp = null;
		String sql = "select * from employees where employee_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				emp = new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setLastName(rs.getString("last_name"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));

//				System.out.println(emp.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	public List<EmployeeVO> getEmployeeListVO(String searchCondition) { // 전체 HR계정 조회

		List<EmployeeVO> ls = new ArrayList<>();

		String sql = "select * from employees where first_name like ?||'%' ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchCondition);
			rs = pstmt.executeQuery();
			EmployeeVO emp = null;

			if (rs.next()) {
				do {

					emp = new EmployeeVO();
					emp.setEmployeeId(rs.getInt("employee_id"));
					emp.setLastName(rs.getString("last_name"));
					emp.setFirstName(rs.getString("first_name"));
					emp.setPhoneNumber(rs.getString("phone_number"));
					emp.setHireDate(rs.getString("hire_date"));
					emp.setJobId(rs.getString("job_id"));
					emp.setSalary(rs.getInt("salary"));
					emp.setCommissionPct(rs.getDouble("commission_pct"));
					emp.setManagerId(rs.getInt("manager_id"));
					emp.setDepartmentId(rs.getInt("department_id"));
					ls.add(emp);
				} while (rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;

	}

	public void insertEmployee(EmployeeVO vo) {
		conn = DBConnection.getConnection();
		String sql = "insert into employees(employee_id, first_name, last_name, email, hire_date, job_id)"
				+ "values(?, ?, ?, ?, sysdate, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEmployeeId());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getLastName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getJobId());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateEmployee(EmployeeVO vo) {
		conn = DBConnection.getConnection();
		String sql = "update employees set last_name = ? where employee_id=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getLastName());
			pstmt.setInt(2, vo.getEmployeeId());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
