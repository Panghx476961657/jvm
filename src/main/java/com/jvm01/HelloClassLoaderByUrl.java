package com.jvm01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 * <p>
 * 1、error: 自己用网上工具把Hello.class的二进制BASE64编码
 * 执行报错：Exception in thread "main" java.lang.ClassFormatError: Incompatible magic value 1667327589 in class file jvm/Hello
 * TODO 麻烦助教老师解释一下原因
 * </p>
 *
 * <p>
 * 2、直接根据路径读取二进制字节码
 * </p>
 */
public class HelloClassLoaderByUrl extends ClassLoader {

    private String path;

    public HelloClassLoaderByUrl(String classPath) {
        this.path = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = getData();
        if (bytes == null) {
            System.out.println("findClass bytes is null");
            return null;
        }
        System.out.println("Class byte length:" + bytes.length);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] getData() {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("【" + path + "】: path is not exists!");
            return null;
        }
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int size = 0;
            while ((size = in.read(buffer)) > 0) {
                out.write(buffer, 0, size);
            }
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(1);
        String path = "F:\\java学习\\jvm\\src\\main\\com\\jvm01\\MyHello.class";
        HelloClassLoaderByUrl classloader = new HelloClassLoaderByUrl(path);
        Class<?> classLoad = classloader.findClass("com.jvm01.MyHello");
        if (classLoad == null) {
            return;
        }

        //初始化类
        Object obj = classLoad.newInstance();

        //通过反射调用main方法
        Method method = classLoad.getDeclaredMethod("main", String[].class);
        method.invoke(obj, (Object) new String[]{});
    }

}