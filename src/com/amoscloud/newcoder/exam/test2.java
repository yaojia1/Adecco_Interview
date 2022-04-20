package com.amoscloud.newcoder.exam;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        inp.close();
        //fn=fn-1 +fn-2
        int[] steps={1,2};
        for(int step=2;step<n;step++){
            steps[step%2]+=steps[(step-1)%2];
        }
        System.out.println(steps[(n-1)%2]);
    }
}
