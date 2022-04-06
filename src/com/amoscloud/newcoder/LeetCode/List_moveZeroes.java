package com.amoscloud.newcoder.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class List_moveZeroes {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        int[] nums= Arrays.stream(inp.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int temp=0,temp2=0,k=0;
        for(int i=0,j=nums.length-1;i<=j;i++){
            if(nums[i]==0){
                k=j-1;
                temp=nums[j];
                nums[j]=0;
                while (k>=i){
                    temp2=nums[k];
                    nums[k]=temp;
                    temp=temp2;
                    k--;
                }
                i--;j--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
