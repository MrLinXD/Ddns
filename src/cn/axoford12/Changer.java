package cn.axoford12;

import exceptions.InvalidMethodNameException;

public class Changer {

	private Ip ip;

	public Changer() {
		this.ip = new Ip();
	}

	public String change() throws InvalidMethodNameException {
		String re = null;
		System.out.println("Your ip:"+this.ip.correctIp);
		System.out.println("Domain record ip:"+this.ip.IPDomain);
		System.out.println("Need Change?  =>" + this.ip.isChanged());
		System.out.println("-------------------------------------");
		if (this.ip.isChanged()) {
			re = HttpRequest.getReqter().send("POST", "https://dnsapi.cn/Record.Ddns",
					new Config().getParams() + "&value=" + ip.correctIp);
			System.out.println("Change ip.");

		} else {
			re = "Do not need to change.";
		}
		return re;
	}
}
