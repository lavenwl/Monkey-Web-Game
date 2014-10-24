package buyapi;

public class BuyBean{
	String openid;
	String payitem;
	String billno;
	String zoneid;
	String amt;
	String payamt_coins;
	String token;
	int serverid;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPayitem() {
		return payitem;
	}
	public void setPayitem(String payitem) {
		this.payitem = payitem;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getPayamt_coins() {
		return payamt_coins;
	}
	public void setPayamt_coins(String payamt_coins) {
		this.payamt_coins = payamt_coins;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getServerid() {
		return serverid;
	}
	public void setServerid(int serverid) {
		this.serverid = serverid;
	}
}
