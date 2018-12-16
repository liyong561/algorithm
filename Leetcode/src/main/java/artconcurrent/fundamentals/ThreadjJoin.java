package artconcurrent.fundamentals;

/**
 * 一个线程要等其他线程返回，来批量生成线程对象,join怎么用？
 */
public class ThreadjJoin {
    public static void main(String[] args) {
        Thread[] threads=new Thread[10];
        Thread previous =Thread.currentThread();
        // 这这个结果说明了main线程并不是最后返回的线程。
        for(int i=0;i<10;i++){
            threads[i] =new Thread(new ThreadArrayUnit(i,previous),"the name");
            threads[i].start();
            previous =threads[i];
        }
        System.out.println("this is the main thread");

    }
    private static class ThreadArrayUnit implements Runnable{
        int i;
        Thread thread;
        ThreadArrayUnit(int i,Thread thread){
            this.i =i;
            // 一个对象持有另一个对象的引用
            this.thread = thread;
        }

        @Override
        public void run() {
            try{
            thread.join();
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("I am "+i+"th thread" );
        }
    }
}
