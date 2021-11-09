package jvm;

import java.time.LocalDateTime;

/**
 * javac -encoding UTF-8 MyHello.java
 * javap -c jvm.MyHello
 */
public class MyHello {

    private static final String name = "MyHello.class";

    public MyHello() {
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
     * 求100以内的奇数及偶数和
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int count = 100;
        long sumOddNumber = 0L;
        long sumEvenNumber = 0L;
        for (int i = 0; i < count; i++) {
            if (i >= 100) {
                break;
            }
            if (i % 2 != 0) {
                sumOddNumber += i;
            } else {
                sumEvenNumber += i;
            }
        }
        System.out.println("100以内的奇数和为：" + sumOddNumber);
        System.out.println("100以内的偶数和为：" + sumEvenNumber);
    }

}