package artconcurrent.fundamentals.core_concurent;

import artconcurrent.fundamentals.Interrupted;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable和Future接口，Callable类似于Runable接口，但是不同之处是有返回值，Future对Callable进行了包装，获取最终结果。
 * 而FutureTask接口实现了这两个接口。
 * 这个程序以多线程的方式返回含有keyWord的文件的行数。
 */
public class FutureTest {
    private static File file = new File("//Users//yongli//project");
    private static String keyWord = "concurrent";

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new MatchCounter(file, keyWord));
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Integer counter = futureTask.get();
            System.out.println("the line number is :" + counter);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

/**
 * 这个类为什么要继承Callable接口？
 */
class MatchCounter implements Callable<Integer> {
    private File file;
    private Integer counter = 0;
    private String keyWord;

    public MatchCounter(File file, String keyWord) {
        this.file = file;
        this.keyWord = keyWord;
    }

    /**
     * 函数不用传入参数，直接使用对象的参数。应为很难向函数传入参数，可能递归是一个问题。
     * 通过创建对象，对象调用call方法，实现递归调用。
     *
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        List<FutureTask<Integer>> results = new ArrayList<>();
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {

                MatchCounter matchCounter = new MatchCounter(file1, keyWord);
                FutureTask<Integer> ft = new FutureTask<>(matchCounter);
                results.add(ft);
                // 将ft封装成一个线程，操作有点多
                Thread t = new Thread(ft);
                t.run();
            } else {
                if (search(file1)) counter++;
            }
        }
        // 搜集返回的结果,not Future
        for (Future<Integer> future : results) {
            counter += future.get();
        }
        return counter;
    }

    public boolean search(File file) {
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String content;
            while ((content = br.readLine()) != null) {
                if (content.contains(keyWord)) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
