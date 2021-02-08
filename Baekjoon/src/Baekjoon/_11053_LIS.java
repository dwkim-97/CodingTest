package Baekjoon;

import java.util.Scanner;

public class _11053_LIS {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        int[] dp = new int[size];
        int answer = 1;

        for(int i = 0 ; i < size; i++){
            array[i] = sc.nextInt();
            dp[i] = 1;
        }

        for(int i = 1; i < size; i++){
            for(int j = 0; j < i; j++){
                if(array[i] > array[j])
                    dp[i] = max(dp[i], dp[j] + 1);
            }
            if(dp[i] > answer)
                answer = dp[i];
        }

        System.out.println(answer);
    }

    public static int max(int a, int b){
        return a > b ? a : b;
    }
}
