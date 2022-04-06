package com.amoscloud.newcoder.LeetCode;

import java.util.Scanner;

public class Binary_count {
    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
     *
     * 提示：
     * 请注意，在某些语言（如 Java）中，没有无符号整数类型。
     * 在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     * 在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
     */
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt(),count=0;
        /*
        while (n/2!=0){
            if (n%2==1) count++;
            n=n/2;
        }*/
        while (n!=0){
            count+=n&1;
            n>>>=1;
        }
        System.out.println(count);
        /**
         * 根据 与运算 定义，设二进制数字 nn ，则有：
         * 若 n \& 1 = 0n&1=0 ，则 nn 二进制 最右一位 为 00 ；
         * 若 n \& 1 = 1n&1=1 ，则 nn 二进制 最右一位 为 11 。
         *
         * 初始化数量统计变量 res = 0res=0 。
         * 循环逐位判断： 当 n = 0n=0 时跳出。
         *  res += n & 1 ： 若 n \& 1 = 1 n&1=1 ，则统计数 resres 加一。
         *  n >>= 1 ： 将二进制数字 nn 无符号右移一位（ Java 中无符号右移为 ">>>>>>" ） 。
         * 返回统计数量 resres 。
         *
         * ">>>"无符号右移
         * 操作规则：无论正负数，前面补零。
         *
         * ">>"右移
         * 操作规则：正数前面补零，负数前面补1
         *
         * "<<"左移
         * 操作规则：无论正负数，后面补零。
         *
         * 作者：jyd
         * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
         * 来源：力扣（LeetCode）
         */

    }
}
