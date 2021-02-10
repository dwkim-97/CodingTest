package Baekjoon;

import java.util.Scanner;

public class _1912_Continuous_Sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size+1];
        int[] dp = new int[size+1];
        int minus = -1001;
        int answer = 0;

        for(int i = 1; i < size+1; i++){
            arr[i] = sc.nextInt();
            if(dp[i-1] + arr[i] > 0)
                dp[i] = dp[i-1] + arr[i];
            else
                dp[i] = 0;
                if(arr[i] > minus)
                    minus = arr[i];

            if(dp[i] > answer)
                answer = dp[i];
        }

        if(answer == 0)
            System.out.println(minus);
        else
            System.out.println(answer);
    }
}
