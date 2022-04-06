package com.amoscloud.newcoder.LeetCode;

public class int_sort {
    public static void main(String[] args) {
        /*
        Scanner inp=new Scanner(System.in);
        int[] nums= Arrays.stream(inp.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        for (int i=0;i<nums.length;i++){
            nums[i]*=nums[i];
        }
        Arrays.sort(nums);*/
        String s="osdnfoenvnss fhsuhfu shcu jsch";
        String[] s2= s.split("\\s+");
        StringBuilder s3=new StringBuilder();
        for (String ss:s2){
            if (s3.length()>0) s3.append("%20");
            s3.append(ss);
        }
        s.replaceAll(" ","%20");
        System.out.println(s);
    }
}
