package com.jvm02;

import com.alibaba.fastjson.JSON;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpclientUtil {

    public static void main(String[] args) throws Exception {
        //String result = get("http://www.baidu.com");
        //System.out.println(result);
        String result1 = postMap("http://www.baidu.com", null);
        System.out.println(result1);
    }

    private static final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(2000)
            .setSocketTimeout(10000).build();

    private static final String CHARSET = "UTF-8";

    /**
     * get
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String get(String url) throws Exception {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http GET请求

        CloseableHttpResponse response = null;
        String result = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            // 执行请求
            response = httpclient.execute(httpGet);

            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), CHARSET);
                System.out.println("result:" + result);
            }
            return result;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * post form表单请求
     *
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public static String postMap(String url, Map<String, String> map) throws Exception {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        CloseableHttpResponse response = null;
        String result = null;
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, CHARSET);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(entity);
            response = httpclient.execute(httpPost);

            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), CHARSET);
                System.out.println("result:" + result);
            }
            return result;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * post json请求
     *
     * @param url
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public static String postJson(String url, Object jsonObject) throws Exception {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String json = JSON.toJSONString(jsonObject);

        CloseableHttpResponse response = null;
        String result = null;
        try {
            StringEntity entity = new StringEntity(json, CHARSET);
            entity.setContentType("text/json");

            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.setConfig(requestConfig);
            response = httpclient.execute(httpPost);

            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), CHARSET);
                System.out.println("result:" + result);
            }
            return result;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
