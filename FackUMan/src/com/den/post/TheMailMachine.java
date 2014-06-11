package com.den.post;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

public class TheMailMachine {

	public static void main(String[] args) throws Exception {
		//http://ultimatelovecalc.com/calc.php?fname=XXX&uid=1362756&cname1=YYY&cname2=a&cname3=b
		URL url = new URL("http://127.0.0.1");
		URLConnection conn=url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write("DOne");
		wr.flush();
		wr.close();
	}
	
	public void sendReq(String url,String email,String fname) throws IOException{
	    HttpClient httpClient = new HttpClient();
	    PostMethod postMethod = new PostMethod(url);
	    
	    postMethod.addParameter("Email", email);
	    postMethod.addParameter("fname", fname);
	    try {
	        httpClient.executeMethod(postMethod);
	    } catch (HttpException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
	        String resp = postMethod.getResponseBodyAsString();
	    } else {
	         //...postMethod.getStatusLine();
	    }
	}
}
