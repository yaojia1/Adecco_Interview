package com.amoscloud.newcoder.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class search_floodfill {
    /**
     * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
     * 你也被给予三个整数 sr , sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行上色填充 。
     * 为了完成上色工作 ，从初始像素开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
     * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，
     * 重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
     * 最后返回经过上色渲染后的图像 
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flood-fill
     *
     * int[][]可以更改，我蠢了，报错一直循环，弄个已经遍历的queue或者stack，懒得搞了，此题失败
     */
    List<List<Integer>> mapfill=new ArrayList<>();
    int[][] image;
    int oldcolor=0;



    public List<List<Integer>> floodFill(int[][] image, int sr, int sc, int newColor) {

        oldcolor= image[sr][sc];
        for (int[] co:image){
            mapfill.add(new ArrayList<>());
            for (int i :co){
                mapfill.get(mapfill.size()-1).add(i);
            }
            //mapfill.add(Arrays.stream(Arrays.copyOf(co , co.length)).map(Integer::parseInt).collect(Collectors.toList()));
        }

        this.image=image;
        findflood(new int[]{0 , 0},sr,sc,newColor);

        //int[][] new1=mapfill.stream().mapToInt(Integer::intValue).toArray();
        return mapfill;

    }
    private void findflood(int[] direct, int sr, int sc, int newcolor){
        if (sc+1>mapfill.get(0).size()||sr+1>mapfill.size()||mapfill.get(sr).get(sc)!=this.oldcolor)return;
        mapfill.get(sr).set(sc,newcolor);
        System.out.println(Arrays.toString(direct));
        for (int i=-1;i<=1;i+=2){
            if (i*direct[0]!=-1&&sr+i>=0){
                findflood(new int[]{i , 0} ,sr+i,sc,newcolor);
            }
            System.out.println(i);
        }
        for (int j=-1;j<=1;j+=2){
            if (j*direct[1]!=-1&&sc+j>=0)
                findflood(new int[]{0 , j} ,sr,sc+j,newcolor);
        }
    }
}
