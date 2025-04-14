package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Controller.FileUploadController;
import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Mapper.ApplyMapper;
import org.design.tradewatch.Service.ApplyService;
import org.design.tradewatch.Util.AliOssUtil;
import org.design.tradewatch.Util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;

    public void newApply(String algorithm ,String datawrite,String multialgo){
      String applytime=  LocalDateTime.now().toString().substring(0,19);
        Map<String ,Object>mp= ThreadLocalUtil.get();
      String userid=(String) mp.get("username");
      applyMapper.newApply( userid,applytime,algorithm,datawrite,multialgo);
    }

    @Override
    public void analyze(String originalFilename, String algorithm) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(originalFilename+algorithm);
        Map<String, String> requestBody = Map.of(
            "filename", originalFilename,
            "method", algorithm
        );

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        // 调用 9090 端口的接口
        String targetUrl = "http://localhost:9090/analyze";
        ResponseEntity<String> response = new RestTemplate().postForEntity(targetUrl, requestEntity, String.class);

        // 打印返回结果
        System.out.println("Response from 9090: " + response.getBody());
    }




}
