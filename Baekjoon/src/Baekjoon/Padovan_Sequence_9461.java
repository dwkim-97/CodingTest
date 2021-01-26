package Baekjoon;

import java.util.Scanner;

public class Padovan_Sequence_9461 {

    static long[] dp = {1,1,1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test_count = sc.nextInt();
        int[] test_cases = new int[test_count];
        for(int t = 0; t < test_count; t++){
            test_cases[t] = sc.nextInt();
        }
        for(int n : test_cases) {
            if (n >= dp.length) {
                long[] new_dp = new long[n];
                for (int i = 0; i < new_dp.length; i++) {
                    if (i < dp.length) {
                        new_dp[i] = dp[i];
                    } else
                        new_dp[i] = 0;
                }
                dp = new_dp;
            }
            System.out.println(ps(n-1));
        }


    }

    static long ps(int n){
        if(dp[n] == 0){
            dp[n] = ps(n-2) + ps(n-3);
        }
        return dp[n];
    }

}
