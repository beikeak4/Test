package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.xml.transform.Result;
import java.io.File;
import java.util.List;

//@RestController
//public class DemoController {
//    @PostMapping("/saveUser")
//    public void saveUser(@RequestBody JSONPObject jsonObject){
//        System.out.println("jsonObject = " + jsonObject);
//    }
//}
//@RestController
//public class FaceChainLoRAReceiver {
//
//    @PostMapping("/saveUser")
//    public Result saveUser(@RequestBody JSONObject request) {
//        String LName = request.getString("LName");
//        int modelID = request.getInteger("modelID");
//        List<String> images = request.getJSONArray("images").toJavaList(String.class);
//        int uid = request.getInteger("uid");
//
//        // 在这里可以对接收到的数据进行处理和存储操作
//        // 例如调用 FaceChainLoRAService 进行人物 LoRA 制作
//
//        return Result.success("保存用户成功");
//    }
//}
@RestController
public class FaceChain {

    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @PostMapping("/saveUser")
    public void saveUser(@RequestBody JSONObject jsonObject){
        String LName = jsonObject.getString("LName");
        int modelID = jsonObject.getInteger("modelID");
        List<String> images = jsonObject.getJSONArray("images").toJavaList(String.class);
        int uid = jsonObject.getInteger("uid");
        // 在这里可以对接收到的数据进行处理和存储操作
        // 例如调用 FaceChainLoRAService 进行人物 LoRA 制作
        System.out.println("images = ");///
        System.out.println("LName = " + LName);
        System.out.println("modelID = " + modelID);
        System.out.println("uid = " + uid);
        String url = "http://localhost:8080/FaceChain/returnLoRA";
        JSONObject request = new JSONObject();
        request.put("LName", LName);
        File binFile = new File("F:/temp/pytorch_lora_weights.bin");
        request.put("uid", uid);
        System.out.println("下面是restTemplate     request = " + request);
        restTemplateUtil.postWithFile(url, request, binFile, JSONObject.class);
        System.out.println("000000000000000000000 response");

    }
}