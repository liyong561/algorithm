package artconcurrent.fundamentals.core_concurent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Client类，在生活中已经很熟悉了，比如支付宝账户。需要银行调用client的constructor，
 * 思考客户类应该是一个线程对象吗？
 * 对客户类进行建模和抽象。
 * */
public class Client {
    // id应该是唯一的，因为没有存储所有id的数据库，所以id由系统默认生成，id为String格式，也是一种可读的格式。
    private String id;
    private String name;
    private double total;
    // 同理，Date生成的时候使用了Date类，但是它展现给客户时可以是String对象，还记得那个生成日期的经典写法吗？
    // 这些优雅的代码片段，就是一个写好程序的养分。
    private String createDate;

    public Client(String name) {
        id = UUID.randomUUID().toString().replace("-","");
        this.name = name;
        // 发钱啦，默认每个账户存入1000元。
        total =1000;
        createDate = new SimpleDateFormat("YYYY-MM-DD").format(new Date());
        // 用户请求创建账户后，给用户返回唯一的id，用户可以据此查询。
        System.out.println("your id is : "+id);

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
