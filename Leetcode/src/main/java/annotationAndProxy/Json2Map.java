package annotationAndProxy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @date 2019/6/5
 * @author yongli
 */
public class Json2Map {
    public static void main(String[] args) {
        String js = "{\"student\":[\"wangfei\",\"liming\",\"liyong\"]}";
        String js1 = "{\n" +
                "\"name\":\"网站\",\n" +
                "\"num\":3,\n" +
                "\"sites\":[ \"Google\", \"Runoob\", \"Taobao\" ]\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(js1);
        System.out.println(jsonObject.get("sites"));
        Map<String, Object> map = parseJSON2Map(js1);

        System.out.println(map.get("sites"));

    }
    public static Map<String, Object> json2Map(String json){
        JSONObject js = JSONObject.parseObject(json);
        Map<String, Object> map = new HashMap<>();
        // 想过没有，k的类型为什么是Object，而不是一般的类
        for (String k:js.keySet()){
            Object v = js.get(k);
            // 遇到嵌套的情况,完全自己写还真有点不会。两层嵌套循环，有点复杂了,普通的都能解析出来。
            if ( v instanceof JSONArray){
                List<Map<String, Object>> map1 = new ArrayList<>();
                Iterator<Object> it = ((JSONArray) v).iterator();
                while (it.hasNext()){
                    Object obj = it.next();
                    map1.add(json2Map(obj.toString()));
                }
                map.put(k,map1);
            }
            else {
                map.put(k, v);
            }
        }
        return map;

    }
    public static Map<String, Object> parseJSON2Map(String jsonStr){
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject json = JSONObject.parseObject(jsonStr);
        for(Object k : json.keySet()){
            Object v = json.get(k);
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    Object json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }}
