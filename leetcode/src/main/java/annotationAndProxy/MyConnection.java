package annotationAndProxy;

public interface MyConnection {
    // MyConnection(int id); 接口中不存在构造器。
    Object get(); // 得到一个连接
    void speak(String content);
    int getId();
}
