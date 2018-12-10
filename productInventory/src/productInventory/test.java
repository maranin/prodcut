package productInventory;

import java.sql.SQLException;
import java.util.Scanner;

public class test {
	InvenDAO dao;
	private InvenVO vo;
	Scanner sc = new Scanner(System.in);

	public void menuList() throws SQLException, ClassNotFoundException {
		int selNum;
		boolean t = true;
		do {
			System.out.println("1. 상품    입력");
			System.out.println("2. 상품    수정");
			System.out.println("3. 상품    조회");
			System.out.println("4. 입출고 처리");
			System.out.println("5. 입출고 조회");
			System.out.println("6. 재고    조회");
			System.out.println("7. 종          료");

			System.out.println("==============");
			System.out.println("메뉴를 선택하세요 ? ");
			selNum = sc.nextInt();

			switch (selNum) {
			case 1:
				vo = new InvenVO();
				dao = new InvenDAO();

				System.out.println("상품 코드를 입력하세요.");
				vo.setProd_code(sc.nextInt());
				System.out.println("상품 이름을 입력하세요.");
				vo.setProd_name(sc.next());
				System.out.println("상품 가격을 입력하세요.");
				vo.setProd_price(sc.nextInt());

				dao.insertProd(vo);
				break;
//		         case 2:
//		            dao = new invenDAO();
//		            
//		            String col, code, str;
//		            System.out.println("수정할 상품의 컬럼값을 입력하세요.(product_name, price)");
//		            col = sc.next();
//		            System.out.println("수정할 컬럼값을 입력하세요.");
//		            str = sc.next();
//		            System.out.println("수정할 상품의 코드를 입력하세요.");
//		            code = sc.next();
//		            dao.updateProduct(col, str, code);
//		            
//		            System.out.println("===================");
//		            break;
//		         case 3:
//		            dao = new invenDAO();
//		            dao.listProduct();
//		            break;
//		         case 4:
//		            dao = new invenDAO();
//		            dao.createProd();
//		            break;
//		         case 5:
//		            //입출고 정보 조회
//		            break;
//		         case 6:
//		            //재고 조회
//		            break;
			case 7:
				System.out.println("이용해주셔서 감사합니다.");
				t = false;
			default:
				break;
			}
		} while (t);
		// sc.close();
	}

}
