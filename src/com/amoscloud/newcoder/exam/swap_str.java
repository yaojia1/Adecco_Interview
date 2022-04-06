package com.amoscloud.newcoder.exam;
import java.util.Scanner;
/**
 * Data: 2022/4/5 19:00 update
 * pass rate: 55%
 * problems:
 * 太冤了，明明看过原题看过答案，没动手觉得简单结果死活过不了、、、没测试用例甚至不知道往哪改，唯一知道的就是，一直在遍历比最小，其实可以等于a就跳出的。
 */
public class swap_str {
    /*Question description:
        给定一个字符串S
        变化规则：交换字符串中任意两个不同位置的字符
        输入描述：一串小写字母组成的字符串
        输出描述：按照要求变换得到最小字符串
        实例1：
         输入：abcdef
         输出：abcdef
        实例2：
         输入：bcdefa
         输出：acdefb
        说明：s都是小写字符组成
        1<=s.length<=1000
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        StringBuilder string=new StringBuilder(in.nextLine().trim());
        System.out.println(string.toString()+","+string.length());
        in.close();
        int temp1=0,temp2=0;
        for (int i=0;i<string.length()-1;i++){
            temp2=i;
            for (int j=i+1;j<string.length();j++){
                if (string.charAt(j)<string.charAt(temp2)){
                    temp2=j;
                }
            }
            if (temp2!=i){
                System.out.println(i+","+temp2);
                char tem=string.charAt(temp2);
                string.setCharAt(temp2,string.charAt(i));
                string.setCharAt(i,tem);
                break;
            }
            System.out.println(i+","+temp2);
        }
        System.out.println(string.toString());

    }
}
