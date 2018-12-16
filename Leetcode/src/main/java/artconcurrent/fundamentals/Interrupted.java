package artconcurrent.fundamentals;

/**
 *线程终端测试，一个busy线程，一个sleep线程。
 */
public class Interrupted {
    public static void main(String[] args) {
        Thread sleepThread =new Thread(new SleepThread(),"sleep thread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyThread(),"busy thread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            // sleep, 让两个子线程充分运行。
        }
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("Sleep Thread interrupted is "+sleepThread.isInterrupted());
        //查看中断位
        System.out.println("Busy Thread interrupted is "+busyThread.isInterrupted());
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            // sleep, 让两个子线程有时间退出。
        }

    }
    private  static class SleepThread implements Runnable{ // 不用创建对象，就有这个属性
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    private static class BusyThread implements Runnable{
        @Override
        public void run() {
            while (true){
                // do nothing,buy can't get out of it
            }
        }
    }
}
