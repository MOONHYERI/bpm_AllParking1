package kr.allparking.bpm_AllParking.entity;

import com.fasterxml.jackson.core.*;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


public class KakaoAPI<object> {

    public HashMap<String, Object> getUserInfo(String accessToken) {
        HashMap<String, object> userInfo = new HashMap<String, object>();
        String reqUrl = "https://kapi.kakao.com/v2/user/me";
                try{
                    URL url = new URL(reqUrl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Authorization", "Bearer " + accessToken);
                    int responseCode = conn.getResponseCode();
                    System.out.println("responseCode" + responseCode);

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    String line = "";
                    String result = "";

                    while((line = br.readLine()) !=null){
                        result += line;
                    }
                    System.out.println("response body : " + result);

                    JsonParser parser = new JsonParser()
                    JsonElement element = parser.parse(result);

                    JSONObject properties = element.getAsJsonObject()
                }catch (Exception e){

                }
        return null;
    }
    public String getAccessToken(String code){
        return null;
    }


}
