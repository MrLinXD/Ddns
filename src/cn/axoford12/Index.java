package cn.axoford12;


public class Index {

	public static void main(String[] args) {

		HttpRequest requester = new HttpRequest();
		Config config = new Config();
		String param = config.getParams();
		System.out.println(param);
		System.out.println(requester.send("POST", "https://dnsapi.cn/Domain.List", param));
	}
}
