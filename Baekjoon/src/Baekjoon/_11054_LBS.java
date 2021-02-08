package Baekjoon;

import java.util.Scanner;

public class _11054_LBS {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int answer;
        int size = sc.nextInt();
        int[] arr = new int[size];
        int[] in_dp = new int[size];
        int[] de_dp = new int[size];


        for(int i = 0 ; i < size; i++){
            arr[i] = sc.nextInt();
            in_dp[i] = 1;
            de_dp[i] = 1;
        }

        for(int i = 0 ; i < size; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j])
                    in_dp[i] = max(in_dp[i], in_dp[j]+1);
            }
        }

        for(int i = size-1 ; i > -1; i--){
            for(int j = size-1 ; j > i; j--){
                if(arr[i] > arr[j])
                    de_dp[i] = max(de_dp[i], de_dp[j]+1);
            }
        }

        answer = 1;
        for(int i = 0; i < size; i++){
            if(in_dp[i] + de_dp[i] - 1 > answer){
                answer = in_dp[i] + de_dp[i] - 1;
            }
        }

        System.out.println(answer);
    }

    static int max(int a, int b){
        return a > b ? a : b;
    }
}
