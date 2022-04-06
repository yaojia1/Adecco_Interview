package com.amoscloud.newcoder.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Iteration_Fibonacci {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
     */
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt(),len;
        final int MOD = 1000000007;
        inp.close();
        List<Integer> fib=new ArrayList<>();
        fib.add( 0);fib.add(1);fib.add(3);
        for (int i=2;i<n+1;i++){
            //len=i%3;
            fib.set(i%3,(fib.get((i-1)%3)+fib.get((i-2)%3))%MOD);
        }
        /*
        long top=fib.get(fib.size()-1);
        int x=0,y= (int) (top%10);
        while (top>=10){
            top=top/10;
            y= (int) (top%10);
            x+=1;
        }*/
        System.out.println(fib.get(n%3));
        /*
        if (x==9&&y==8) System.out.println(-1);
        else if (x<1) System.out.println(fib.get(fib.size()-1));
        else System.out.println(top+"e"+x+"+"+y);
*/
    }
}
