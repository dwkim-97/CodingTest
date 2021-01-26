package Baekjoon;

import java.util.Scanner;

public class RGB_Distance_1149 {
    static int[][] prices;
    static int[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int house_count = sc.nextInt();
        prices = new int[house_count][3];
        dp = new int[house_count][3];
        for(int i = 0 ; i < house_count; i++){
            for(int j = 0; j < 3 ; j++){
                prices[i][j] = sc.nextInt();
                dp[i][j] = 0;
            }
        }
        for(int i = 0; i < 3; i++){
            dp[0][i] = prices[0][i];
        }
        int min = Min(coloring(house_count-1, 0),coloring(house_count-1, 1));
        min = Min(min,coloring(house_count-1, 2));
        System.out.println(min);
    }

    static int coloring(int n, int i){
        if (dp[n][i] == 0){
            if(i == 0)
                dp[n][i] = Min(coloring(n - 1,1), coloring(n - 1,2)) + prices[n][0];
            else if(i == 1)
                dp[n][i] = Min(coloring(n - 1,0), coloring(n - 1,2)) + prices[n][1];
            else
                dp[n][i] = Min(coloring(n - 1,0), coloring(n - 1,1)) + prices[n][2];

        }
        return dp[n][i];
    }

    static int Min(int a, int b){return a > b ? b : a;}
}
