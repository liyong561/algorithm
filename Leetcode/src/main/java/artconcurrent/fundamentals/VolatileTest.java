package artconcurrent.fundamentals;

/**
 * volatile修饰的变量对于所有线程都是可见的，（意思是当某个线程修改变量后，其他线程能够发现）
 * 创建两个线程，对同一个对象进行修改，考虑极端的情况。那么这个对象应该在main线程中。
 * 在创建线程对象的时候，线程的的操作已经定下来了
 * 如何显示普通变量和volatile变量的差别？
 */
public class VolatileTest {
    private static TV tv =new TV(123,"television",32.238f);
    public static void main(String[] args) {
        Thread thread1 =new Thread(()->{
           tv.setFactoryId(456);
           tv.setName("television01");
            System.out.println("thread1 output:"+tv.getFactoryId()+","+tv.getName());
        });
        Thread thread2 = new Thread(()->{
            TV tv1 =tv;  //先获得该引用。
            try {
                Thread.sleep(1000);// 静态方法
                // Thread.currentThread().sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            int factoryId =tv1.getFactoryId();
            String name =tv1.getName();
            System.out.println(factoryId+","+name);
        });
        thread2.start();
        thread1.start();
    }

}
/**
 * jdk中的类差不多都是工具类，少有实体类,找了一些也没找到。
 */
class TV{
    private volatile int factoryId;
    private String name;
    private float price;

    public TV(int factoryId, String name, float price) {
        this.factoryId = factoryId;
        this.name = name;
        this.price = price;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}