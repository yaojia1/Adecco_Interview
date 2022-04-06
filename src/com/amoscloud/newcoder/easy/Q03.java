package com.amoscloud.newcoder.easy;

import java.util.Arrays;
import java.util.Scanner;

public class Q03 {
    /* 题库同69
    【消除相邻且相同】
    题目描述：输入一个只包含英文字母的字符串，字符串中的俩个字母如果相邻且
    相同，就可以消除。在字符串上反复执行消除的动作，直到无法继续消除为止，
    此时游戏结束 。 输出最终得到的字符串长度。
    输入描述：
    原始字符串只能包含大小写英文字母，字母的大小写敏感，长度不超过
    100 。
    输出描述：
    输出游戏结束后字符串的长度
    。
    注意：
    输入中包含非大小写英文字母是均为异常输入，直接返回 0 。
    C
    ase
    输入：
    gg
    输出：
    0
    输入：
    mMbccbc
    输出：
    3
    说明：
    mMbcc （两个 c 消除） --> mMb b （两个 b 消除） --> mMc
     */
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        String str=inp.nextLine();
        inp.close();
        /*
        Arrays.stream(str.split("")).forEach(istr->System.out.println(
                istr.compareTo("A")+","+istr.compareTo("z")+","+istr.codePointAt(0)+
                        Arrays.toString(Character.toChars(istr.codePointAt(0) + 4))));*/
        boolean err=Arrays.stream(str.split("")).allMatch(//真麻烦!
                istr -> (istr.compareTo("A") >= 0 && istr.compareTo("Z") <= 0)
                        || ((istr.compareTo("z") <= 0) && (istr.compareTo("a") >= 0)));
        StringBuilder strs= new StringBuilder(str);
        if(!err) throw new IllegalStateException("0");//应该是reture 0
        int len=str.length();
        for (int i=0,j=1; j<len;i++,j++){
            //System.out.println(i+":"+strs.charAt(i)+","+j+""+strs.charAt(j));
            if (strs.charAt(i) == strs.charAt(j)) {
                strs.delete(i,j+1);
                i-=2;j-=2;len-=2;
            }
            if (i<0) break;
            //System.out.println(strs.toString());
        }
        System.out.println(strs.length());
    }

}
