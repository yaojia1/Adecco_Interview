package com.amoscloud.newcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     *题目类型 常考 类型字符串处理、二分查找、深度优先搜索、广度优先搜索
     * 排序算法、单比大小
     * scanner
     * print string
     * list、map、hash map
     * 继承overwrite，接口。静态类、其他面对对象编程
     */

    public static void main(String[] args) {
        class vo {
            Map<Integer,Integer> used_places=new HashMap<>();
            Map<Integer,Integer> released_place=new HashMap<>();
            public void main() {
                final int MAX=100;
                Scanner inp=new Scanner(System.in);
                int n=Integer.parseInt(inp.nextLine());
                List<String> opration=new ArrayList<>();
                for(int i=0;i<n;i++){
                    opration.add(inp.nextLine());
                }
                inp.close();
                if (n>MAX||n<0){
                    System.out.println("error");
                }
                released_place.put(0,MAX);
                for (String ops:opration){
                    String[] tem=ops.split("=");
                    String op=tem[0];
                    int len=Integer.parseInt(tem[1]);
                    if (op.equals("REQUEST")){
                        if (!request(len)){
                            System.out.println("error");return;
                        }
                    }else {
                        if (op.equals("RELEASE")){
                            if (!release(len)){
                                System.out.println("error");return;
                            }
                        }
                        System.out.println("error");return;
                    }
                }
            }



            public Boolean request(int len){
                if (!used_places.containsKey(len)){
                    for (Map.Entry<Integer, Integer> p:released_place.entrySet().stream().sorted((o1 , o2) -> o1.getKey().compareTo(o2.getKey())).collect(Collectors.toList())){
                        //ystem.out.println(p.getKey()+","+p.getValue());
                        if (p.getValue()>=len){
                            used_places.put(p.getKey(),len);
                            System.out.println(p.getKey());
                            if (p.getValue()>len){
                                released_place.put(p.getKey()+len,p.getValue()-len);
                            }
                            released_place.remove(p.getKey());
                            return true;
                        }
                    }
                }
                return false;
            }
            public Boolean release(int index){
                if (used_places.containsKey(index)){
                    released_place.put(index,used_places.get(index));
                    used_places.remove(index);
                    return true;
                }
                return false;
            }
        }
        /*
        //algorithms.permutations
        Search_dfspermutations dfs=new Search_dfspermutations();
        dfs.main(nums); */
        //search_dfscombinations dfs=new search_dfscombinations();
        //dfs.main();
        /*
        Scanner in=new Scanner(System.in);
        List<Integer> numms= Arrays.stream(in.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int[][] nums=new int[3][3];
        for (int i=0;i<3;i++) for (int j=0;j<3;j++)nums[i][j]=numms.get(i+j);
        search_floodfill flood=new search_floodfill();
        List<List<Integer>> list=flood.floodFill(nums , 1 , 1 , 2);
        int i=0;
        System.out.println(nums.length+"?,"+nums[0].length);
        int[][] maps=new int[nums.length][nums[0].length];
        for (List<Integer> li : list){
            maps[i]=li.stream().mapToInt(Integer::intValue).toArray();
            i++;
        }
        for (List<Integer> ii:list) System.out.println(ii.toString());
        char a='2';
        System.out.println("2: "+Character.digit(a,1));
        System.out.println("2:: "+ Character.digit(a,10));
        Scanner in=new Scanner(System.in);
        String[] s=in.nextLine().split("@");
         */

        vo v=new vo();
        v.main();



    }
}
