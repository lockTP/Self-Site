package com.chenguanx.util;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;  
import java.util.HashMap;
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;  

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.NameValuePair;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.util.EntityUtils;  
/* 
 * 利用HttpClient进行post请求的工具类 
 */  
public class HttpClientUtil {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		String url = "https://www.github.com";
		String result = doGet(url, map, "utf-8");
		System.out.println(result);
	}
	/**
	 * post
	 * @param url
	 * @param map
	 * @param charset
	 * @return
	 */
    public static String doPost(String url,Map<String,String> map,String charset){  
        HttpClient httpClient = null;  
        HttpPost httpPost = null;  
        String result = null;  
        try{  
            httpClient = createSSLClientDefault();  
            httpPost = new HttpPost(url);  
            //设置参数  
            List<NameValuePair> list = new ArrayList<NameValuePair>();  
            for(Entry<String,String> elem : map.entrySet()){  
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
            }  
            if(list.size() > 0){  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);  
                httpPost.setEntity(entity);  
            }  
            HttpResponse response = httpClient.execute(httpPost);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,charset);  
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return result;  
    }  
    /**
     * get
     * @param url
     * @param map
     * @param charset
     * @return
     */
    public static String doGet(String url,Map<String,String> map,String charset){  
        HttpClient httpClient = null;  
        HttpGet httpGet = null;  
        String result = null;  
        try{  
            httpClient = createSSLClientDefault();  
            httpGet = new HttpGet(url);  
            HttpResponse response = httpClient.execute(httpGet);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,charset);  
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return result;  
    }  
    public static CloseableHttpClient createSSLClientDefault(){
    	try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, 
					new TrustStrategy(){

						@Override
						public boolean isTrusted(X509Certificate[] arg0, String arg1)
								throws CertificateException {
							// TODO Auto-generated method stub
							return true;
						}}).build();
			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext);
			return HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return HttpClients.createDefault();
    }
}  
