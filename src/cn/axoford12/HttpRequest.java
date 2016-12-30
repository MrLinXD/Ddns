package cn.axoford12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author Axoford12
 */
public class HttpRequest {

	public String send(String method,String url,String param){
		String result;
		if(method == "GET"){
			result = this.sendGet(url, param);
		}else if(method == "POST"){
			result = this.sendPost(url, param);
		}else{
			result = "Error";
		}
		return result;
	}
	/**
	 * @param url
	 *            The URL You want to sent
	 * @param param
	 * 
	 */
	private String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// Open A connection with URL
			URLConnection connection = realUrl.openConnection();
			// Set advance attribute
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// Set up a connect
			connection.connect();
			// Get ALL header Fields using Map
			Map<String, List<String>> map = connection.getHeaderFields();
			// For .. All Fields.
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// Defend BufferdReader Stream to read the response of url
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("There is (an) exception of sending URL.");
			System.out.println("Print Exception: ");
			System.out.println(e);
			e.printStackTrace();
		}
		// Finally close Stream
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	private String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// Open a URL
			URLConnection conn = realUrl.openConnection();
			// Set the advance attribute URL
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// Must us set this :
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// Get Output stream
			out = new PrintWriter(conn.getOutputStream());
			// Send PARMS given in
			out.print(param);
			// flush Buffer of output Stream
			out.flush();
			// Defend BufferedReader to read InputStream get result
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			// Use While get results
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("Exception(s):" + e);
			e.printStackTrace();
		}
		// Use finally close streams.
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
