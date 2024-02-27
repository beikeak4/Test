package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;


@Component
public class RestTemplateUtil {
    /**
     * 请求头类型名
     */
    private static final String HEADER_NAME = "Content-Type";
    /**
     * 请求头类型值
     */
    private static final String HEADER_VALUE = "application/json";
    /**
     * 身份令牌key
     */
    private static final String TOKEN_NAME = "UserToken";
    /**
     * 调用的url返回的消息体的key
     */
    private static final String RESPONSE_BODY = "responseBody";
    @Autowired
    private RestTemplate restTemplate;


    //---------------------------------postForEntity--------------------------------------------------------
    /**
     * post请求连接
     * @param url 请求地址
     * @param responseType 响应类型
     * return
     */
    public JSONObject post(String url, Class responseType){
        //构建请求头
        HttpHeaders headers = new HttpHeaders();
        //请求头内容类型和对应的值
        headers.add(HEADER_NAME,HEADER_VALUE);
        //请求头组装的请求体
        HttpEntity httpEntity = new HttpEntity(headers);
        //响应体构建
        ResponseEntity responseEntity = restTemplate.postForEntity(url,httpEntity,responseType);
        //响应体获取
        Object responseBodyObj = responseEntity.getBody();
//        System.out.println(responseBodyObj);
        //响应体转换类型
        JSONObject responseBodyJsonObj = new JSONObject();
        responseBodyJsonObj.put(RESPONSE_BODY,responseBodyObj);
        //响应体返回(调用的接口返回的内容)
        return responseBodyJsonObj;
    }

    /**
     * post请求连接
     * @param userToken 身份认证令牌
     * @param url 请求地址
     * @param responseType 响应类型
     * return
     */
    public JSONObject post(String userToken, String url, Class responseType){
        //构建请求头
        HttpHeaders headers = new HttpHeaders();
        //请求头内容类型和对应的值
        headers.add(HEADER_NAME,HEADER_VALUE);
        //请求头内容含有token值
        headers.add(TOKEN_NAME,userToken);
        //请求头组装请求体
        HttpEntity httpEntity = new HttpEntity(headers);
        //响应体构建传参
        ResponseEntity responseEntity = restTemplate.postForEntity(url,httpEntity,responseType);
        //响应体获取
        Object responseBodyObj = responseEntity.getBody();
        //响应体转换类型object转jsonObject
        JSONObject responseBodyJsonObj = new JSONObject();
        responseBodyJsonObj.put(RESPONSE_BODY,responseBodyObj);
        //返回响应体
        return responseBodyJsonObj;
    }

    /**
     * post请求连接
     * @param url 请求地址
     * @param requestJson 请求内容json
     * @param responseType 响应类型
     * return
     */
    public JSONObject post(String url, JSONObject requestJson, Class responseType){
        //请求头构建
        HttpHeaders headers = new HttpHeaders();
        //请求头内容类型
        headers.add(HEADER_NAME,HEADER_VALUE);
        //请求头组装请求体，含有请求内容
        HttpEntity httpEntity = new HttpEntity(requestJson,headers);
//        HttpEntity httpEntity = new HttpEntity<>(JSON.toJSONString(requestJson),headers);
        //响应体构建
        ResponseEntity responseEntity = restTemplate.postForEntity(url,httpEntity,responseType);
        //响应体获取
        Object responseBodyObj = responseEntity.getBody();
        //响应体转换类型
        JSONObject responseBodyJsonObj = new JSONObject();
        responseBodyJsonObj.put(RESPONSE_BODY,responseBodyObj);
        //返回响应体内容
        return responseBodyJsonObj;
    }


    /**
     * post请求连接
     * @param userToken 身份认证令牌
     * @param url 请求地址
     * @param requestJson 请求内容
     * @param responseType 响应类型
     * return
     */
    public JSONObject post(String userToken, String url, JSONObject requestJson, Class responseType){
        //构建请求头
        HttpHeaders headers = new HttpHeaders();
        //请求头内容填充
        headers.add(HEADER_NAME,HEADER_VALUE);
        //请求头内容含有token值
        headers.add(TOKEN_NAME,userToken);
        //请求头及请求内容组装请求体
        HttpEntity httpEntity = new HttpEntity(requestJson,headers);
        //响应体构建
        ResponseEntity responseEntity = restTemplate.postForEntity(url,httpEntity,responseType);
        //响应体获取
        Object responseBodyObj = responseEntity.getBody();
        //响应体类型转换
        JSONObject responseBodyJsonObj = new JSONObject();
        responseBodyJsonObj.put(RESPONSE_BODY,responseBodyObj);
        //响应体返回
        return responseBodyJsonObj;
    }

    //---------------------------------getForEntity--------------------------------------------------------
    /**
     * get请求连接
     * @param url 请求地址
     * @param responseType 响应类型
     * return
     */
    public JSONObject get(String url, Class responseType){
        //构建请求头
        HttpHeaders headers = new HttpHeaders();
        //请求头内容类型和对应的值
        headers.add(HEADER_NAME,HEADER_VALUE);
        //请求头组装的请求体
        HttpEntity httpEntity = new HttpEntity(headers);
        //响应体构建
        ResponseEntity responseEntity = restTemplate.getForEntity(url,responseType,httpEntity);
        //响应体获取
        Object responseBodyObj = responseEntity.getBody();
        //响应体转换类型
        JSONObject responseBodyJsonObj = new JSONObject();
        responseBodyJsonObj.put(RESPONSE_BODY,responseBodyObj);
        //响应体返回
        return responseBodyJsonObj;
    }

    /**
     * get请求连接
     * @param url 请求地址
     * @param responseType 响应类型
     * return
     */
    public JSONObject getNonEntity(String url, Class responseType){
        //响应体构建
        ResponseEntity responseEntity = restTemplate.getForEntity(url,responseType);
        //响应体获取
        Object responseBodyObj = responseEntity.getBody();
        //响应体转换类型
        JSONObject responseBodyJsonObj = new JSONObject();
        responseBodyJsonObj.put(RESPONSE_BODY,responseBodyObj);
        //响应体返回
        return responseBodyJsonObj;
    }

    /**
     * get请求连接
     * @param userToken 身份认证令牌
     * @param url 请求地址
     * @param responseType 响应类型
     * return
     */
    public JSONObject get(String userToken, String url, Class responseType){
        //构建请求头
        HttpHeaders headers = new HttpHeaders();
        //请求头内容类型和对应的值
        headers.add(HEADER_NAME,HEADER_VALUE);
        //请求头内容含有token值
        headers.add(TOKEN_NAME,userToken);
        //请求头组装请求体
        HttpEntity httpEntity = new HttpEntity(headers);
        //响应体构建传参
        ResponseEntity responseEntity = restTemplate.getForEntity(url,responseType, httpEntity);
        //响应体获取
        Object responseBodyObj = responseEntity.getBody();
        //响应体转换类型object转jsonObject
        JSONObject responseBodyJsonObj = new JSONObject();
        responseBodyJsonObj.put(RESPONSE_BODY,responseBodyObj);
        //返回响应体
        return responseBodyJsonObj;
    }



    /**
     * get请求连接
     * @param url 请求地址
     * @param requestJson 请求内容
     * @param responseType 响应类型
     * return
     */
    public JSONObject get(String url, JSONObject requestJson, Class responseType){
        //请求头构建
        HttpHeaders headers = new HttpHeaders();
        //请求头内容类型
        headers.add(HEADER_NAME,HEADER_VALUE);
        //请求头组装请求体，含有请求内容
        HttpEntity httpEntity = new HttpEntity(requestJson,headers);
        //响应体构建
        ResponseEntity responseEntity = restTemplate.getForEntity(url,responseType,httpEntity);
        //响应体获取
        Object responseBodyObj = responseEntity.getBody();
        //响应体转换类型
        JSONObject responseBodyJsonObj = new JSONObject();
        responseBodyJsonObj.put(RESPONSE_BODY,responseBodyObj);
        //返回响应体内容
        return responseBodyJsonObj;
    }


    /**
     * get请求连接
     * @param userToken 身份认证令牌
     * @param url 请求地址
     * @param requestJson 请求内容
     * @param responseType 响应类型
     * return
     */
    public JSONObject get(String userToken, String url, JSONObject requestJson, Class responseType){
        //构建请求头
        HttpHeaders headers = new HttpHeaders();
        //请求头内容填充
        headers.add(HEADER_NAME,HEADER_VALUE);
        //请求头内容含有token值
        headers.add(TOKEN_NAME,userToken);
        //请求头及请求内容组装请求体
        HttpEntity httpEntity = new HttpEntity(requestJson,headers);
        //响应体构建
        ResponseEntity responseEntity = restTemplate.getForEntity(url,responseType,httpEntity);
        //响应体获取
        Object responseBodyObj = responseEntity.getBody();
        //响应体类型转换
        JSONObject responseBodyJsonObj = new JSONObject();
        responseBodyJsonObj.put(RESPONSE_BODY,responseBodyObj);
        //响应体返回
        return responseBodyJsonObj;
    }


    /**
     * post请求连接
     * @param url 请求地址
     * @param jsonData json内容
     * @param binaryFile 二进制文件
     * @param responseType 响应类型
     * return
     */
    public JSONObject postWithFile(String url, JSONObject jsonData, File binaryFile, Class responseType) {
        // 构建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // 构建请求体，包含 JSON 数据和二进制文件
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("json", jsonData);
        body.add("file", new FileSystemResource(binaryFile));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // 发送 POST 请求
        ResponseEntity responseEntity = restTemplate.postForEntity(url, requestEntity, responseType);

        // 获取响应体内容
        Object responseBodyObj = responseEntity.getBody();

        // 将响应体转换为 JSONObject
        JSONObject responseBodyJsonObj = new JSONObject();
        responseBodyJsonObj.put("responseBody", responseBodyObj);

        return responseBodyJsonObj;
    }


}