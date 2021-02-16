package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _11399_ATM {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        int answer = 0;
        for(int i = 0 ; i < size; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for(int i = 0; i < size; i++){
            answer += arr[i] * (size - i);
        }
        System.out.println(answer);

    }
}
