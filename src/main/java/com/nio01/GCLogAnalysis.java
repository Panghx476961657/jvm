package main.com.jvm02;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * javac -encoding UTF-8 GCLogAnalysis.java
 * <p>
 * java -XX:+PrintGCDetails GCLogAnalysis
 */
public class GCLogAnalysis {

    public static Random random = new Random();

    public static void main(String[] args) {

        //当前毫秒时间错
        long startMillis = System.currentTimeMillis();
        //持续的毫秒数
        long timeoutMillis = TimeUnit.SECONDS.toMillis(1);
        //结束时间
        long endMillis = startMillis + timeoutMillis;


        LongAdder counter = new LongAdder();
        System.out.println("正在运行");
        //缓存一部分对象进入老年代
        int cacheSize = 2000;
        Object[] cachedGarbage = new Object[cacheSize];
        //在时间范围类持续循环
        while (System.currentTimeMillis() < endMillis) {
            //生成垃圾对象
            Object garbage = genarateGarbage(100 * 1024);
            counter.increment();
            int randomIndex = random.nextInt(2 * cacheSize);
            if (randomIndex < cacheSize) {
                cachedGarbage[randomIndex] = garbage;
            }
        }
        System.out.println("执行结束，共生成对象次数：" + counter.longValue());

    }

    //生成对象
    private static Object genarateGarbage(int max) {
        int randomSize = random.nextInt(max);
        int type = randomSize % 4;
        Object result = null;
        switch (type) {
            case 0:
                result = new int[randomSize];
                break;
            case 1:
                result = new byte[randomSize];
                break;
            case 2:
                result = new double[randomSize];
                break;
            default:
                StringBuilder builder = new StringBuilder();
                String randomString = "RandomString-Anything";
                while (builder.length() < randomSize) {
                    builder.append(randomString);
                    builder.append(max);
                    builder.append(randomSize);
                }
                result = builder.toString();
                break;
        }
        //System.out.println(result);
        return result;
    }

}
