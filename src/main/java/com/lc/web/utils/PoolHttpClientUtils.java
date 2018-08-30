package com.lc.web.utils;



import com.lc.web.Constants;
import com.lc.web.log.LogUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PoolHttpClientUtils
 * @Description: http帮助类
 * @author liangcan
 * @date 2014-3-16 下午2:46:23
 * @version 1.0
 */
public class PoolHttpClientUtils
{
    /**
     * 设置请求超时
     */
    private static final int REQUEST_TIMEOUT = 10 * 1000;

    /**
     * 连接超时
     */
    private static final int SO_TIMEOUT = 60 * 1000;

    /**
     * 每个主机的最大并行链接数
     */
    private static final int MAX_PER_ROUTE = 1000;

    /**
     * 客户端总并行链接最大数
     */
    private static final int MAX_TOTAL = 15000;

    private static final int DEFAULTMAXCONNECTION = 300;

    private static HttpClientBuilder httpBulder = null;

    private static RequestConfig requestConfig = null;

    private static PoolingHttpClientConnectionManager pccm = null;

    /**
     * 初始化
     */
    static
    {
        try
        {
            SSLContext sslContext = SSLContexts.custom().useTLS().build();
            sslContext.init(null, new TrustManager[] { new X509TrustManager()
            {
                public X509Certificate[] getAcceptedIssuers()
                {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType)
                {

                }

                public void checkServerTrusted(X509Certificate[] certs, String authType)
                {

                }
            } }, null);

            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.INSTANCE).register("https", new SSLConnectionSocketFactory(sslContext)).build();
            pccm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        }
        catch(Exception e)
        {
            LogUtils.error("连接线程发生异常 PoolHttpClientUtils:{}", e);
        }

        requestConfig = RequestConfig.custom().setSocketTimeout(SO_TIMEOUT).setConnectTimeout(REQUEST_TIMEOUT).setConnectionRequestTimeout(REQUEST_TIMEOUT).build();

        // 多连接的线程安全的管理器
        pccm.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        pccm.setDefaultMaxPerRoute(DEFAULTMAXCONNECTION);
        pccm.setMaxTotal(MAX_TOTAL);

        httpBulder = HttpClients.custom();
        httpBulder.setConnectionManager(pccm);
    }

    public static CloseableHttpClient getConnection()
    {
        return httpBulder.build();
    }

    /**
     * json格式请求发送数据
     */
    public static String post(String url, String params) {
        HttpUriRequest post = null;
        StringEntity jsonStrData = new StringEntity(params, "UTF-8");
        jsonStrData.setContentType("application/json");
        post = RequestBuilder.post().setUri(url).setEntity(jsonStrData).setConfig(requestConfig).build();
        CloseableHttpResponse response = null;
        try {
            response = getConnection().execute(post);
            HttpEntity entity = response.getEntity();

            if (response.getStatusLine().getStatusCode() != 200) {
                post.abort();
            }
            if (entity != null) {
                String str = EntityUtils.toString(entity, Constants.DEFAULT_ENCODE);
                return str;
            }
        } catch (ClientProtocolException e) {
            LogUtils.error("链接 http 异常" + e);
        } catch (IOException e) {
            LogUtils.error("http 发送 异常" + e);
        } finally {
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    LogUtils.error("关闭 http 异常" + e);
                }

                releaseConn();
            }
        }
        return null;
    }
    /**
     * @Title: postJsonRequestMethod
     * @Description: 执行post请求
     * @param @param url 请求地址
     * @param @param obj 请求参数对象
     * @param @return 请求结果
     * @param @throws Exception 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String post(String url, Map<String, String> params) throws Exception
    {
        LogUtils.info("[HttpUtils Post]Debug request " + url + " reqData :" + params.toString());
        HttpUriRequest post = null;
        List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());

        for (Entry<String, String> entry : params.entrySet())
        {
            NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
            pairList.add(pair);
        }
        post = RequestBuilder.post().setUri(url).setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8"))).setConfig(requestConfig).build();

        CloseableHttpResponse response = null;

        try
        {
            response = getConnection().execute(post);
            HttpEntity entity = response.getEntity();

            if (response.getStatusLine().getStatusCode() != 200)
            {
                post.abort();
            }

            if (entity != null)
            {
                String str = EntityUtils.toString(entity, Constants.DEFAULT_ENCODE);
                LogUtils.info("[HttpUtils Post]Debug response, url :" + url + " rspData :" + str);
                return str;
            }
        }
        catch(ClientProtocolException e)
        {
            throw e;
        }
        catch(IOException e)
        {
            throw e;
        } finally
        {
            if (null != response)
            {
                try
                {
                    response.close();
                }
                catch(IOException e)
                {
                    throw e;
                }

                releaseConn();
            }
        }

        return null;
    }

    public static HttpUriRequest getRequestMethod(Map<String, String> map, String url, String method)
    {
        HttpUriRequest reqMethod = null;
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        if (null != map)
        {
            Set<Entry<String, String>> entrySet = map.entrySet();

            for (Entry<String, String> e : entrySet)
            {
                String name = e.getKey();
                String value = e.getValue();
                NameValuePair pair = new BasicNameValuePair(name, value);
                params.add(pair);
            }
        }

        if (HttpMethod.POST.equals(method))
        {
            reqMethod = RequestBuilder.post().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()])).setConfig(requestConfig)
                    .build();
        }
        else if (HttpMethod.GET.equals(method))
        {
            reqMethod = RequestBuilder.get().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()])).setConfig(requestConfig)
                    .build();
        }

        return reqMethod;
    }

    /**
     * @Title: releaseConn
     * @Description: 释放连接
     * @return void 返回类型
     */
    public static void releaseConn()
    {
        if (null != pccm)
        {
            pccm.closeExpiredConnections();
            pccm.closeIdleConnections(5, TimeUnit.SECONDS);
        }
    }

    public static void main(String [] args) throws Exception {
//        System.out.print("ss");
//
//        Map<String, String> pa = new HashMap<String, String>();
//        pa.put("client", "C_1482924503487");
//        pa.put("qos", "0");
//        pa.put("retain", "CQSSC");
//        pa.put("topic", "123");
//        pa.put("message", "hello");
//        pa.put("userName", "gjkj");
//        pa.put("password", "password");
//        try {
//            System.out.print( post("http://120.77.200.4:8083/mqtt/publish",pa));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        pa.put("account",  "cf_huahai");
//        pa.put("password", "mr.deepen");
//        pa.put("content", "亲爱滴 亿计划 用户：您的验证码是：231654。请不要把验证码泄露给其他人。如非本人操作，可不用理会！");
//        pa.put("mobile", "18503019750");
//        pa.put("mobile", "15219481278");
//        System.out.print(pa.toString());
//       ?lotId=CQSSC
            System.out.print(post("http://localhost:8080/server/task/add/task.do","{\n" +
                    "  \"cycle\": true,\n" +
                    "  \"key\": \"10000\",\n" +
                    "  \"reqData\": \"key=10000&requestTime=1660927290321\",\n" +
                    "  \"reqDate\": \"121000\",\n" +
                    "  \"reqUrl\": \"http://baidu.com\",\n" +
                    "  \"reqWeek\": \"4\",\n" +
                    "  \"requestTime\": \"1660927290321\",\n" +
                    "  \"taskName\": \"场景定时任务\",\n" +
                    "  \"taskType\": \"2\"\n" +
                    "}"));
    }


}
