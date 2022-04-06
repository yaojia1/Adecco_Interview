package com.amoscloud.newcoder.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class search_dfscombinations {
    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * https://leetcode-cn.com/problems/combinations/

     */
    public List<List<Integer>> list=new ArrayList<>();
    public List<Integer> temp=new ArrayList<>();
    public void main() {
        Scanner inp=new Scanner(System.in);
        Integer[] nums= Arrays.stream(inp.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        int n=nums[0],k=nums[1];
        this.combine(n,k);

        //System.out.println(Arrays.toString(this.list.toArray()));

    }
    public void combine(int n , int k) {
        for (int i=1;i<n+1;i++){
            this.temp.add(i);
        }
        DFS(new ArrayList<>(),k,0);
        //for (List<Integer> li:this.list) System.out.println(li.toString());

    }
    private void DFS(List<Integer> sublist,int k,int pos,int num){
        sublist.add(num);DFS(sublist,k,pos);
    }
    private void DFS(List<Integer> sublist,int k,int pos){
        if (k>0){
            int num=pos;
            //System.out.println("round "+j);
            while (num<temp.size()){
                System.out.println("blood "+num);
                int tempint=temp.get(num);
                temp.remove((int) num);
                //sublist.add(tempint);
                if (k==1){
                    list.add(new ArrayList<>(sublist.subList(0,sublist.size())));
                    list.get(list.size()-1).add(tempint);
                    System.out.println(list.get(list.size()-1).toString()+list.size());
                    temp.add(num,tempint);
                }else {
                    DFS(new ArrayList<>(sublist.subList(0,sublist.size())),k-1,num,tempint);
                    temp.add(num,tempint);
                }
                num++;
            }
        }
        sublist.clear();
    }
}
