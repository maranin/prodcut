package productInventory;

public class InvenVO {
	String prod_name;
	int prod_code;
	int prod_price;
	int prod_stored;
	int prod_released;
	String prod_inven;
	String prod_inven_loc;
	
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_code() {
		return prod_code;
	}
	public void setProd_code(int prod_code) {
		this.prod_code = prod_code;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getProd_stored() {
		return prod_stored;
	}
	public void setProd_stored(int prod_stored) {
		this.prod_stored = prod_stored;
	}
	public int getProd_released() {
		return prod_released;
	}
	public void setProd_released(int prod_released) {
		this.prod_released = prod_released;
	}
	public String getProd_inven() {
		return prod_inven;
	}
	public void setProd_inven(String prod_inven) {
		this.prod_inven = prod_inven;
	}
	public String getProd_inven_loc() {
		return prod_inven_loc;
	}
	public void setProd_inven_loc(String prod_inven_loc) {
		this.prod_inven_loc = prod_inven_loc;
	}
	@Override
	public String toString() {
		return "invenVo [prod_name=" + prod_name + ", prod_code=" + prod_code + ", prod_price=" + prod_price
				+ ", prod_stored=" + prod_stored + ", prod_released=" + prod_released + ", prod_inven=" + prod_inven
				+ ", prod_inven_loc=" + prod_inven_loc + "]";
	}
}
