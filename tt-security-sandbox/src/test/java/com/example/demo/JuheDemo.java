package com.example.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;


public class JuheDemo {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    public static String mobileQuery(String num) {
        String result = null;
        String url = "http://mobsec-dianhua.baidu.com/dianhua_api/open/location";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("tel", num);//需要查询的手机号码

        try {
            result = net(url, params, "GET");
            JSONObject jsonObject = JSON.parseObject(result);

            String number = getNumber(jsonObject);
            String city = getCity(jsonObject);

            return number + "." + city;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getCity(JSONObject jsonObject) {
        return jsonObject.getJSONObject("response").getJSONObject(getNumber(jsonObject)).
                getJSONObject("detail").getJSONArray("area").getJSONObject(0).getString("city");
    }


    private static String getNumber(JSONObject jsonObject) {
        return jsonObject.getJSONObject("response").keySet().iterator().next();
    }


    public static void main(String[] args) throws IOException {
        List<String> strings = FileUtils.readLines(new File("C:/Users/86132/Desktop/allResult.txt"), "utf-8");
        Map<String, List<String>> collect = strings.stream().collect(Collectors.groupingBy(t -> t.split("\\.")[1]));
//        List<String> collect = strings.stream().map(s -> mobileQuery(s)).collect(Collectors.toList());


        System.out.println(1);
//        FileUtils.writeLines(new File("C:/Users/86132/Desktop/allResult.txt"),collect);


    }


    /**
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return 网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params, String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if (method == null || method.equals("GET")) {
                strUrl = strUrl + "?" + urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (method == null || method.equals("GET")) {
                conn.setRequestMethod("GET");
            } else {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("UserDo-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params != null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String, String> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
