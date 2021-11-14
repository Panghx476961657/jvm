# GCLogAnalysis.java分析

## 

javac -encoding UTF-8 GCLogAnalysis.java



注意需要切换到java的src目录

电脑配置windows7 2核4G

## 1.1、不配置堆内存信息直接启动

java -XX:+PrintGCDetails jvm02.GCLogAnalysis

```
正在运行
[GC (Allocation Failure) [PSYoungGen: 32911K->5097K(38400K)] 32911K->12341K(125952K), 0.0488966 secs] [Times: user=0.05 sys=0.01, real=0.05 secs]
[GC (Allocation Failure) [PSYoungGen: 38377K->5095K(71680K)] 45621K->22067K(159232K), 0.0164281 secs] [Times: user=0.02 sys=0.03, real=0.02 secs]
[GC (Allocation Failure) [PSYoungGen: 71648K->5108K(71680K)] 88620K->40047K(159232K), 0.0180366 secs] [Times: user=0.03 sys=0.03, real=0.02 secs]
[GC (Allocation Failure) [PSYoungGen: 71539K->5113K(138240K)] 106478K->62369K(225792K), 0.0220320 secs] [Times: user=0.00 sys=0.09, real=0.03 secs]
[GC (Allocation Failure) [PSYoungGen: 138233K->5117K(138240K)] 195489K->106793K(240128K), 0.0391676 secs] [Times: user=0.05 sys=0.08, real=0.05 secs]
[Full GC (Ergonomics) [PSYoungGen: 5117K->0K(138240K)] [ParOldGen: 101676K->101280K(183296K)] 106793K->101280K(321536K), [Metaspace: 2740K->2740K(1056768K)], 0.0387185 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
[GC (Allocation Failure) [PSYoungGen: 133120K->41351K(294400K)] 234400K->142632K(477696K), 0.0595420 secs] [Times: user=0.06 sys=0.14, real=0.06 secs]
[GC (Allocation Failure) [PSYoungGen: 291719K->54776K(305152K)] 393000K->212211K(488448K), 0.1458833 secs] [Times: user=0.03 sys=0.42, real=0.14 secs]
[Full GC (Ergonomics) [PSYoungGen: 54776K->0K(305152K)] [ParOldGen: 157435K->182079K(284672K)] 212211K->182079K(589824K), [Metaspace: 2740K->2740K(1056768K)], 0.0521879 secs] [Times: user=0.08 sys=0.08, real=0.06 secs]
执行结束，共生成对象次数：2611
Heap
 PSYoungGen      total 305152K, used 10518K [0x00000000d5e00000, 0x00000000fe200000, 0x0000000100000000)
  eden space 250368K, 4% used [0x00000000d5e00000,0x00000000d68459d0,0x00000000e5280000)
  from space 54784K, 0% used [0x00000000e5280000,0x00000000e5280000,0x00000000e8800000)
  to   space 92672K, 0% used [0x00000000f8780000,0x00000000f8780000,0x00000000fe200000)
 ParOldGen       total 284672K, used 182079K [0x0000000081a00000, 0x0000000093000000, 0x00000000d5e00000)
  object space 284672K, 63% used [0x0000000081a00000,0x000000008cbcffe8,0x0000000093000000)
 Metaspace       used 2747K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 297K, capacity 386K, committed 512K, reserved 1048576K
  
  分析：java虚拟机默认使用1/4的内存作为堆内存（内存>1g）
```



## 1.2、设置堆内存

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g  jvm02.GCLogAnalysis

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx512m -Xms512m  jvm02.GCLogAnalysis

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx128m -Xms128m  jvm02.GCLogAnalysis

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx64m -Xms64m  jvm02.GCLogAnalysis



其中-Xloggc:gc.demo.log 可以指定GC打印日志文件

```
正在运行
2021-11-14T19:08:25.949+0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43505K(305664K)] 262144K->82084K(1005056K), 0.1060992 secs] [Times: user=0.11 sys=0.25, real=0.11 secs]
2021-11-14T19:08:26.183+0800: [GC (Allocation Failure) [PSYoungGen: 305649K->43519K(305664K)] 344228K->160792K(1005056K), 0.1392506 secs] [Times: user=0.14 sys=0.37, real=0.14 secs]
2021-11-14T19:08:26.402+0800: [GC (Allocation Failure) [PSYoungGen: 305663K->43505K(305664K)] 422936K->232440K(1005056K), 0.0782713 secs] [Times: user=0.11 sys=0.20, real=0.08 secs]
执行结束，共生成对象次数：2926
Heap
 PSYoungGen      total 305664K, used 54104K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 4% used [0x00000000eab00000,0x00000000eb559d30,0x00000000fab00000)
  from space 43520K, 99% used [0x00000000fab00000,0x00000000fd57c530,0x00000000fd580000)
  to   space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
 ParOldGen       total 699392K, used 188935K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 27% used [0x00000000c0000000,0x00000000cb881cd8,0x00000000eab00000)
 Metaspace       used 2747K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 297K, capacity 386K, committed 512K, reserved 1048576K
  
  Yong区回收内存大小 - 堆整体内存回收大小 = 老年代进升内存大小
  1g、512m执行时没Full Gc
  128m时，发生大量fullGC，没抛内存溢出
  64m时，发生大量fullGC，抛内存溢出java.lang.OutOfMemoryError: Java heap space
本机执行效率较低，对象占用的堆内存较小，所以在128m时才发生FullGc,64m时经过大量FullGc不足与分配对象，报内存溢出
```



## 1.3、使用串行/并行GC

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps  -XX:+UseSerialGC -Xmx1g -Xms1g  jvm02.GCLogAnalysis

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps  jvm02.GCLogAnalysis



```
正在运行
2021-11-14T19:29:18.345+0800: [GC (Allocation Failure) 2021-11-14T19:29:18.345+0800: [DefNew: 279616K->34944K(314560K), 0.0761226 secs] 279616K->87015K(1013632K), 0.0776812 secs] [Times: user=0.05 sys=0.03, real=0.08 secs]
2021-11-14T19:29:18.532+0800: [GC (Allocation Failure) 2021-11-14T19:29:18.532+0800: [DefNew: 314345K->34942K(314560K), 0.0973390 secs] 366417K->167872K(1013632K), 0.0991773 secs] [Times: user=0.05 sys=0.05, real=0.11 secs]
2021-11-14T19:29:18.750+0800: [GC (Allocation Failure) 2021-11-14T19:29:18.750+0800: [DefNew: 314558K->34943K(314560K), 0.0808676 secs] 447488K->247058K(1013632K), 0.0823753 secs] [Times: user=0.06 sys=0.02, real=0.08 secs]
执行结束，共生成对象次数：3296
Heap
 def new generation   total 314560K, used 95540K [0x00000000c0000000, 0x00000000d5550000, 0x00000000d5550000)
  eden space 279616K,  21% used [0x00000000c0000000, 0x00000000c3b2d480, 0x00000000d1110000)
  from space 34944K,  99% used [0x00000000d3330000, 0x00000000d554fec8, 0x00000000d5550000)
  to   space 34944K,   0% used [0x00000000d1110000, 0x00000000d1110000, 0x00000000d3330000)
 tenured generation   total 699072K, used 212114K [0x00000000d5550000, 0x0000000100000000, 0x0000000100000000)
   the space 699072K,  30% used [0x00000000d5550000, 0x00000000e2474b88, 0x00000000e2474c00, 0x0000000100000000)
 Metaspace       used 2746K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 297K, capacity 386K, committed 512K, reserved 1048576K

串行1g 发生3次YongGc
并行 不执行-Xms参数，堆内存变小，容量小，发生FullGc的频率越高

```



## 1.4、使用CMS GC

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps  -XX:+UseConcMarkSweepGC -Xmx1g -Xms1g  jvm02.GCLogAnalysis

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps  -XX:+UseConcMarkSweepGC -Xmx512m -Xms512m  jvm02.GCLogAnalysis

```
正在运行
2021-11-14T19:43:17.315+0800: [GC (Allocation Failure) 2021-11-14T19:43:17.315+0800: [ParNew: 139776K->17470K(157248K), 0.0425732 secs] 139776K->47038K(506816K), 0.0446523 secs] [Times: user=0.03 sys=0.11, real=0.05 secs]
2021-11-14T19:43:17.434+0800: [GC (Allocation Failure) 2021-11-14T19:43:17.434+0800: [ParNew: 157246K->17472K(157248K), 0.1224024 secs] 186814K->91712K(506816K), 0.1248081 secs] [Times: user=0.16 sys=0.16, real=0.12 secs]
2021-11-14T19:43:17.621+0800: [GC (Allocation Failure) 2021-11-14T19:43:17.623+0800: [ParNew: 156964K->17472K(157248K), 0.0884351 secs] 231204K->138932K(506816K), 0.0906623 secs] [Times: user=0.09 sys=0.05, real=0.08 secs]
2021-11-14T19:43:17.764+0800: [GC (Allocation Failure) 2021-11-14T19:43:17.764+0800: [ParNew: 157142K->17472K(157248K), 0.0452333 secs] 278602K->174995K(506816K), 0.0468663 secs] [Times: user=0.03 sys=0.03, real=0.05 secs]
2021-11-14T19:43:17.874+0800: [GC (Allocation Failure) 2021-11-14T19:43:17.874+0800: [ParNew: 156880K->17472K(157248K), 0.0530335 secs] 314404K->213696K(506816K), 0.0535118 secs] [Times: user=0.17 sys=0.03, real=0.06 secs]
2021-11-14T19:43:17.934+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 196224K(349568K)] 216843K(506816K), 0.0007987 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-11-14T19:43:17.935+0800: [CMS-concurrent-mark-start]
2021-11-14T19:43:17.982+0800: [GC (Allocation Failure) 2021-11-14T19:43:17.982+0800: [ParNew: 157248K->17472K(157248K), 0.0505255 secs] 353472K->255864K(506816K), 0.0510633 secs] [Times: user=0.11 sys=0.03, real=0.05 secs]
2021-11-14T19:43:18.044+0800: [CMS-concurrent-mark: 0.055/0.106 secs] [Times: user=0.17 sys=0.03, real=0.11 secs]
2021-11-14T19:43:18.044+0800: [CMS-concurrent-preclean-start]
2021-11-14T19:43:18.046+0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-11-14T19:43:18.046+0800: [CMS-concurrent-abortable-preclean-start]
2021-11-14T19:43:18.084+0800: [GC (Allocation Failure) 2021-11-14T19:43:18.084+0800: [ParNew2021-11-14T19:43:18.148+0800: [CMS-concurrent-abortable-preclean: 0.001/0.101 secs] [Times: user=0.20 sys=0.00, real=0.12 secs]
: 157204K->17472K(157248K), 0.0913169 secs] 395597K->301222K(506816K), 0.0917293 secs] [Times: user=0.16 sys=0.00, real=0.09 secs]
2021-11-14T19:43:18.179+0800: [GC (CMS Final Remark) [YG occupancy: 20618 K (157248 K)]2021-11-14T19:43:18.180+0800: [Rescan (parallel) , 0.0028631 secs]2021-11-14T19:43:18.183+0800: [weak refs processing, 0.0002361 secs]2021-11-1
4T19:43:18.184+0800: [class unloading, 0.0019673 secs]2021-11-14T19:43:18.186+0800: [scrub symbol table, 0.0013412 secs]2021-11-14T19:43:18.187+0800: [scrub string table, 0.0005436 secs][1 CMS-remark: 283750K(349568K)] 304369K(506
816K), 0.0093456 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
执行结束，共生成对象次数：37242021-11-14T19:43:18.189+0800: [CMS-concurrent-sweep-start]

2021-11-14T19:43:18.191+0800: Heap
[CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-11-14T19:43:18.194+0800:  par new generation  [CMS-concurrent-reset-start]
2021-11-14T19:43:18.196+0800:  total 157248K, used 23414K[CMS-concurrent-reset: 0.001/0.001 secs] [0x00000000e0000000, 0x00000000eaaa0000, 0x00000000eaaa0000)
  eden [Times: user=0.00 sys=0.00, real=0.00 secs]
 space 139776K,   4% used [0x00000000e0000000, 0x00000000e05cd940, 0x00000000e8880000)
  from space 17472K, 100% used [0x00000000e9990000, 0x00000000eaaa0000, 0x00000000eaaa0000)
  to   space 17472K,   0% used [0x00000000e8880000, 0x00000000e8880000, 0x00000000e9990000)
 concurrent mark-sweep generation total 349568K, used 217402K [0x00000000eaaa0000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 2747K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 297K, capacity 386K, committed 512K, reserved 1048576K

512M时发生了CMS GC（出现CMS垃圾回收的6个标志）
GC时间优于串行和并行
```



## 1.5、使用G1 GC

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps  -XX:+UseG1GC -Xmx1g -Xms1g  jvm02.GCLogAnalysis

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps  -XX:+UseG1GC -Xmx512m -Xms512m  jvm02.GCLogAnalysis

java -XX:+PrintGC -XX:+PrintGCDateStamps  -XX:+UseG1GC -Xmx512m -Xms512m  jvm02.GCLogAnalysis

java -XX:+PrintGC -XX:+PrintGCDateStamps  -XX:+UseG1GC -Xmx256m -Xms256m  jvm02.GCLogAnalysis

```
正在运行
2021-11-14T19:48:49.562+0800: [GC pause (G1 Evacuation Pause) (young), 0.0126772 secs]
   [Parallel Time: 11.5 ms, GC Workers: 4]
      [GC Worker Start (ms): Min: 630.6, Avg: 630.7, Max: 630.9, Diff: 0.3]
      [Ext Root Scanning (ms): Min: 0.4, Avg: 1.3, Max: 3.7, Diff: 3.3, Sum: 5.3]
      [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
         [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 6.1, Avg: 9.1, Max: 10.5, Diff: 4.4, Sum: 36.3]
      [Termination (ms): Min: 0.0, Avg: 0.7, Max: 1.3, Diff: 1.3, Sum: 2.7]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 4]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.3]
      [GC Worker Total (ms): Min: 11.1, Avg: 11.2, Max: 11.2, Diff: 0.1, Sum: 44.8]
      [GC Worker End (ms): Min: 641.9, Avg: 641.9, Max: 642.0, Diff: 0.1]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.2 ms]
   [Other: 1.0 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.3 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.0 ms]
   [Eden: 25.0M(25.0M)->0.0B(21.0M) Survivors: 0.0B->4096.0K Heap: 30.0M(512.0M)->12.0M(512.0M)]
 [Times: user=0.00 sys=0.05, real=0.03 secs]
2021-11-14T19:48:49.619+0800: [GC pause (G1 Evacuation Pause) (young), 0.0784766 secs]
   [Parallel Time: 68.0 ms, GC Workers: 4]
      [GC Worker Start (ms): Min: 689.2, Avg: 705.2, Max: 752.1, Diff: 62.9]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.3, Max: 0.7, Diff: 0.7, Sum: 1.1]
      [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
         [Processed Buffers: Min: 0, Avg: 0.8, Max: 2, Diff: 2, Sum: 3]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.1]
      [Object Copy (ms): Min: 0.0, Avg: 14.6, Max: 33.3, Diff: 33.2, Sum: 58.5]
      [Termination (ms): Min: 0.0, Avg: 32.7, Max: 49.5, Diff: 49.5, Sum: 130.9]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 4]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 0.0, Avg: 47.7, Max: 65.8, Diff: 65.8, Sum: 190.8]
      [GC Worker End (ms): Min: 752.2, Avg: 752.9, Max: 755.0, Diff: 2.9]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 10.3 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 9.6 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.2 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.0 ms]
   [Eden: 21.0M(21.0M)->0.0B(21.0M) Survivors: 4096.0K->4096.0K Heap: 40.7M(512.0M)->22.2M(512.0M)]
 [Times: user=0.13 sys=0.00, real=0.09 secs]
2021-11-14T19:48:49.749+0800: [GC pause (G1 Evacuation Pause) (young), 0.0150851 secs]
   [Parallel Time: 10.7 ms, GC Workers: 4]
      [GC Worker Start (ms): Min: 822.6, Avg: 827.2, Max: 833.1, Diff: 10.6]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.2, Max: 0.5, Diff: 0.5, Sum: 1.0]
      [Update RS (ms): Min: 0.0, Avg: 0.6, Max: 1.4, Diff: 1.4, Sum: 2.3]
         [Processed Buffers: Min: 0, Avg: 1.0, Max: 3, Diff: 3, Sum: 4]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 0.0, Avg: 5.1, Max: 9.2, Diff: 9.2, Sum: 20.3]
      [Termination (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.3]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 4]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 0.0, Avg: 6.0, Max: 10.6, Diff: 10.6, Sum: 23.9]
      [GC Worker End (ms): Min: 833.2, Avg: 833.2, Max: 833.2, Diff: 0.0]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 4.3 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.9 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.0 ms]
   [Eden: 21.0M(21.0M)->0.0B(33.0M) Survivors: 4096.0K->4096.0K Heap: 50.0M(512.0M)->33.6M(512.0M)]
 [Times: user=0.02 sys=0.02, real=0.05 secs]
2021-11-14T19:48:49.840+0800: [GC pause (G1 Evacuation Pause) (young), 0.0292296 secs]
   [Parallel Time: 26.2 ms, GC Workers: 4]
      [GC Worker Start (ms): Min: 913.1, Avg: 918.3, Max: 923.6, Diff: 10.6]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.2, Max: 0.5, Diff: 0.5, Sum: 1.0]
      [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.2]
         [Processed Buffers: Min: 0, Avg: 1.0, Max: 3, Diff: 3, Sum: 4]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 7.8, Avg: 14.7, Max: 17.7, Diff: 9.9, Sum: 58.8]
      [Termination (ms): Min: 0.0, Avg: 5.8, Max: 7.9, Diff: 7.9, Sum: 23.3]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 4]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 15.5, Avg: 20.9, Max: 26.1, Diff: 10.5, Sum: 83.5]
      [GC Worker End (ms): Min: 939.1, Avg: 939.1, Max: 939.2, Diff: 0.0]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.1 ms]
   [Other: 3.0 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 2.3 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.1 ms]
      [Humongous Register: 0.1 ms]
      [Humongous Reclaim: 0.1 ms]
      [Free CSet: 0.0 ms]
   [Eden: 33.0M(33.0M)->0.0B(302.0M) Survivors: 4096.0K->5120.0K Heap: 74.4M(512.0M)->47.0M(512.0M)]
 [Times: user=0.05 sys=0.03, real=0.08 secs]
执行结束，共生成对象次数：1556
Heap
 garbage-first heap   total 524288K, used 350536K [0x00000000e0000000, 0x00000000e0101000, 0x0000000100000000)
  region size 1024K, 241 young (246784K), 5 survivors (5120K)
 Metaspace       used 2746K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 297K, capacity 386K, committed 512K, reserved 1048576K

G1 GC比较复杂，可以只打印PrintGC

正在运行
2021-11-14T19:51:01.153+0800: [GC pause (G1 Evacuation Pause) (young) 29M->11M(512M), 0.0231038 secs]
2021-11-14T19:51:01.262+0800: [GC pause (G1 Evacuation Pause) (young) 37M->19M(512M), 0.0148952 secs]
2021-11-14T19:51:01.324+0800: [GC pause (G1 Evacuation Pause) (young) 53M->30M(512M), 0.0144671 secs]
2021-11-14T19:51:01.387+0800: [GC pause (G1 Evacuation Pause) (young) 76M->48M(512M), 0.0173368 secs]
2021-11-14T19:51:01.668+0800: [GC pause (G1 Evacuation Pause) (young) 260M->121M(512M), 0.0696299 secs]
2021-11-14T19:51:01.761+0800: [GC pause (G1 Evacuation Pause) (young) 153M->129M(512M), 0.0179321 secs]
2021-11-14T19:51:01.855+0800: [GC pause (G1 Evacuation Pause) (young) 242M->163M(512M), 0.0355244 secs]
2021-11-14T19:51:01.995+0800: [GC pause (G1 Evacuation Pause) (young) 295M->203M(512M), 0.0368092 secs]
执行结束，共生成对象次数：2429

512M时只发生Yong GC
256M时发生Full GC
128M时发生大量Full GC最后内存溢出
G1 GC回收垃圾相对消耗时间最短

G1 GC可能发生退化串行化

GC时间明显优于其它串行、并行GC回收器
```

## 1.6、图形化工具gceasy.io

GC.log文件分析