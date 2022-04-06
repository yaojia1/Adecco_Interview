package com.amoscloud.newcoder.easy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Q02 {
    /**
     * data: 2022.4.5 12.14
     * 我竟然做出来了！！昨晚死活做不出来，今天看例题大概Q72？get到了.entryset.stream.sorted.tolist用法，foreach妙用，谢谢大佬
     */
    /*
        这特么什么鬼看不懂！！！！！
        【取相同字母最长的子串】
        题目描述：给定一个字符串，只包含大写字母，求在包含同一字母的子串中，
        长度第 k 长的子串的长度，相同字母只取最长的那个子串。
        输入描述：
        第一行有一个子串(长度 <= 100)，只包含大写字母
        第二行为 k 的值。
        输出描述：
        输出连续出现次数第 k 多的字母的次数。
        Case
        输入：
        AABAAA
        2
        输出：
        1
        说明：
        同一字母连续出现最多的
        A 3 次
        第二多 2 次 但 A 出现连续 3 次 。
        输入：
        AAAAHHHBBCDHHHH
        3
        输出：
        2
        说明：
        同一字母连续出现的最多的是A和H4次
        第二多的是HH，3次
         */
    /**
     * -17 -11 -7 -5 -3 0 2 9 11 21
     */
    public static void main(String[] args) {
        class ch{
            String id;
            List<Integer> times;
            public ch(String id){
                this.id=id;
                this.times=new ArrayList<>();
            }
            public void count(){
                times.set(times.size()-1,times.get(times.size()-1)+1);
            }
            public void accounts(){
                times.add(1);
            }

            public String getId() {
                return id;
            }

            public int getlength() {
                Collections.sort(times);
                return times.get(times.size()-1);
            }
            public int getTimes(){
                return times.size();
            }
        }
        Scanner inp=new Scanner(System.in);
        String[] s= inp.nextLine().split("");
        AtomicInteger k= new AtomicInteger(inp.nextInt());
        LinkedHashMap<String,ch> map=new LinkedHashMap<>();
        //List<ch> chars=new ArrayList<>();
        int count;
        for (int i=0;i<s.length;i++){
            System.out.println(s[i]);
            System.out.println(Arrays.toString(map.keySet().toArray())+","+map.containsKey(s[i]));
            if (!map.containsKey(s[i])){
                map.put(s[i], new ch(s[i]));
                //System.out.println(map.get(s[i]).getlength());
            }
            map.get(s[i]).accounts();
            //count=1;
            while (i+1<s.length&& s[i + 1].equals(s[i])){
                map.get(s[i]).count();
                i++;
            }
        }
        List<Map.Entry<String,ch>> map2=map.entrySet().stream()
                .sorted(((o1 , o2) ->
                        o1.getValue().getlength()==o2.getValue().getlength()?
                                o1.getKey().compareTo(o2.getKey())
                                :o2.getValue().getlength()-o1.getValue().getlength()))
                .collect(Collectors.toList());
        map2.forEach((l)->{
            k.set(k.get() - l.getValue().getTimes()+1);System.out.print(l.getKey());
            });
        System.out.println("\n"+map2.get(k.get() -1).getValue().getTimes());
    }
}
