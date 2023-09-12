package com.java.bean;

import com.java.anno.Bean;
import com.java.anno.Di;
import com.java.dao.UserDao;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext {
    //创建map集合，放bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();
    private static String rootPath;

    @Override
    public Object getBean(Class class1) {
        return beanFactory.get(class1);
    }

    //设置包扫描规则，哪个类有@Bean注解，把这个类通过反射实例化

    public AnnotationApplicationContext(String basePackage) {
//    public static void pathDemo1(String basePackage){
        //获取包绝对路径
        Enumeration<URL> urls = null;
        try {
            //com.java
            //把.替换成\
            String packagePath = basePackage.replaceAll("\\.", "\\\\");
            urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                String decode = URLDecoder.decode(url.getFile(), "utf-8");
                //获取包前面路径部分，字符串截取
                rootPath = decode.substring(0, decode.length() - packagePath.length());
                //包扫描
                loadBean(new File(decode));
                System.out.println(decode);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //属性注入
        loadDi();
    }

    //包扫描过程，实例化
    private void loadBean(File file) throws Exception {
        //1.判断当前是否文件夹
        if (file.isDirectory()){
            //2.获取文件夹里面所有内容
            File[] childrenFiles = file.listFiles();
            //3.判断文件夹里面为空，直接返回
            if (childrenFiles==null||childrenFiles.length==0){
                return;
            }
            //4.如果 文件夹里面不为空，遍历文件夹所有内容
            for (File child :childrenFiles) {
                //4.1遍历得到每个File对象，继续判断，如果还是文件夹，递归
                if (child.isDirectory()){
                    //递归
                    loadBean(child);
                }else {
                    //4.2遍历得到的File对象不是文件夹，是文件，
                    //4.3得到包路径+类名称部分-字符串截取
                    String substring = child.getAbsolutePath().substring(rootPath.length() - 1);
                    //4.4 判断当前文件是否为.class
                    if (substring.contains(".class")){
                        //4.5 如果是.class类型，把路径\替换成. 把.class去掉
                        // com.java.service.UserServiceImpl
                        String replace = substring.replaceAll("\\\\", ".").replace(".class", "");
                        //4.6判断类上面是否有注解@Bean，如果有实例化过程
                        //4.6.1获取类的class
                        Class<?> aClass = Class.forName(replace);
                        //4.6.2 判断是否是接口
                        if (!aClass.isInterface()){
                            //4.6.3判断类上面是否有注解@Bean
                            Bean annotation = (Bean) aClass.getAnnotation(Bean.class);
                            if (annotation!=null){
                                //4.6.4 实例化
                                Object newInstance = aClass.getConstructor().newInstance();
                                //4.7把对象实例化之后，放到map集合beanFactory
                                //4.7.1 判断当前类如果有接口，让接口class作为map的key
                                if (aClass.getInterfaces().length>0){
                                    beanFactory.put(aClass.getInterfaces()[0],newInstance);
                                }else {
                                    beanFactory.put(aClass,newInstance);
                                }
                            }
                        }
                    }

                }
            }
        }
    }
    //    public static void main(String[] args) {
//        ApplicationContext context=new AnnotationApplicationContext("com.java");
//        context.getBean(UserDao.class);
//    }

    private void loadDi() {
        //实例化对象在beanFactory的map集合里面
        //1.遍历beanFactory的map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry:entries) {
            //2.获取map集合每个对象(value),每个对象属性获取到
            Object value = entry.getValue();
            //获取对象class
            Class<?> aClass = value.getClass();
            //获取每个对象中的属性
            Field[] declaredFields = aClass.getDeclaredFields();
            //3.遍历得到每个对象属性数组，得到每个属性
            for (Field filed:declaredFields) {
                //4.判断属性上面是否有@Di注解
                Di annotation = filed.getAnnotation(Di.class);
                if (annotation!=null){
                    //如果私有属性，设置可以设置值
                    filed.setAccessible(true);
                    //5.如果有@Di注解，把对象进行设置(注入)
                    try {
                        filed.set(value,beanFactory.get(filed.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }

}
