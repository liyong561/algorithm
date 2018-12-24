package artconcurrent.fundamentals.core_concurent;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 使用并发的Executor框架，生成一个ExecutorServiced,就是线程池对象，程序员不用显示的创建Thread对象，而是创建实现了Runnable和Callable
 * 接口的对象。
 * 基本上就是不用我自己启动线程了，全部交给ExecuteService对象，我创建了对象，然后submit一下就可以了。
 * 自己多尝试一下独立思考。已有的类和要实现的功能，就是思考的材料，想想该怎么做。
 * Future<T> submit(Callable<T>):提交一个Callable对象，获得一个Callble对象，只不过这个Callable对象会返回我们想要的结果。
 */
public class ExecutorServiceTest {
    private static File file = new File("//Users//yongli//project");
    private static String keyWord = "concurrent";
    public static void main(String[] args) {
        MatchCounterExe mc = new MatchCounterExe(file, keyWord);
        FutureTask<Integer> ft =new FutureTask<>(mc);
        Thread t =new Thread(ft);
        t.start();
        try {
            System.out.println("the result is :" + ft.get());
        }catch (Exception e){

        }


    }
}

/**
 * ,MatchCounterExe已经不带有类型参数了。
 */
class MatchCounterExe implements Callable<Integer> {
    private File file;
    private Integer counter = 0;
    private String keyWord;
    private ExecutorService executorService;

    public MatchCounterExe(File file, String keyWord) {
        this.file = file;
        this.keyWord = keyWord;
        executorService = Executors.newCachedThreadPool();
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
        List<Callable<Integer>> results = new ArrayList<>();
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {

                MatchCounter matchCounter = new MatchCounter(file1, keyWord);
                // FutureTask<Integer> ft = new FutureTask<>(matchCounter);
                results.add(matchCounter);
            } else {
                if (search(file1)) counter++;
            }
        }
        // 搜集返回的结果,not Future
        // uture<Integer> futureResult= executorService.invokeAll(results);
        List<Future<Integer>> futureResult= executorService.invokeAll(results);
        for (Future<Integer> future : futureResult) {
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