public class jvm.Hello {
  public jvm.Hello();
    Code:
       0: aload_0                            -- 初始化对象Hello到本地方法栈
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V  --调用Object的无参构造方法，返回值Void
       4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;  -- 获取System对象的静态属性out,类型为PrintStream
       7: new           #3                  // class java/lang/StringBuilder  --新建一个StringBuilder对象
      10: dup                                                                                      --复制栈顶元素？
      11: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V  -- 调用StringBuilder的无参构造
      14: ldc           #6                  // String Hello.class is load constructor, now time is:  --把字符串 Hello.class is..., now time is 从常量池推送到栈顶
      16: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; --调用append方法
      19: invokestatic  #8                  // Method java/time/LocalDateTime.now:()Ljava/time/LocalDateTime; --LocalDateTime调用now静态方法
      22: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      25: invokevirtual #10                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String; --调用toString方法
      28: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V  -- PrintStream调用println方法入参String,返回Void
      31: return

  public static void main(java.lang.String[]) throws java.lang.Exception;
    Code:
       0: bipush        100  --将单字节的常量值(100)推送至栈顶
       2: istore_1               --将栈顶int型数值存入第二个本地变量
       3: lconst_0               --将long型0推送至栈顶
       4: lstore_2               --将栈顶long型数值存入第三个本地变量
       5: lconst_0              --将long型0推送至栈顶
       6: lstore        4       --将栈顶long型数值存入指定本地变量
       8: iconst_0             --将int型0推送至栈顶
       9: istore        6     --将栈顶int型数值存入指定本地变量
      11: iload         6     --将指定的int型本地变量推送至栈顶
      13: iload_1           --将第二个int型本地变量推送至栈顶
      14: if_icmpge     57  -- 比较栈顶两int型数值（i和100）大小, 当结果大于等于0时跳转至 57 行
      17: iload         6   ---- 将指定的int型本地变量推送至栈顶
      19: bipush        100  -- 将单字节的常量值100（count）推送至栈顶
      21: if_icmplt     27  -- 比较栈顶两int(i和count)型数值大小, 当结果小于0时跳转
      24: goto          57  --结果为true跳转到57行
      27: iload         6  --将指定的int i 型本地变量推送至栈顶
      29: iconst_2   -- 将int型变量2推送至栈顶
      30: irem      --将栈顶两int型数值 i 作取模运算并将结果压入栈顶
      31: ifeq          43 -- 如果等于0成立 舔砖至43行
      34: lload_2         --将第三个long型本地变量推送至栈顶
      35: iload         6  -- 将指定的int型本地变量推送至栈顶
      37: i2l                  -- 降i从int转为long
      38: ladd             --将栈顶两long型数值相加并将结果压入栈顶
      39: lstore_2      --将栈顶long型数值存入第三个本地变量
      40: goto          51 --跳转到51

​      43: lload         4    -- else 将指定的long型本地变量推送至栈顶
​      45: iload         6   -- 将指定的int型本地变量推送至栈顶
​      47: i2l             -- 将i从int转为long
​      48: ladd          --将栈顶两long型数值相加并将结果压入栈顶
​      49: lstore        4  --将栈顶long型数值存入指定本地变量
​      51: iinc          6, 1  --将指定int(6行)型变量增加指定值 i
​      54: goto          11  --再次跳转11行，循环
​      57: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
​      60: new           #3                  // class java/lang/StringBuilder
​      63: dup

​		

​		//以下执行输出

​      64: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
​      67: ldc           #12                 // String 100以内的奇数和为：
​      69: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
​      72: lload_2
​      73: invokevirtual #13                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
​      76: invokevirtual #10                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
​      79: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
​      82: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
​      85: new           #3                  // class java/lang/StringBuilder
​      88: dup
​      89: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
​      92: ldc           #14                 // String 100以内的偶数和为：
​      94: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
​      97: lload         4
​      99: invokevirtual #13                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
​     102: invokevirtual #10                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
​     105: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
​     108: return

  static {};  --静态代码块和构造方法类似
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: new           #3                  // class java/lang/StringBuilder
       6: dup
       7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      10: ldc           #15                 // String Hello.class is load static, now time is:
      12: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      15: invokestatic  #8                  // Method java/time/LocalDateTime.now:()Ljava/time/LocalDateTime;
      18: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      21: invokevirtual #10                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      24: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      27: return
}