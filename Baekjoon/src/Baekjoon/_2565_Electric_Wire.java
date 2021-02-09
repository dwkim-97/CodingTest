package Baekjoon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class _2565_Electric_Wire {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap map = new HashMap<Integer, Integer>();
        int size = sc.nextInt();
        int[] A = new int[size];
        int[] B = new int[size];
        int[] arr = new int[size];
        int[] dp = new int[size];
        int answer = 0;

        for(int i = 0 ; i < size; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            map.put(A[i], B[i]);
        }

        arr[0] = 501;
        Arrays.sort(A);
        for(int i = 0 ; i < size; i++){
            arr[i] = (int)map.get(A[i]);
        }

        for(int i = 0 ; i < size; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
            answer = answer > dp[i] ? answer : dp[i];
        }

        System.out.println(size - answer);
    }
}
