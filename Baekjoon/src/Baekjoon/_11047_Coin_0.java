package Baekjoon;

import java.util.Scanner;

public class _11047_Coin_0 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int price = sc.nextInt();
        int[] kinds = new int[size];
        int answer = 0;
        for(int i = 0; i < size; i++){
            kinds[i] = sc.nextInt();
        }

        for(int j = size-1; j >= 0; j--){
            if(price / kinds[j] >= 1) {
                answer += price / kinds[j];
                price = price % kinds[j];
            }
        }
        System.out.println(answer);
    }
}
