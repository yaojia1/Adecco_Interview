package com.amoscloud.newcoder.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class stone_game {
    /*
    Alice 和 Bob 用几堆石子在做游戏。几堆石子排成一行，每堆石子都对应一个得分，由数组 stoneValue 给出。
    Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子 。比赛一直持续到所有石头都被拿走。
    每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0 。比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛也可能会出现平局。
    假设 Alice 和 Bob 都采取 最优策略 。如果 Alice 赢了就返回 "Alice" ，Bob 赢了就返回 "Bob"，平局（分数相同）返回 "Tie" 。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/stone-game-iii
     */

    /**
     * 倒过来的斐波那契，难在题解
     */
    public static void main(String[] args) {

        //对抗算法，a的收益大于b的最大收益
        Scanner inp = new Scanner(System.in);
        int[] stoneValue= Arrays.stream(inp.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        inp.close();
        //a的起始位置，计算最大优势
        int[] f=new int[stoneValue.length+1];
        f[stoneValue.length]=0;
        int pos=stoneValue.length-1;
        int round=1;
        while (pos>=0){
            f[pos]=select_stone(pos,stoneValue,f);
            System.out.println("round"+round+": "+ Arrays.toString(f));
            round+=1;
            pos--;
        }
        System.out.println(f[0]>0?"Alice":f[0]==0?"Tie":"Bob");
    }
    private static int select_stone(int pos,int[] stones,int[] f){
        int stone_sum=0;
        //int select_num=1;int max_inpro=stones.length>pos+3?stones[pos]-stones[pos+3]:stones[pos];
        int i=0;
        f[pos]=Integer.MIN_VALUE;
        while (stones.length>pos+i&&i<3){
            if (stones.length>pos+i){
                //每次收益=新增-其他人最大新增
                stone_sum+=stones[pos+i];
                f[pos]=Math.max(f[pos],stone_sum-f[pos+i+1]);
                System.out.println(f[pos]+"inpro by"+stones[pos+i]);
                //累计收益大于0
                i++;
            }
        }
        /*i=0;
        while (i<select_num) {
            stone_sum+=stones[pos+i];i++;
        }*/
        return f[pos];
    }

}
