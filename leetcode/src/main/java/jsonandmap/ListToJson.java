package jsonandmap;

import java.util.*;


/**
 * create by yongli on 2019-06-06 23:46
 */

public class ListToJson {
    /**
     * @param args
     */
    public static void main(String[] args) {
        randomStringMap();

    }
    public static void randomStringList(){
            String ts ="1234567890qwertyiopwert";
            int len = ts.length();

            List<String>  ls = new ArrayList<>();
            for (int i=0; i<10; i++){
                StringBuffer bf = new StringBuffer();
                for(int j =0; j<12; j++){
                    Random random = new Random();
                    int idx = random.nextInt(len);
                    // str.index,和charAt相反。
                    bf.append(ts.charAt(idx));
                }
                String st = new String(bf);
                ls.add(st);
            }
            System.out.println(ls.toString());

    }
    public static void randomStringMap(){
        String ts ="1234567890qwertyiopwert";
        int len = ts.length();

        Map<String,String> map = new HashMap<>();
        for (int i=0; i<10; i++){
            StringBuffer bf = new StringBuffer();
            for(int j =0; j<12; j++){
                Random random = new Random();
                int idx = random.nextInt(len);
                // str.index,和charAt相反。
                bf.append(ts.charAt(idx));
            }
            String st = new String(bf);
            map.put(i+"",st);
        }
        System.out.println(map.toString());

    }

}
