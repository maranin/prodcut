package humanResource;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
//		dao.getEmployeeList("");
//		dao.getEmployee(110);
//		List<EmployeeVO> l = dao.getEmployeeListVO("Alex");
	
//		for (EmployeeVO e : l) {
//			System.out.println(e);
//		}
//		EmployeeVO vo = new EmployeeVO();
//		vo.setEmployeeId(700);
//		vo.setFirstName("Ford");
//		vo.setLastName("Musastangs");
//		vo.setEmail("mmasasss1il.com");
//		vo.setJobId("AD_PRES");
//		dao.insertEmployee(vo);
//		System.out.println("=====================================");
//		dao.getEmployeeList("Ford");
		
//		EmployeeVO vo = new EmployeeVO();
//		vo.setEmployeeId(800);
//		vo.setLastName("Fool");
//		dao.updateEmployee(vo);
////		System.out.println("CHANGE");
		
		Scanner sc = new Scanner(System.in);
		int emp_id, dept_id;
		String last_name, email, hire_date, job_id;
		
		System.out.println("EMP_ID: ");
		emp_id = sc.nextInt();
		System.out.println("이름: ");
		last_name = sc.next();
		System.out.println("메일: ");
		email = sc.next();
		System.out.println("hire_date: ");
		hire_date = sc.next();
		System.out.println("JOB_ID: ");
		job_id = sc.next();
		System.out.println("DEPT_ID: ");
		dept_id = sc.nextInt();
		
		dao.createEmp(emp_id, last_name, email, hire_date, job_id, dept_id);
		System.out.println("입력확인");
		dao.getEmployee(emp_id);
		
		
		
		
		
		

		
	
	}
}
		
	

	
