package com.amoscloud.newcoder.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search_dfspermutations {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * link: https://leetcode-cn.com/problems/permutations/
     * leetcode: medium
     */
    public List<List<Integer>> main(int[] nums) {
        /*
        给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
         */

        List<List<Integer>> list=new ArrayList<>();
        list=this.DFS(nums,list,new ArrayList<>());
        System.out.println(list.toString());
        return list;

    }
    private List<List<Integer>> DFS(int[] nums,List<List<Integer>> list, List<Integer> oldlist){
        if (nums.length>1){
            for (int i=0;i<nums.length;i++){
                System.out.println("nums + list \n"+ Arrays.toString(nums)+","+i);
                //切割数组
                int[] newnums=new int[nums.length-1];
                if (i >= 0) System.arraycopy(nums , 0 , newnums , 0 , i);
                //System.arraycopy(newnums,0,nums,0,i);
                for (int n=i+1;n<nums.length;n++) newnums[n-1]=nums[n];
                //System.arraycopy(newnums,i,nums,i+1,nums.length-i-1);
                //数字传入旧数组
                List<Integer> newlist = new ArrayList<>(oldlist);
                newlist.add(nums[i]);
                System.out.println("nums + list \n"+Arrays.toString(newnums));
                System.out.println(newlist.toString());
                list=DFS(newnums,list,newlist);
            }
        }
        if (nums.length==1){
            System.out.println(Arrays.toString(nums) +","+oldlist.toString());
            List<Integer> newlist = new ArrayList<>(oldlist);
            newlist.add(nums[0]);
            list.add(newlist);
            System.out.println(list.toString());
            return list;
        }
        return list;
    }
}
