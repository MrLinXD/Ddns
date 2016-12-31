package cn.axoford12;

import exceptions.InvalidMethodNameException;

public class Changer {

	private Ip ip;

	public Changer() {
		this.ip = new Ip();
	}

	public String change() throws InvalidMethodNameException {
		String re = null;
		if (this.ip.isChanged()) {
			re = HttpRequest.getReqter().send("POST", "https://dnsapi.cn/Record.Ddns",
					new Config().getParams() + "&value=" + ip.correctIp);

		} else {
			re = "Do not need to change.";
		}
		System.out.println(ip.correctIp);
		System.out.println(ip.IPDomain);
		return re;
	}
}
