package com.taotao.controller;

import com.taotao.common.pojo.PictureResult;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/pic")
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @RequestMapping("/upload")
    public PictureResult upload(MultipartFile uploadFile){
        try{
            PictureResult pictureResult = pictureService.uploadFile(uploadFile);
            return pictureResult;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
