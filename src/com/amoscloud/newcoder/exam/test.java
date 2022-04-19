package com.amoscloud.newcoder.exam;

import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String s1="abe";
        StringBuilder temp=new StringBuilder(),temp2=new StringBuilder(s1);
        String s2="eiaboadaboo";

        int left=0,length=0,hasresult;
        String[] s1_c=s1.split("");
        //System.out.println(Arrays.toString(s1_c));
        while (left<s2.length()){
            hasresult=0;
            for (String c:s1_c){
                //System.out.println(c+","+s2.substring(left , left + 1));
                if (c.equals(s2.substring(left , left + 1))){
                    //System.out.println(c+","+s2.substring(left , left + 1));
                    if (temp.indexOf(c)!=-1&&temp2.indexOf(c)==-1) continue;
                    //System.out.println(temp+","+length);
                    length++;
                    temp.append(c);
                    temp2.deleteCharAt(temp2.indexOf(c));
                    hasresult=1;
                    break;
                }
            }
            if (hasresult==0) {
                //System.out.println("reset:"+temp);
                temp.delete(0,temp.length());
                temp2.delete(0,temp2.length());
                temp2.append(s1);
                length=0;
            }
            if (length==s1.length()){
                System.out.println(temp);
                System.out.println("true");
                break;
            }
            left++;
        }
        if (temp.length()==0) System.out.println("false");

    }
}
