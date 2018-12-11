package productInventory;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	InvenDAO dao = new InvenDAO();
	InvenVO vo = new InvenVO();
	Scanner sc = new Scanner(System.in);

	public void menuList() throws SQLException, ClassNotFoundException {
		int selNum;
		boolean t = true;
		do {
			System.out.println("1. 상품   입력");
			System.out.println("2. 상품   조회");
			System.out.println("3. 입출고처리");
			System.out.println("4. 재고   조회");
			System.out.println("5. 판매   정보");
			System.out.println("6. 종         료");

			System.out.println("============");
			System.out.println("메    뉴    선    택");
			selNum = sc.nextInt();

			switch (selNum) {
			case 1:

				int pcode, pprice;
				String pname;

				System.out.println("상품코드: ");
				vo.setProd_code(pcode = sc.nextInt());
				System.out.println("상품이름: ");
				vo.setProd_name(pname = sc.next());
				System.out.println("상품가격: ");
				vo.setProd_price(pprice = sc.nextInt());

				dao.insertProd(vo);
				System.out.println("입력 확인");
				break;
			case 2:
				System.out.println("상품CODE를 입력하세요.");

				vo.setProd_code(sc.nextInt());
				dao.selectProd(vo.getProd_code());

				break;
			case 3:
				
				System.out.println("상품 코드를 입력하세요.");
				vo.setProd_code(sc.nextInt());
				System.out.println("상품 이름을 입력하세요.");
				vo.setProd_name(sc.next());
				System.out.println("상품 수량을 입력하세요.");
				vo.setProd_in(sc.nextInt());
				dao.updateSr(vo);
				break;
			case 4:
				System.out.println("상품 코드를 입력하세요.");
				vo.setProd_code(sc.nextInt());
				dao.selectInven(vo.getProd_code());
				break;
			case 5:
				dao.phead();
				break;
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
