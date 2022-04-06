package com.amoscloud.newcoder.LeetCode;

import java.util.*;

public class valid_parentheses {
    /**
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     */
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    有效字符串需满足：
    1. 左括号必须用相同类型的右括号闭合。
    2. 左括号必须以正确的顺序闭合。
     */
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        String in=inp.nextLine().split("\"")[1].trim();inp.close();
        System.out.println(in);
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');map.put('{','}');map.put('[',']');
        Stack<Character> s=new Stack<>();
        for (int i =0;i<in.length();i++){
            /*System.out.println("why"+s.size());
            System.out.println(i+","+!s.isEmpty());
            System.out.println(s.toString());
            System.out.println(map.get(s.peek()) +","+in.charAt(i));*/
            if (!s.isEmpty()){
                if (map.containsKey(s.peek())&&map.get(s.peek())==in.charAt(i)){
                    s.pop();
                }
            }else s.push(in.charAt(i));
        }
        System.out.println(s.isEmpty());
    }
}
