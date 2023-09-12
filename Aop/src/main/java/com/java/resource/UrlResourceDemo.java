package com.java.resource;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

//演示UrlResource访问网络资源
public class UrlResourceDemo {
    //访问前缀是http、file
    public static void loadUrlResource(String path){
        //创建Resource实现类对象UrlResource
        try {
            UrlResource urlResource=new UrlResource(path);
            //获取资源信息
            System.out.println(urlResource.getURI());
            System.out.println(urlResource.getFilename());
            System.out.println(urlResource.getDescription());
            System.out.println(urlResource.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        //http前缀开头
        loadUrlResource("https://www.baidu.com");
        //file作为前缀
        loadUrlResource("file:Aop\\src\\main\\resources\\bean.txt");
    }
}