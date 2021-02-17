package Baekjoon;

import java.util.Scanner;

public class _11653_Factorization {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        boolean check[] = new boolean[target+1];
        for(int i = 2; i < check.length; i++){
            if(!check[i]){
                for(int j = i*2; j< check.length; j+=j){
                    check[j] = true;
                }
                while(target % i == 0){
                    System.out.println(i);
                    target = target / i;
                }
            }
        }
    }
}
