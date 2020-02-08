package artconcurrent.fundamentals.core_concurent;

/**
 * 没有同步的10个转账线程，分析他为什么会出现错误。
 * 10个转账线程中所使用的数据都是bank对象中的数据--client,
 * 1、线程读取一个数据副本，但是在操作副本的时候，副本数据并不是最新的，2.线程向对象中写入副本，修改了对象中的数据，覆盖了其他线程对其的数据。
 * 简言之，覆盖，就是一个线程的数据覆盖了另一个线程的数据。
 */
public class UnsynchBankTest {
    private static final  int initial=1000;
    private static final int threadN =100;
    public static void main(String[] args) {

        Bank bank=Bank.getInstance(initial);

        for(int i =0; i<threadN;i++) {
            // 创建了10个转账线程
            TransferRunnable transferRunnable = new TransferRunnable(bank);
            Thread t = new Thread(transferRunnable);
            t.start();
        }

    }
}
