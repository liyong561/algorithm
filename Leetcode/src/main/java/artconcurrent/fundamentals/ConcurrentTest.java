package artconcurrent.fundamentals;


/**
 * 单线程和多线程的执行效率上的测试，写一个比较好的multi-thread task。
 * 对a进行10000L次+5 ops，对b进行10000L进行-5，两个任务可并行，且不用同步。
 * 尽量使程序中没有飘黄的部分
 * a=500000000,b=-600000000,count=10亿
 * the serial time167ms
 * the concurrent time is 64ms
 * a=500000000
 * b=-600000000
 */
public class ConcurrentTest {
    // 可以看到10亿的时候，concurrent的优势显示出来了
    private static long count = 100000000L;

    public static void main(String[] args) {
        serial();
        concurrent();
    }
    private static void concurrent(){
        //建立两个线程，分别执行a和b的操作。
        long start = System.currentTimeMillis();   // type maybe primitive Long
        /*long a=0,b=0; 新建线程的变量和main线程的变量。
        Thread thread1 =new Thread(new Runnable() {
            @Override
            public void run() {
                long a =0;
                for(long i=0;i<count; i++){
                    a+= 5;
                }
                System.out.println("a="+a);
            }
            匿名对象的lambda表达式,可以比较，拿掉了对象名和方法名，使用了->符号
        });*/
        Thread thread1 = new Thread(()->{
            long a =0;
            for(long i=0;i<count; i++){
                a+=5;
            }
            System.out.println("a="+a);
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long b=0;
                for(long i=0;i<count;i++){
                    b-=6;
                }
                System.out.println("b="+b);
            }
        });
        Thread thread3 = new Thread(()->{
            long a =0;
            for(long i=0;i<count; i++){
                a+=5;
            }
            System.out.println("a="+a);
        });
        thread1.start();
        thread2.start();
        thread3.start();
        // 两个线程执行完了才会执行该操作。
        long end = System.currentTimeMillis();
        System.out.println("the concurrent time is "+(end -start)+"ms");

    }
    private static void serial(){
        // 函数中的局部变量不用modifier,该方法使用priavte修饰，是java开发规范。
        long start = System.currentTimeMillis();
        long a =0,b=0;
        for(long i=0;i<count;i++){
            a+= 5;
        }
        for(long i=0; i<count; i++){
            b-=6;
        }
        long end = System.currentTimeMillis();
        System.out.println("a="+a+",b="+b);
        System.out.println("the serial time"+(end-start)+"ms");  // not like python, can change it to string, has no comma

    }
}
