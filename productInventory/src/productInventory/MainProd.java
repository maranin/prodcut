package productInventory;

import java.util.Scanner;

public class MainProd {
	
	public static void main(String[] args) {
		
		InvenDAO dao = new InvenDAO();
		
		InvenVO vo = new InvenVO();
		
		Scanner sc = new Scanner(System.in);
	    int pcode, pprice, pstored, preleased;
		String pname, pinven, pinven_loc;
		
				
		
		System.out.println("창고명: ");
		vo.setProd_inven(pinven = sc.next());
		System.out.println("창고위치: ");
		vo.setProd_inven_loc(pinven_loc = sc.next());
		System.out.println("상품코드: ");
				vo.setProd_code(pcode = sc.nextInt());
		
		System.out.println("상품명: ");
		vo.setProd_name(pname = sc.next());
		
		System.out.println("재고: ");
		vo.setProd_stored(pstored = sc.nextInt());
		
		
		
		
		dao.insertProd(vo);
		System.out.println("입력 확인");
			
		}
}
