package cn.axoford12;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ip {
	private String IPDomain;
	private String correctIp;
	
	// Construction.
	public Ip(){
		this.IPDomain = this.getDomainIP("ddns.axoford12.cn");
		this.correctIp = this.getMyIP();
	}
	private String getDomainIP(String domainName) {
		InetAddress address = null;
		try {
			address = InetAddress.getByName(domainName);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Get IP Failed Please try to check your network connection.");
		}
		return address.getHostAddress().toString();
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
