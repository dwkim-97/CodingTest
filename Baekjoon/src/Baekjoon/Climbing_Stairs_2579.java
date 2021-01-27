package Baekjoon;

import java.util.Scanner;

public class Climbing_Stairs_2579 {
    static int[] stairs;
    static int[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int stairs_cnt = sc.nextInt();
        stairs = new int[stairs_cnt];
        dp = new int[stairs_cnt][2];
        for(int i =0 ; i < stairs_cnt; i++){
            stairs[i] = sc.nextInt();
            dp[i][0] = 0;
            dp[i][1] = 0;
        }

        dp[0][0] = stairs[0];
        if(dp.length > 1){
            dp[1][0] = stairs[0] + stairs[1];
            dp[1][1] = stairs[1];
        }

        for(int i = 2; i < stairs_cnt; i++){
            dp[i][0] = dp[i-1][1] + stairs[i];
            dp[i][1] = max(dp[i-2][0], dp[i-2][1]) + stairs[i];
        }
        System.out.println(max(dp[stairs_cnt-1][0], dp[stairs_cnt-1][1]));

    }

    static int max(int a, int b){
        return a > b ? a : b;
    }
}
