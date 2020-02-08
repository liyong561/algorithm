package io_test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReadAndWrite {
    public static void main(String[] args) throws IOException {
        FileReadAndWriteTest fr = new FileReadAndWriteTest();
        System.out.println(fr.read("/Users/yongli/word.txt"));

    }

    /**
     * 先使用File定位到文件的位置，然后调用底层的方法实现
     */
     private static class FileReadAndWriteTest {
         String content;

        // 该方法将读取指定路径的文件，并将其转换为String对象返回
        public String read(String path) throws IOException {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            StringBuffer sb = new StringBuffer();
            char[] chars = new char[1024];// fileReader的方法一次只能读取这么多，就像喝水一样，一口一口地喝。
            // int i=1;  the assignment is redundant
            int i;
            while ((i=fileReader.read(chars)) != -1) {
                if(i<1024){
                    // java中没有分片，好难受哟。幸好借助Arrays工具类
                     // char[] chars1=new char[i];
                    char[] chars1=Arrays.copyOf(chars,i);
                    sb.append(chars1);
                    break;
                }
                    sb.append(chars); //换行符都读出来了，但是要清空一下。

            }
            content = new String(sb);
            return content;
        }

    }
}


