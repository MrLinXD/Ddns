package cn.axoford12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ip {
	protected String IPDomain;
	protected String correctIp;
	
	// Construction.
	public Ip(){
		this.IPDomain = this.getDomainIP("ddns.axoford12.cn");
		this.correctIp = this.getMyIP();
	}
	private String getDomainIP(String domainName) {
		HttpRequest reqter = new HttpRequest();
		String re = reqter.send("POST", "https://dnsapi.cn/Record.Info",
				"login_token="+Config.c.login_token
				+"&record_id="+Config.c.record_id
				+"&domain="+Config.c.domain);
        Pattern p = Pattern.compile("value>(.+?)</value");
        
        Matcher m = p.matcher(re);
        m.find();
        return m.group(1);
	}
	private String getMyIP() {  
        HttpRequest requester = new HttpRequest();
        String re = requester.send("POST", "http://1212.ip138.com/ic.asp", "");
        Pattern p = Pattern.compile("\\[(.+?)\\]");
        
        Matcher m = p.matcher(re);
        m.find();
        return m.group(1);
    }  
	public Boolean isChanged(){
		Boolean result =  false;
		if(!(this.correctIp.equals(this.IPDomain))){
			result = true;
		}
		return result;
	}
}
