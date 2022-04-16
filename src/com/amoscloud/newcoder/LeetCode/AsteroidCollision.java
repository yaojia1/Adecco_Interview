package com.amoscloud.newcoder.LeetCode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class AsteroidCollision {
    /*
    给定一个整数数组 asteroids，表示在同一行的行星。
    对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
    找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/asteroid-collision
     */
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int[] asteroids= Arrays.stream(inp.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack= new Stack<>();
        //stack.push(asteroids[0]);int fo=0;
        for (int i=0;i<asteroids.length;i++){
            if (stack.size()>0&&stack.peek()>0&&asteroids[i]<0){
                if (stack.peek()+asteroids[i]<=0) {
                    int k=stack.pop();
                    if (k+asteroids[i]==0) continue;
                    i--;
                }
            }else stack.push(asteroids[i]);
        }
        int[] a=stack.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(a));
    }
}
