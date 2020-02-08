package core_java;

/**
 * enum和class一样也是关键字
 * 它的定义格式有什么不同？
 * enum适合只有固定几个对象的类，不如人分为男人和女人，那么实例可以通过类名来访问
 * enum的构造器默认就是私有的，就像interface的方法默认是public
 */
public class enumTest {
    public static void main(String[] args) {
        /**
         * enum中重写了toString方法，返回对象名
         */
        System.out.println(Person.e1);
        System.out.println(Person.e3.getDeclaringClass());
        System.out.println(Person.e1.compareTo(Person.e2));
        PersonClazz p = new PersonClazz("df");
        System.out.println(p);

    }
    public void sw(Person p){
        /**
         * enum和switch结合。
         */
        switch(p){
            case e1:
                System.out.println("ndn");
            case e2:
                System.out.println("cdc");
        }
    }
    public enum Person{
        e1("ss"),e2("ss"),e3;
        Person(){

        }
        Person(String type){
            this.type = type;

        }
        String type;
    }

    /**
     * 类属性和实例属性
     */
    public static class PersonClazz{
        String name;
        PersonClazz(String name ){
            this.name = name;
        }

    }
}
