package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class test {


    public static void main(String[] args) {


        try (BufferedReader br= Files.newBufferedReader(Paths.get("data.csv"));){
//            br = Files.newBufferedReader(Paths.get("../data.csv"));
            String DELIMITER = ",";
            // 按行读取
            String line;
            while ((line = br.readLine()) != null) {
                // 分割
                String[] columns = line.split(DELIMITER);
                // 打印行
                System.out.println("User[" + String.join(", ", columns) + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
