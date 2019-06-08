package artconcurrent.fundamentals.core_concurent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUseCase {
    int atomI;
    public void useLock(){
        Lock lock =new ReentrantLock();
        // 这一句操作代表了很多的意思，当其他的线程块试图执行该代码块时，首先要获得许可证，然后才能获取。
        // 锁和代码块的相互分离。`1
        lock.lock();
        try{
            atomI++;

        }finally {
            lock.unlock();
        }
    }
}
