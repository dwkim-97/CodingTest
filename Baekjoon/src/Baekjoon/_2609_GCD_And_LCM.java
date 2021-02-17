package Baekjoon;

import java.util.Scanner;

public class _2609_GCD_And_LCM {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(b > a) { // a가 b보다 크도록
            int t = a;
            a = b;
            b = t;
        }

        for(int i = b; i > 0; i-- ){
            if(b % i == 0 && a % i == 0){
                System.out.println(i);
                break;
            }
        }

        for(int i = a; i < 100000000; i++){
            if(i % a == 0 && i % b ==0){
                System.out.println(i);
                break;
            }
        }
    }
}
