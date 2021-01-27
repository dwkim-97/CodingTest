package Baekjoon;

import java.util.Scanner;

public class Make_One_1463 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];

        for(int i = 2; i < n+1; i++){
            if(i % 3 == 0 && i % 2 == 0){
                int temp = min(dp[i/3], dp[i/2]);
                dp[i] = min(temp, dp[i-1]) + 1;
            }
            else if(i % 3 == 0){
                dp[i] = min(dp[i/3], dp[i-1]) + 1;
            }
            else if(i % 2 == 0){
                dp[i] = min(dp[i/2], dp[i-1]) + 1;
            }
            else
                dp[i] = dp[i-1] + 1;
        }
        System.out.println(dp[n]);
    }

    static int min(int a, int b){ return a > b ? b : a; }
}
