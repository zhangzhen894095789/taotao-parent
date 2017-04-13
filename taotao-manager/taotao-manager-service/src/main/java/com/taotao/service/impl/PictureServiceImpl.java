package com.taotao.service.impl;

import com.taotao.common.pojo.FtpUtil;
import com.taotao.common.pojo.IDUtils;
import com.taotao.common.pojo.PictureResult;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class PictureServiceImpl implements PictureService {
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;
    @Value("${FILI_UPLOAD_PATH}")
    private String FILI_UPLOAD_PATH;
    @Value("${FTP_SERVER_IP}")
    private String FTP_SERVER_IP;
    @Value("${FTP_SERVER_PORT}")
    private Integer FTP_SERVER_PORT;
    @Value("${FTP_SERVER_USERNAME}")
    private String FTP_SERVER_USERNAME;
    @Value("${FTP_SERVER_PASSWORD}")
    private String FTP_SERVER_PASSWORD;

    @Override
    public PictureResult uploadFile(MultipartFile uploadFile) throws Exception {

        // 上传文件功能实现
        String path = savePicture(uploadFile);
        // 回显
        PictureResult result = new PictureResult(0, IMAGE_BASE_URL + path);
        return result;
    }

    private String savePicture(MultipartFile uploadFile) {
        String result = null;
        try {
            // 上传文件功能实现
            // 判断文件是否为空
            if (uploadFile.isEmpty())
                return null;
            // 上传文件以日期为单位分开存放，可以提高图片的查询速度
            String filePath = "/" + new SimpleDateFormat("yyyy").format(new Date()) + "/"
                    + new SimpleDateFormat("MM").format(new Date()) + "/"
                    + new SimpleDateFormat("dd").format(new Date());

            // 取原始文件名
            String originalFilename = uploadFile.getOriginalFilename();
            // 新文件名
            String newFileName = IDUtils.genImageName() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // 转存文件，上传到ftp服务器
            FtpUtil.uploadFile(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_SERVER_USERNAME, FTP_SERVER_PASSWORD,
                    FILI_UPLOAD_PATH, filePath, newFileName, uploadFile.getInputStream());
            result = filePath + "/" + newFileName;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 图片名生成
     */
    public static String genImageName() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        //如果不足三位前面补0
        String str = millis + String.format("%03d", end3);

        return str;
    }

}
