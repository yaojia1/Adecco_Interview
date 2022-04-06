package com.amoscloud.newcoder.easy;

import java.util.*;
import java.util.stream.Collectors;

public class Q01 {
    /*
    最佳装载快递的货车
    题目描述：
    一辆运送快递的货车，运送的快递放在大小不等的长方体快递盒中，
    为了能够装载更多的快递，同时不能让货车超载，需要计算最多能装多少个快递。
    注意：
    快递的体积不受限制快递数最多 1000 个 ，货车载重最大 50000
    输入描述：
    第一行输入每个快递的重量
    用英文逗号隔开 如 5,10,2,11
    第二行输入货车的载重量，如 20
    输出描述：
    输出最多能装多少个快递，如 3
    Case
    输入
    5,10,2,11
    20
    输出
    3
     */


    public static void main(String[] args) {
        final int MAX_weight=50000;
        final int MAX_num=1000;
        Scanner inp = new Scanner(System.in);
        List<Integer> objs = Arrays.stream(inp.nextLine().split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxweight=inp.nextInt();
        inp.close();
        if(maxweight>MAX_weight||objs.size()>MAX_num){
            throw new IllegalStateException("Unexpected value: " + maxweight+", "+objs.size());
        }
        Collections.sort(objs);
        //System.out.println(Arrays.toString(objs.toArray()));
        int weight=0,num=0;

        for(Integer obj:objs){
            if(weight+obj>maxweight){
                System.out.println(num);
            }
            weight+=obj;
            num++;
        }

    }
}
