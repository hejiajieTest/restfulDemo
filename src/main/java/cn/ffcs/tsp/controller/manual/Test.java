package cn.ffcs.tsp.controller.manual;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import cn.ffcs.tsp.service.manual.IManualService;

public abstract class Test<Entity> {
	
	public Test(){
		System.out.println("test");
		test2();
	}
	
	public abstract IManualService test2();
	
	
	public static String readFile(){
		FileInputStream fileInputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		String returnStr ="" ;
		try {
			fileInputStream = new FileInputStream("C://Users//Lenovo//Desktop//新建文本文档 (3).txt");
			inputStreamReader = new InputStreamReader(fileInputStream);
			reader = new BufferedReader(inputStreamReader) ;
			for(String tempString = null ;(tempString =reader.readLine()) != null;){
				returnStr = returnStr+"\n"+tempString ;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				//流为空判断差
				fileInputStream.close();
				inputStreamReader.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return returnStr;
	}
	
	public static void main(String[] args) throws ParseException {
		 String s = readFile();
		 System.out.println(s);
		 
		 new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-07-03 15:13:13");
	}
}
