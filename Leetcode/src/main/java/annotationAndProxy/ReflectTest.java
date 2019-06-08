package annotationAndProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 动态代理的底层就是reflect方法。
 */
public class ReflectTest {
    public static void main(String[] args) {
        /* 获取的是类对象信息 */
        Class<MyConnectionImp> clazz = MyConnectionImp.class;
        /* 获得了类修饰符 */
        int cModifiers= clazz.getModifiers();
        /*获取方法,protected,priavate方法都获取不到
        * public static对应9
        * */
        Method[] methods = clazz.getMethods();
        System.out.println("该类共有这么多方法："+methods.length);
        for (Method method:methods){
            System.out.println(method.getName());
            System.out.println(method.getModifiers());
        }

        int mModifiers = methods[3].getModifiers();
        String mName = methods[3].getName();

        System.out.println("cModifiers:"+cModifiers);
        System.out.println("mModifiers:"+mModifiers);
        System.out.println("methodName:"+mName);
        System.out.println("mModifiers:"+Modifier.STATIC);
        for(Method m:clazz.getDeclaredMethods()){
            System.out.println(m.getName());
        }
    }
}
