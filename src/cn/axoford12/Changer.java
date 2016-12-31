package cn.axoford12;

public class Changer {

	private Ip ip;
	public Changer(){
		this.ip = new Ip();
	}
	public String change(){
		String re = null;
		if(this.ip.isChanged()){
			HttpRequest reqter = new HttpRequest();
			re = reqter.send("POST", "https://dnsapi.cn/Record.Ddns", new Config().getParams()
					+"&value="+ip.correctIp);
		}else{
			re = "Do not need to change.";
		}
		System.out.println(ip.correctIp);
		System.out.println(ip.IPDomain);
		return re;
	}
}
