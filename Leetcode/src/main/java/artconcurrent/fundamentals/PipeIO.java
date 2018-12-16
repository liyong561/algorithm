package artconcurrent.fundamentals;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
/**
 * 管道输入流，主要用于线程传输，并且在内存中
 */
public class PipeIO {
    public static void main(String[] args) throws IOException{
        // Stream和Writer/Reader的差别，一种面向字符，一种面向字节。
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);  //一般IO操作都会抛出异常
        Thread printThread  =new Thread(new PrintThread(in), "The thfread name");
        int receive;
        while((receive=System.in.read())!=-1){ //enter+cmd+d终止输入。
            out.write(receive); // 写入管道中
        }
        printThread.start();
        out.close();

    }
    private static class PrintThread implements Runnable{
        private PipedReader in;
        // 继承Runnnable借口，也得有自己的方法。
        PrintThread(PipedReader in){
            this.in = in;
        }
        @Override
        public void run() {
            int receive; //默认初化为0
            try{
                // 从流中读取字符串的典型方式
                while ((receive=in.read())!=-1) {
                    // 中问乱码。
                    System.out.print((char) receive);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
