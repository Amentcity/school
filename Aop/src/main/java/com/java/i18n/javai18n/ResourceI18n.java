package com.java.i18n.javai18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceI18n {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("zh", "CN"));
        String string = bundle.getString("test");
        System.out.println(string);
        ResourceBundle bundle2 = ResourceBundle.getBundle("messages", new Locale("en", "GB"));
        String string2 = bundle2.getString("test");
        System.out.println(string2);
    }
}
