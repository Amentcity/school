package com.java.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

//访问系统资源
public class FileSystemResourceDemo {
    public static void loadFileResource(String path){
        //创建对象
        FileSystemResource resource=new FileSystemResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        try {
            InputStream inputStream=resource.getInputStream();
            byte[] b=new byte[1024];
            while (inputStream.read(b)!=-1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        loadFileResource("Aop\\src\\main\\resources\\bean.txt");
    }
}
