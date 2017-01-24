package com.test.daum_openapi_exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DaumOpenAPIExam {
	public static void main(String[] args) {
		String keyword = "라이언";
		try{
			keyword = URLEncoder.encode(keyword, "utf-8");
		}catch(UnsupportedEncodingException e1){
			e1.printStackTrace();
		}
		String urlString = "https://apis.daum.net/shopping/search?apikey=b0ed174b39eb14f58426cceebcd2aa42&q="+keyword+"&result=20&pageno=1&output=json&sort=min_price";
		StringBuffer sb =  new StringBuffer();
		try{
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);          // 입력스트림 사용
			conn.setDoOutput(true);         // 출력스트림 사용
			conn.setRequestMethod("GET");   // GET or POST ...
			  InputStreamReader ir =//input stream reader
					  new InputStreamReader(conn.getInputStream());
			  BufferedReader br = new BufferedReader(ir); //보조 input stream
			  String line;
			  while((line = br.readLine()) != null)	sb.append(line);	//읽어올것이 있으면 읽어온다
			  br.close(); ir.close(); conn.disconnect();
			  System.out.println(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		/////////////////////////////////이제부터 
		try{
			//JSON 문자열을 JSON 객체로 역직렬화
			JSONParser jsonParser = new JSONParser();
			JSONObject json = (JSONObject)jsonParser.parse(sb.toString()); 	//JSON 문자열을 객체로 바꿈
			JSONObject channel = (JSONObject)json.get("channel");
			System.out.println(channel.get("result"));
			JSONArray items = (JSONArray)channel.get("item");
			System.out.println(items.size());
			for( int i = 0; i < items.size(); i++){
				JSONObject obj = (JSONObject)items.get(i);
				System.out.println(i+":"+obj.get("title")+", "+
									obj.get("price_min")+", "+
									obj.get("price_max"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
