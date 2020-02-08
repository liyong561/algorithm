package artconcurrent.fundamentals.core_concurent;

import java.util.Random;

/**
 * 交易线程，在随机生成的账户间交易，在main函数中运行此线程。
 */
public class TransferRunnable  implements Runnable{
    private Bank bank;
    private int DELAY=10;
    public TransferRunnable(Bank bank){
        this.bank = bank;
    }
    @Override
    public void run() {
        try{
            while (true){
                int num =bank.getNumber();
                int from = (int)(num* Math.random());
                int to = (int)(num*Math.random());
                Client fromClient = bank.getClient(from);
                Client toClient  = bank.getClient(to);
                // int值隐式转换为double
                double amount = new Random().nextInt(100)+400;
                bank.transfer(fromClient, toClient, amount);
                // 查看转账是否出现错误。
                System.out.println("银行总存款为： "+bank.getSum());
                // sleep方法会抛出中断异常。
                Thread.sleep((int)(DELAY*Math.random()));
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
