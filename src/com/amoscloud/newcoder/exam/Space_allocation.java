package com.amoscloud.newcoder.exam;

import java.util.*;
import java.util.stream.Collectors;
/**
 * Data: 2022/4/5 20:30 update
 * pass rate: 50%
 * problem: 被切割的空间忘记合并了，竟然能过50%也是谢谢写测试的了！
 */
public class Space_allocation {
    /* Question description:
      请实现一个简易内存池,根据请求命令完成内存分配和释放。
      内存池支持两种操作命令，REQUEST和RELEASE，其格式为：
      REQUEST=请求的内存大小 表示请求分配指定大小内存，如果分配成功，返回分配到的内存首地址；如果内存不足，或指定的大小为0，则输出error。
      RELEASE=释放的内存首地址 表示释放掉之前分配的内存，释放成功无需输出，如果释放不存在的首地址则输出error。
      注意：
      1.内存池总大小为100字节。
      2.内存池地址分配必须是连续内存，并优先从低地址分配。
      3.内存释放后可被再次分配，已释放的内存在空闲时不能被二次释放。
      4.不会释放已申请的内存块的中间地址。
      5.释放操作只是针对首地址所对应的单个内存块进行操作，不会影响其它内存块。
      解答要求
      时间限制: 1000ms, 内存限制: 256MB
      首行为整数 N , 表示操作命令的个数，取值范围：0 < N <= 100。
      接下来的N行, 每行将给出一个操作命令，操作命令和参数之间用 “=”分割。
     */

    static class Disk_manage {
        Map<Integer,Integer> used_places=new HashMap<>();
        Map<Integer,Integer> released_place=new HashMap<>();
        public void main() {
            final int MAX=100;
            Scanner inp=new Scanner(System.in);
            int n=Integer.parseInt(inp.nextLine());
            List<String> opration=new ArrayList<>();
            for(int i=0;i<n;i++){
                opration.add(inp.nextLine());
            }
            inp.close();
            if (n>MAX||n<0){
                System.out.println("error");
            }
            released_place.put(0,MAX);
            for (String ops:opration){
                String[] tem=ops.split("=");
                String op=tem[0];
                int len=Integer.parseInt(tem[1]);
                if (op.equals("REQUEST")){
                    if (!request(len)){
                        System.out.println("error");return;
                    }
                }else {
                    if (op.equals("RELEASE")){
                        if (!release(len)){
                            System.out.println("error");return;
                        }
                    }
                    System.out.println("error");return;
                }
            }
        }



        public Boolean request(int len){
            if (!used_places.containsKey(len)){
                for (Map.Entry<Integer, Integer> p:released_place.entrySet().stream().sorted((o1 , o2) -> o1.getKey().compareTo(o2.getKey())).collect(Collectors.toList())){
                    //ystem.out.println(p.getKey()+","+p.getValue());
                    if (p.getValue()>=len){
                        used_places.put(p.getKey(),len);
                        System.out.println(p.getKey());
                        if (p.getValue()>len){
                            released_place.put(p.getKey()+len,p.getValue()-len);
                        }
                        released_place.remove(p.getKey());
                        return true;
                    }
                }
            }
            return false;
        }
        public Boolean release(int index){
            if (used_places.containsKey(index)){
                released_place.put(index,used_places.get(index));
                used_places.remove(index);
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Disk_manage v=new Disk_manage();
        v.main();
    }


}
