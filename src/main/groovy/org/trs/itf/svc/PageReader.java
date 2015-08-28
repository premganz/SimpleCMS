package org.trs.itf.svc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class PageReader {
boolean testMode=false;
	public String readUpPage(String scenario, String pageName){
		File f = null;
		StringBuffer buf = new StringBuffer();
		URL resourceUrl = getClass().getResource("/"+scenario+"/"+pageName+".txt");
		String resourcePath ="";
		if(testMode){
			return "hello test"; 
		}
		
			try {
				if(resourceUrl!=null && resourceUrl.toURI()!=null){
				resourcePath = resourceUrl.toURI().getPath();
				}else{
					return "URL not found";
				}
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
			f= new File(resourcePath);
			FileReader reader;
			try {
				reader = new FileReader(f);
				BufferedReader readerBuf = new BufferedReader(reader);
				try {
					String line = readerBuf.readLine();
					while(line!=null){
						buf.append(line);
						buf.append("</br>");
						line = readerBuf.readLine();
					}
					
				} catch (Exception  e) {
					e.printStackTrace();
					buf.append("ERROR");
				}finally{
					try {
						readerBuf.close();
					} catch (IOException e) {
						e.printStackTrace();
						buf.append("ERROR");
					}
				}
			} catch (FileNotFoundException e1) {
				buf.append("FILE not found");
				e1.printStackTrace();
			}
		
			
		if(buf.toString().isEmpty()){
			buf.append("BLANK");
			buf.append("***EOL***");
		}
				return buf.toString();
		
	}
	
	public List<String> readUpPageList(String scenario, String pageName){
		File f = null;
		ArrayList<String> resultList = new ArrayList<String>();
		URL resourceUrl = getClass().getResource("/"+scenario+"/"+pageName+".txt");
		String resourcePath;
		try {
			resourcePath = resourceUrl.toURI().getPath();
			f= new File(resourcePath);
			FileReader reader = new FileReader(f);
			BufferedReader readerBuf = new BufferedReader(reader);
			String line = readerBuf.readLine();
			while(line!=null){
				resultList.add(line);
				line = readerBuf.readLine();
			}
			
		} catch (Exception  e) {
			e.printStackTrace();
		}
		return resultList;
	}
}