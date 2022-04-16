package com.amoscloud.newcoder.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Generate_parentheses {
    /*
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public static void main(String[] args) {
        class Generate_method{
            public List<String> parentheses=new ArrayList<>();
            public Generate_method(int n){
                //
                char[] list=new char[n*2];
                generateParenthesis(n,1,list,0);
                System.out.println(parentheses.toString());
            }
            public void generateParenthesis(int n,int loop,char[] list,int count) {
                System.out.println(loop+": "+ Arrays.toString(list)+(count>loop-count)+(loop-count));
                if (count<n){//左括号小于n个
                    list[loop-1]='(';
                    generateParenthesis(n,loop+1,list,count+1);
                }
                if (count>=loop-count){//右括号小于左括号个数
                    list[loop-1]=')';
                    System.out.println(Arrays.toString(list) +","+count+",右："+(loop-count));
                    if (loop!=2*n){
                        generateParenthesis(n, loop +1, list ,count);
                    }
                    else{
                        /*StringBuilder str=new StringBuilder();
                        for (char c: list) str.append(c);*/
                        parentheses.add(new String(list));
                        System.out.println(Arrays.toString(list) +"end");
                    }
                }
                //if (loop==n*2) System.out.println("end,"+count);
            }
        }
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        inp.close();
        Generate_method path=new Generate_method(n);


    }
}
