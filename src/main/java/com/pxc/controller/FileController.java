package com.pxc.controller;

import com.pxc.utils.QiNiuUploadUtil;
import com.pxc.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pxc on 2018/3/30.
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 上传图片
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Response upload(@RequestParam("pic") MultipartFile file){
        try {
            String url = QiNiuUploadUtil.uploadByInputStream(file.getInputStream());
            logger.info(url);
            Map<String,String> map = new HashMap<>();
            map.put("url",url);
            return Response.ok(map);
        } catch(IOException e) {
           logger.error(e.getMessage(),e);
           return Response.error();
        }
    }
}
