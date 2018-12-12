package productInventory;

public class InvenVO {
	int prod_code, prod_price, prod_in, prod_out, prod_sum, qty;
	String prod_name, inven_name, pid, buyer, pdate;
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
	public int getProd_in() {
		return prod_in;
	}
	public void setProd_in(int prod_in) {
		this.prod_in = prod_in;
	}
	public int getProd_out() {
		return prod_out;
	}
	public void setProd_out(int prod_out) {
		this.prod_out = prod_out;
	}
	public int getProd_sum() {
		return prod_sum;
	}
	public void setProd_sum(int prod_sum) {
		this.prod_sum = prod_sum;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getInven_name() {
		return inven_name;
	}
	public void setInven_name(String inven_name) {
		this.inven_name = inven_name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
//	@Override
//	public String toString() {
//		return "InvenVO [prod_code=" + prod_code + ", prod_price=" + prod_price + ", prod_in=" + prod_in + ", prod_out="
//				+ prod_out + ", prod_sum=" + prod_sum + ", qty=" + qty + ", prod_name=" + prod_name + ", inven_name="
//				+ inven_name + ", pid=" + pid + ", buyer=" + buyer + ", pdate=" + pdate + "]";
//	}

}
