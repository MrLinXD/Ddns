package cn.axoford12;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	public static Config c = new Config();
	// defined login_token.
	protected String login_token;
	// defined domain.
	protected String domain;
	// Construction
	protected String record_id;
	protected String sub_domain;
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
			// Open InputStream named "a"
			InputStream a= new BufferedInputStream(new FileInputStream(f));
			p.load(a);
			// load login_token and domain with file.
			this.login_token = p.getProperty("login_token");
			this.domain = p.getProperty("domain");
			this.record_id = p.getProperty("record_id");
			this.sub_domain = p.getProperty("sub_domain");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected String getParams(){
		return "login_token="+this.login_token
				+"&domain="+this.domain
				+"&sub_domain="+this.sub_domain
				+"&record_line_id=0"
				+"&record_id="+this.record_id;
	}

}
