package com.amoscloud.newcoder.LeetCode;

import java.util.Scanner;

public class Climbstairs_fibo {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        int[] nums=new int[2];
        nums[0]=1;
        nums[1]=2;
        for(int i=2;i<n;i++){
            nums[i%2]+=nums[(i+1)%2];
        }
        System.out.println(nums[(n-1)%2]);

    }
}
