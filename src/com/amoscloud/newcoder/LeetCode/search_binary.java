package com.amoscloud.newcoder.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class search_binary {
    /**
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search
     * @param args
     */
    public static void main(String[] args) {
        /*
        给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
        写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
         */
        Scanner inp=new Scanner(System.in);
        int[] nums= Arrays.stream(inp.nextLine().split(",")).map(Integer::parseInt).mapToInt(Integer::intValue)
                .sorted()
                .toArray();
        int target=inp.nextInt();
        int len=nums.length/2,last=0,max=nums.length-1;
        while (nums[len]!=target){
            if (last==max-1||last==max){
                if(nums[last]==target) System.out.println(last);;
                if(nums[max]==target) System.out.println(max);;
                System.out.println("left:"+nums[last]+",mid:"+nums[len]+"right:"+nums[max]);
                System.out.println("-1");
                break;

            }
            if(nums[len]>target){
                max =len;
                len=(len-(len-last)/2);
            }else{
                last=len;
                len=len+(max-len)/2;
            }
            System.out.println("left:"+last+",  mid:"+len+"   right:"+max);
        }
        System.out.println(len);


    }
}
