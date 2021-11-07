package jvm;

import java.time.LocalDateTime;

public class Hello {

    private static final String name = "Hello.class";

    public Hello(){
        System.out.println(name + " is load constructor, now time is: " + LocalDateTime.now());
    }

    /**
     * 静态块,无参构造
     */
    static {
        System.out.println(name + " is load static, now time is: " + LocalDateTime.now());
    }

    /**
     * 加载类并不会执行main方法
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(name + " is excute main, now time is: " + LocalDateTime.now());
    }

}