package Baekjoon;

import java.util.Scanner;

public class Wine_Tasting_2156 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int amount[] = new int[count+1];
        int dp[] = new int[count+1];
        for(int i = 1 ; i < count+1; i++){
            amount[i] = sc.nextInt();
        }


        dp[1] = amount[1];
        if(count>1){
            dp[2] = amount[1] + amount[2];
        }
        for(int i = 3 ; i < count+1; i++){
            dp[i] = max(dp[i-3] + amount[i] + amount[i-1], dp[i-2] + amount[i]);
            dp[i] = max(dp[i-1], dp[i]);

        }
        System.out.println(dp[count]);
    }

    static int max(int a, int b){
        return a > b ? a : b;
    }
}
