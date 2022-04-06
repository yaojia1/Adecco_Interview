package com.amoscloud.newcoder.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q84 {
    /*
     小组中每位都有一张卡片
     卡片是6位以内的正整数
     将卡片连起来可以组成多种数字
     计算组成的最大数字
     输入描述：
       ","分割的多个正整数字符串
       不需要考虑非数字异常情况
       小组种最多25个人
     输出描述：
        最大数字字符串
     示例一
        输入
         22,221
        输出
         22221
     示例二
        输入
           4589,101,41425,9999
        输出
           9999458941425101
   */
    public static void main(String[] args) {
        Scanner inp= new Scanner(System.in);
        List<String> ids= Arrays.stream(inp.nextLine().split(",")).sorted((Comparator<String>) (o1 , o2) -> {
            int o1len = o1.length(), o2len = o2.length();
            int temp1, temp2;
            for (int i = 0; i < o1.length() + o2.length(); i++) {
                if (i >= o1len) {
                    temp1 = o2.charAt(i - o1len);
                } else temp1 = o1.charAt(i);
                if (i >= o2len) {
                    temp2 = o1.charAt(i - o2len);
                } else temp2 = o2.charAt(i);
                if (temp1 == temp2) continue;
                return temp2 - temp1;
            }
            return 0;
        }).collect(Collectors.toList());
        /*
        原来分开的
        List<String> ids= Arrays.stream(inp.nextLine().split(","))
                .collect(Collectors.toList());
        //System.out.println(Arrays.toString(ids.toArray()));
        ids.sort((Comparator<String>) (o1 , o2) -> {
            int o1len=o1.length(),o2len=o2.length();
            int temp1,temp2;
            for (int i=0;i<o1.length()+o2.length();i++){
                if (i>=o1len){
                    temp1=o2.charAt(i-o1len);
                }else temp1=o1.charAt(i);
                if (i>=o2len){
                    temp2=o1.charAt(i-o2len);
                }else temp2=o2.charAt(i);
                if (temp1==temp2) continue;
                return temp2-temp1;
            }
            return 0;
        });
         */
        //System.out.println(Arrays.toString(ids.toArray()));
        ids.forEach(System.out::print);
    }
}
