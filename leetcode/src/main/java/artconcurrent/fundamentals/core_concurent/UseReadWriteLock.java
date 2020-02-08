package artconcurrent.fundamentals.core_concurent;


import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 通过读写锁，将hashmap改造为线程安全的，很多变量设置为类变量，也就是使用类，可以不生成Object
 */
public class UseReadWriteLock {
    static HashMap<String,Object> map = new HashMap<>();

    static ReentrantReadWriteLock  rwl = new ReentrantReadWriteLock();
    static Lock rl = rwl.readLock();
    static Lock wl = rwl.writeLock();

    public final static Object get(String key){
        rl.lock();
        try{
            return map.get(key);
        }finally {
            rl.unlock();
        }
    }

    public final static Object put(String key,Object object){
        wl.lock();
        try{
            return map.put(key,object);
        }finally {
            wl.unlock();
        }
    }


}
