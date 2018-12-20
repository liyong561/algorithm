package artconcurrent.fundamentals.core_concurent;

import sun.misc.Cleaner;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Bank类，对现实生活中bank类的抽象，考验的是建模和抽象的能力。
 * Account账户，这个类主要用来处理账户的信息。
 * 可以从功能入口：1.创建账户并存储。2.在账户间转账。3.取钱。4.存钱。5.查看银行的总存款。
 * 最好能画出系统图：
 * 注意事项：1.银行类应该为单例模式。2.可以看到，银行是个大对象，数据量会越来越多，大型系统估计只能使用数据库吧。
 */
public class Bank {
    private static Bank bank = null;
    //银行的统计数据。
    private double sum;
    private int number=0;
    private ArrayList<Client> arrClient;
    private Lock bankLock;
    private Condition sufficientCon;

    private Bank(int initial) {
        arrClient = new ArrayList<>();
        for(int i=0; i<initial;i++){
            this.createAccount(i+"acount");
        }
        // 一个对象排他性访问，只有一个锁，
        bankLock = new ReentrantLock();
        sufficientCon = bankLock.newCondition();
        //初始化操作。
    }

    /*
    也是一个工厂方法。
     */
    public static Bank getInstance(int initial) {
        if (bank == null) {
            return new Bank(initial);
        }
        return bank;
    }

    public boolean createAccount(String name) {
        Client client = new Client(name);
        arrClient.add(client);
        number++;
        return true;
    }

    public boolean transfer(String fromId, String toId, double amount) {
        // Java Camel, not python
        Client fromClient = null, toClient = null;
        // 简单来说，一个客户值增加，一个客户值减小，但是还有其他的情况。
        if(fromId.equals(toId)){
            System.out.printf("不能给自己转账");
            return false;
        }
        for (Client client : arrClient) {
            // not ==, 这个是数值型的比较
            if (client.getId().equals(fromId)) {
                fromClient = client;
            }
            if (client.getId().equals(toId)) {
                toClient = client;
            }
        }
        if (fromClient == null || toClient == null) {
            System.out.println("账户id非法");
            return false;
        }
        if (fromClient.getTotal() <= amount) {
            System.out.println("账户余额不足");
            return false;
        }
        System.out.println(Thread.currentThread());
        fromClient.setTotal(fromClient.getTotal() - amount);
        toClient.setTotal(toClient.getTotal()+ amount);
        return true;
    }
    // 重载transfer方法，系统根据参数类型，自动调用相应的方法。
    public boolean transfer(Client fromClient, Client toClient, double amount){
        bankLock.lock();
        try {

            double balance = fromClient.getTotal();
            if (fromClient == toClient) {
                System.out.println("不能给自己转账");
                return false;
            }
            if (balance <= amount) {
                System.out.println("账户余额不足");
                // 线程被阻塞。
                sufficientCon.await();
            }
            System.out.println(Thread.currentThread());
            /*
            try {
                Thread.sleep(100);
                // 整个转账过程耗时较长，给了其他线程在此时间内的操作。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            balance = fromClient.getTotal(); //就这句话，线程之前获得的数据，要刷新。
            fromClient.setTotal(balance - amount);
            toClient.setTotal(toClient.getTotal() + amount);
            sufficientCon.signalAll();
            // return true;这是try语句返回的。
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bankLock.unlock();
        }
        return true;
    }
    public  double getSum(){
        bankLock.lock();
        try {

            sum = 0;
            for (Client client : arrClient) {
                sum += client.getTotal();
            }
            return sum;
        }finally {
            bankLock.unlock();
        }

    }
    public int getNumber(){
        return number;
    }
    public Client getClient(int i){
        return arrClient.get(i);
    }

}
