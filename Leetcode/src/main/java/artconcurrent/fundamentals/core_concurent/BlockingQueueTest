package artconcurrent.fundamentals.core_concurent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 使用阻塞队列，其实就是典型的生产者线程和消费者线程，bq是存取product的container
 * 使用阻塞队列的目的就是简化并发编程
 * 生产者:文件夹下所有文件写入bq。消费者：从队列中读取文件，并进行相关的操作，比如从文件中搜寻东西。
 * 读取文件夹下的所有文件
 */
public class BlockingQueueTest {
    private static String filePath ="F://project//algorithm//Leetcode//src//main//java//artconcurrent";
    private static String aimStr = "concurrent";
    private static BlockingQueue<File> bq =new LinkedBlockingDeque<>();
    public static void main(String[] args) {
        FileEnumerationTask fet = new FileEnumerationTask(bq, filePath);
        Thread fReader = new Thread(fet);
        fReader.start();
        SearchTask st =new SearchTask(bq, aimStr);
        for(int i=0;i<10;i++){
            // t算是临时变量吧。
            Thread t =new Thread(st,"thread "+i);
            t.start();
        }
    }

}
class FileEnumerationTask implements Runnable{
    public static File DUMMY =new File(""); //空文件。
    private BlockingQueue<File> bq;
    private File file;
    public FileEnumerationTask(BlockingQueue<File> bq,String filePath){
        this.bq= bq;
        this.file = new File(filePath);
    }
    @Override
    public void run() {
        try{
            product(file);
            bq.put(DUMMY);
        }catch (InterruptedException e){

        }

    }
    public void product(File file) throws InterruptedException{
        File[] files =file.listFiles();
        for (File file1:files) {
            if (file1.isDirectory()) {
                product(file1);
            }
            else{
                // put方法线程会发生阻塞。
                bq.put(file1);
                System.out.println("放入一个文件："+file1.getName());
            }
        }
    }
}

/**
 * 工作（消费）线程，从阻塞队列中取出product
 */
class SearchTask implements Runnable{
    private BlockingQueue<File> bq;
    private String aimStr;
    public SearchTask(BlockingQueue<File> bq, String aimStr){
        this.bq =bq;
        this.aimStr = aimStr;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    try {
        boolean flag = true;
        while (flag) {
            File file = bq.take();
            if (file== FileEnumerationTask.DUMMY){
                // 终止while循环，
                flag =false;
                bq.put(file);
               //  break;想想这里为什么不用break;
            }
            else{
                search(file,aimStr);
            }
        }
        }catch (Exception e){

    }
    }
    private void search(File file,String str) throws Exception{
        // FileReader fr =new FileReader(file);我记得有一个readline函数，但是这里没有啊，怎么回事，BufferReader
        // java IO读取惯用的手法就是装饰器模式。
        BufferedReader br= new BufferedReader(new FileReader(file));
        // 在读中文的时候有乱码
        String content;
        while ((content=br.readLine())!=null){
            if(content.contains(aimStr)){
                System.out.println(file.getPath()+content);
            }
        }
    }
}