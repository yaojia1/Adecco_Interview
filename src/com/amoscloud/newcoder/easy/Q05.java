package com.amoscloud.newcoder.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q05 {
    public static void main(String[] args) {
        /*
        【 找 出最小绝对值 】
        题目描述：
        已知连续正整数数列 {K}=K1 ,K2 ,K3 …Ki 的各个数相加之和为 Si=N(0<S<100000, 0<N<100000), 求此数列 K 。
        输入描述：
        输入包含两个参数，
        1）连续正整数数列和 S 2）数列里数的个数 N 。
        输出描述：
        如果有解输出数列K ，如果无解输出1。
        Case
        输入：
        525 6
        输出：
        85 86 87 88 89 90
        说明：
        85+86+87+88+89+90=525 ，且连续正整数列个数为 6
         */
        Scanner inp=new Scanner(System.in);
        Integer[] input= Arrays.stream(inp.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        inp.close();
        //System.out.println(Arrays.toString(input)+","+input[0]%input[1]);
        if (input.length!=2||input[0]>100000||input[0]<0||input[1]>100000||input[1]<0
                ||(input[0]%input[1]*2!=input[1]
                &&input[0]%input[1]!=0)) {
            System.out.println("1");
            return;
        }
        int start,end;
        if (input[0]%input[1]!=0){
            start=input[0]/input[1]-input[1]/2+1;
            end=input[0]/input[1]+input[1]/2+1;
        }else {
            start=input[0]/input[1]-input[1]/2;
            end=input[0]/input[1]+input[1]/2+1;
        }
        System.out.println(Arrays.toString(IntStream.range(start , end)
                .boxed().toArray()));
    }
}
