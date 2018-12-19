package artconcurrent.fundamentals.core_concurent;

import java.util.ArrayList;

/**
 *Bank类，对现实生活中bank类的抽象，考验的是建模和抽象的能力。
 *Account账户，这个类主要用来处理账户的信息。
 *可以从功能入口：1.创建账户并存储。2.在账户间转账。3.取钱。4.存钱。5.查看银行的总存款。
 * 最好能画出系统图：
 * 注意事项：1.银行类应该为单例模式。2.可以看到，银行是个大对象，数据量会越来越多，大型系统估计只能使用数据库吧。
 * */
public class Bank {
    private static Bank bank=null;
    private double sum;
    private ArrayList<Client>  arr_client;
    private Bank(){
        arr_client = new ArrayList<>();
        //初始化操作。
    }
    /*
    也是一个工厂方法。
     */
    public static Bank getInstance(){
        if(bank ==null) {
            return new Bank();
        }
        return bank;
    }
    public boolean createAccount(String name){
        Client client =new Client(name);
        arr_client.add(client);
    }
    public boolean transfer(String fromId, String toId, double amount){
        Client from_client= null,to_client=null;
        // 简单来说，一个客户值增加，一个客户值减小，但是还有其他的情况。
        for(Client client:arr_client){
            if(client.getId()==fromId){
                from_client =client;
            }
            if (client.getId()==toId){
                to_client = client;
            }
        }
        if(from_client==null||to_client ==null){
            System.out.println("账户id非法");
            return false;
        }
        if(from_client.getTotal()<= amount) {
            System.out.println("账户余额不足");
            return false;
        }
        System.out.println(Thread.currentThread());
        from_client.setTotal(from_client.getTotal()-amount);
    }

}
