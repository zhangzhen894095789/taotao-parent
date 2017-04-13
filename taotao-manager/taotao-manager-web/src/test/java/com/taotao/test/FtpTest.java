package com.taotao.test;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;

/**
 * commons-net.jar包的ftp工具
 */
public class FtpTest {
    public static void main(String[] args) throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.127.136");
        ftpClient.login("ftpuser", "ftpuser");
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\bccb0bfe4bdc13f46cbff28b7b79b78a.jpg"));
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.storeFile("123.jpg", inputStream);
        inputStream.close();

        ftpClient.logout();
    }

}
