package artconcurrent.fundamentals.core_concurent;

/**
 * 经典的等待通知模式，***，
 * WaitThread和NotifyThread，WaitThread执行一段时间后，会自己调用自己的等待方法，进入等待状态，并等待NotifyThread程序唤醒。
 * 比如早上妈妈叫你吃饭的模式，你饿了，但是可能你要等妈妈通知你饭做好了才能吃，这样理解真的很简单。
 * 注意点:调用wait和notify方法，都要获取锁对象，或者Syncronized，只有是同一个锁对象，才能唤醒。
 * 两个线程通过共享变量lock同步。
 */
public class WaitNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        ChildThread childThread = new ChildThread(obj);
        MomThread momThread = new MomThread(obj);
        childThread.start();
        momThread.start();

    }

    static class ChildThread extends Thread {
        Object lock;

        ChildThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public synchronized void run() {
            super.run();
            System.out.println("mom, I'm hungry,is there some food?");
            try {
                /* 没有持有该对象的锁，却调用了该方法*/

                synchronized (lock) {
                    lock.wait();
                }

            } catch (InterruptedException e) {
            }
            System.out.println("the food is delicious, thank you,mom");
        }
    }

    static class MomThread extends Thread {
        Object lock;

        MomThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("wait a minute, I'm cooking the food");
            System.out.println("it's OK");
            synchronized (lock) {
                lock.notifyAll();
            }
        }
    }

}
