package annotationAndProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * 动态代理，可以在运行时，生成特定类的对象。
 * newProxyInstance方法用来返回一个代理对象，这个方法总共有3个参数，ClassLoader loader用来指明生成代理对象使用哪个类装载器，
 * Class<?>[] interfaces用来指明生成哪个对象的代理对象，通过接口指定，InvocationHandler h用来指明产生的这个代理对象要做什么事情。
 * 所以我们只需要调用newProxyInstance方法就可以得到某一个对象的代理对象了。
 */
public class UseProxy {
    static MyConnectionImp mc =new MyConnectionImp(12,"China",new Date());
    public static void main(String[] args) {
        /*为某个接口生成了代理对象，但是并没有实现我想要的方法，是为什么呢 */
        MyConnection myConnectionProxy = (MyConnection)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class<?>[]{MyConnection.class},new ConnectionHandler());

        myConnectionProxy.speak("liyong should learn English quickly");
         //myConnectionProxy.get();

    }
    static class ConnectionHandler implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // args是某个函数的参数，proxy就是Proxy的对象
            System.out.println(proxy.getClass());
            System.out.println(method.getName());
            System.out.println(args.length);
            method.invoke(mc,args);  // 还是需要我持有这个类，why？
            return null;
        }
    }
}
