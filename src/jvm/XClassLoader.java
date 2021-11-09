package jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * 自定义类加载器，加载Hello.xlass
 */
public class XClassLoader extends ClassLoader {

    private String path;
    private String suffix;

    public XClassLoader(String classPath, String suffix) {
        this.path = classPath;
        this.suffix = suffix;
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
        String resourcePath = path.replace(".", "/");
        File file = new File(resourcePath + suffix);
        if (!file.exists()) {
            System.out.println("【" + resourcePath + suffix + "】: file is not exists!");
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
            byte[] result = out.toByteArray();
            return decode(result);
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

    /**
     * Hello.class 文件所有字节（x=255-x）处理后的文件
     *
     * @param byteArray
     * @return
     */
    private static byte[] decode(byte[] byteArray) {
        byte[] targetArray = new byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            targetArray[i] = (byte) (255 - byteArray[i]);
        }
        return targetArray;
    }

    public static void main(String[] args) throws Exception {
        String path = "D:\\JAVA学习\\workspace\\src\\jvm\\Hello";
        XClassLoader classloader = new XClassLoader(path, ".xlass");
        Class<?> clazz = classloader.findClass("Hello");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(clazz.getSimpleName() + "." + m.getName());
        }
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod("hello");
        method.invoke(instance);
    }

}