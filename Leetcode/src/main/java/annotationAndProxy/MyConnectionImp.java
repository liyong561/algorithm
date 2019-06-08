package annotationAndProxy;

import java.util.Date;

/**
 * 这个Connection类是对很多工具类的抽象，比如数据库连接，等抽象
 */
public class MyConnectionImp implements MyConnection {

    private int id;
    private String name;
    private Date date;
    /* 不给空构造器，因为我要求创建该对象时，必须给对象域赋值*/
    public MyConnectionImp(int id, String name, Date date) {

        this.id = id;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public static String getName() {
        return "liyong";
    }

    private Date getDate() {
        return date;
    }

    @Override
    public Object get() {
        Object obj = new Object();
        return obj;
    }

    @Override
    public void speak(String content) {
        System.out.println(content);
        System.out.println("I'm come from MyConnectionImp, and I have nothing to say");
    }
}
