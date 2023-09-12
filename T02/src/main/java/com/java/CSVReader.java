package com.java;

//package com.mkyong.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {
        path("T02\\src\\main\\resources\\data.csv");
    }
    public static List<Object[]> path(String path){
        File file = new File(path);
        Object[] country;
        List<Object[]> list = null;
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                country = line.split(",");
                list= Collections.singletonList(new String[]{Arrays.toString(country)});
                System.out.println(Arrays.toString(country));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}