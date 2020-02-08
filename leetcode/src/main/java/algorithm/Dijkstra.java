package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * create by yongli on 2019-10-19 21:40
 * 迪杰特斯拉算法
 * 从这个算法题就可以看到自己的编程和算法能力太差了，
 * 算法好应该是编程的基本功，这个牛逼，学什么框架就会很块，面试也有很大的优势
 */

public class Dijkstra {

    public static void main(String[] args) throws Exception {
        Integer[] nums= {23,1,32,4,1,4,4,4};
        int max=2;
        List<Integer> ls = getPath(Arrays.asList(nums),max);
        System.out.println(ls);
    }

    public static List<Integer>  getPath(List<Integer> nums, int max) throws Exception {
        // 为统一好看，索引和下标均从0开始，而不是1.
       // List<Integer> minPath = new ArrayList<>();
        int id =0;
       //  List<FixedNode> nodes = nums.stream().map((e) -> new FixedNode(e,max,id++)).collect(Collectors.toList());
        // 有id++,不能用lamda，用for也很快
        List<FixedNode> nodes = new ArrayList<>();
        for (int i =0;i<nums.size();i++){
            nodes.add(new FixedNode(nums.get(i),max,i));
        }
        int len = nodes.size();
        // 由线性表构造一个图
        for (int i=0;i<len;i++){
            for(int j =1 ;j< max+1;j++){
                if (i+j <len){
                    // 这句话话就是构建图的精髓
                    nodes.get(i).fixedNodes[j-1] = nodes.get(i+j);
                    nodes.get(i).len ++;
                }
            }
        }

        // 开始迪杰特斯拉算法,len= 0也会报错，边界条件
        int[] distance = new int[len]; // 尽量使用简单的数据结构，除非包装类非常合适。
        distance[0] = 0; // 自己到自己的代价为0
        for(int i= 1;i<len;i++){
            distance[i] = -1;  // 初始化为不可达
        }
        HashMap<Integer, List<Integer>> paths = new HashMap<>();
        paths.put(0,new ArrayList<>()); // 第一个是空的。
        List<FixedNode> in = new ArrayList<>();
        in.add(nodes.get(0)); // 先把自己加入
        int circleIdx =0;
        // 有时候真的不可达
        // distance[len-1] != -1 已经可达则退出，do while的区别
        while (distance[len-1] == -1 || circleIdx > len){

            circleIdx ++;
            //Map<FixedNode,Integer> candidates =new TreeMap<>(); // key是没有重复的。
            int costMin = Integer.MAX_VALUE;
            int idLocal = -1 ; // -1通常表示没有
            int idBefore = -1;
            for (FixedNode node : in){ // 可达的点,从in集合边缘寻找
                int nm= node.len; // 这个是最大的连接数，有些要记录实际的数据。int nm = node.fixedNodes.length;
                for (int i =0; i<nm ;i++){
                    //int idLocal = node.fixedNodes[i].id;
                    // null pointer
                    // 检查一下对象
                    if ( node.fixedNodes[i].value != -1 && !in.contains(node.fixedNodes[i])){
                       //   candidates.add(node.fixedNodes[i]); // 保存两个节点信息，没有现成的容器，就地处理算了
                        int cost = distance[node.id] + node.fixedNodes[i].value;
                        if (cost < costMin){
                            costMin =cost ;
                            idLocal = node.fixedNodes[i].id;
                            idBefore = node.id;
                        }
                    }
                }

            }
            if (idLocal != -1 ){
                distance[idLocal] = costMin;
                in.add(nodes.get(idLocal));
                List<Integer> curPath = new ArrayList<>(paths.get(idBefore));
                // System.out.println(curPath);
                curPath.add(idLocal);
                paths.put(idLocal,curPath);
            }
        }
        if (circleIdx >= len){
            System.out.println("the end is not access");
            throw new Exception("the end is not access");
        }
        // 要求返回到达终点的路径，只记录了distance，没有记录。
        System.out.println(distance[len-1]);
        System.out.println("circleIdx:"+circleIdx);
        return paths.get(len-1) ;
     }

    /**
     *
     * @param nodes 有没有环
     * @return
     */
     public static boolean hasLoop(List<FixedNode> nodes){
                                       ///////////////////////////////////////////////////////////////////////////////////

         return  false;
     }


}
class FixedNode{
    // 为了简洁,这里不用private修饰，各个属性在需要访问时都可以访问，加入访问权限是非常容易的。
    // 用什么来唯一标志这个node？
    int value;
    int max;
    int id;
    int len;
    FixedNode[] fixedNodes; // 有length，不需要idx；

    public FixedNode(int value, int max,int id){
        this.value =value;
        this.max = max;
        this.id =id;
        fixedNodes = new FixedNode[max];
    }

}


