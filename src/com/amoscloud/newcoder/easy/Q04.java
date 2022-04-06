package com.amoscloud.newcoder.easy;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Q04 {
    /**
     * 写了太久，不复杂但折腾
     * @param args
     */
    /*同68（main76）
        【 找出最小绝对值 】
        题目描述：
        给定一个随机的整数数组（可能存在正整数和负整数） nums 请你在
        该数组中找出两个数，其和的绝对值（ （|nums[x]+nums[ y]|）为最小值 并返回
        这个最小值 。 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
        输入描述：
        一个通过空格空格分割的有序整数序列字符串，最多1000 个整数，且整数数值范围是 [-65535,65535] 。
        输出描述：
        两个数和两数之和绝对值。
        注意：
        注意：输入中包含非大小写英文字母是均为异常输入，直接返回输入中包含非大小写英文字母是均为异常输入，直接返回0。
        Case：
        输入：
        -3 -1 5 7 11 15
        输出：
        2
        说明：
        -3 和 5 相加为 2 ，其绝对值为最小
         */
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        List<Integer> nums= Arrays.stream(inp.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        inp.close();
        if(!nums.stream().allMatch(integer -> integer<=65535 && integer>=-65535)||nums.size()<=0){
            System.out.println(0);
            return;
        }
        if (nums.size()==1) {
            System.out.println(nums.get(0));return;
        }
        nums.sort(Comparator.comparing(a->a));
        System.out.println(Arrays.toString(nums.toArray()));
        if (nums.get(0)>=0) System.out.println(nums.get(0)+nums.get(1));
        if (nums.get(nums.size()-1)<=0) System.out.println(nums.get(nums.size()-2)+nums.get(nums.size()-1));
        int i=0,j=nums.size()-1;
        int numadd=Math.abs(nums.get(i)+nums.get(j));
        int temp;
        ArrayList<Integer> minnum=new ArrayList<>();
        while (i<j && j<nums.size()){
            numadd=Math.abs(nums.get(i)+nums.get(j));
            temp=Math.abs(nums.get(i)+nums.get(j-1));
            System.out.println(i+","+j+","+numadd+","+temp);
            if (numadd==0){
                System.out.println(0);return;
            }
            if (i+1==j&&j<nums.size()){
                minnum.add(numadd);
                j=nums.size()-1;i++;continue;
            }
            //right=Math.abs(nums.get(i+1)+nums.get(j))
            if (temp<=numadd){
                j--;
            }else {
                j++;i++;
                minnum.add(numadd);
            }
        }
        minnum.sort(Comparator.comparing(a->a));
        System.out.println(Arrays.toString(minnum.toArray()));
        System.out.println(minnum.get(0));
        //return 0;
    }
}
