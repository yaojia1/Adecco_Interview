package com.amoscloud.newcoder.exam;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Data: 2022/4/5 20:30 update
 * pass rate: 55%
 * problems:
 * 1. 忘了考虑0和负数的情况了，但题目好像说正整数啊，看题的时候也没注意能跳特定步长还是最大步长。。。
 * 2. 我一直给的范围是nums[0]和length/2的最小值，忘了数组长度2的情况了，还有nums[0]是不是应该加一？毕竟位置可以等于0+步长
 * 3. 测试了一下输入一个数忘记return了，除了输出0还输出了-1、、、、、、
 */
public class Step {
    /*
     题目描述 ：
     给出一组正整数，你从第一个数向最后一个数方向跳跃，每个数的值表示你从这个位置可以跳跃的长度，第一次可以选跳跃的范围：1到所给长度的格但要小于一般总长。
     计算如何以最少的跳跃次数跳到最后一个数。
     输入描述:
     第一行表示有多少个数n
     第二行开始依次是1到n个数，空格分开；
     输出描述:
     输出一行，表示最少跳跃的次数。无法到达输出-1。
     别人的题是步长一直可选，比我这个计算时间要长，思路大概是做个DFS？每次写dfs我都要好久、、、、
    */
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int[] nums= Arrays.stream(inp.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        if (nums.length<1||nums.length>100){
            System.out.println(-1);
            return;
        }
        if (nums.length==1) System.out.println(0);
        inp.close();
        int max=Math.min(nums[0],nums.length/2+nums.length%2);
        int[] steps=new int[max];
        int step=1,pos;
        steps[0]=100;
        for (int i=1;i<max;i++){
            steps[i]=100;
            pos=i;
            while (pos<nums.length){
                if (pos==nums.length-1){
                    steps[i]=step;break;
                }
                pos+=nums[pos];
                step++;
            }
            step=1;
        }

        for (int ss:steps){
            if (ss<steps[0]) steps[0]=ss;
        }
        //Arrays.sort(steps);

        if (steps[0]==100) steps[0]=-1;
        //System.out.println(Arrays.toString(steps));
        System.out.println(steps[0]);

    }
}
