package cn.axoford12;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private String login_token;
	// Construction
	public Config(){
		File f= new File("./config.so");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
	
		try {
			InputStream a= new BufferedInputStream(new FileInputStream(f));
			p.load(a);
			this.login_token = p.getProperty("login_token");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected String getParams(){
		return "login_token="+this.login_token+"&"+"format=json";
	}

}
