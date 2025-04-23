package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Util.AliOssUtil;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        String url = AliOssUtil.uploadFile(fileName, file.getInputStream());

//        // 创建 RestTemplate 实例
//        RestTemplate restTemplate = new RestTemplate();
//
//        // 构建请求头
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//        // 构建请求体
//        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//        body.add("file", new MultipartInputStreamFileResource(file.getInputStream(), originalFilename));
//
//        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
//
//        // 调用 9090 端口的接口
//        String targetUrl = "http://8.153.204.9:9090/upload";
//        ResponseEntity<String> response = restTemplate.postForEntity(targetUrl, requestEntity, String.class);
//
//        // 打印返回结果
//        System.out.println("Response from 9090: " + response.getBody());

        return Result.success(url);
    }

    // 自定义 MultipartInputStreamFileResource 类，用于处理 MultipartFile 的 InputStream
    class MultipartInputStreamFileResource extends InputStreamResource {
        private final String filename;

        public MultipartInputStreamFileResource(InputStream inputStream, String filename) {
            super(inputStream);
            this.filename = filename;
        }

        @Override
        public String getFilename() {
            return this.filename;
        }

        @Override
        public long contentLength() throws IOException {
            return -1; // 不确定长度时返回 -1
        }
    }


}
