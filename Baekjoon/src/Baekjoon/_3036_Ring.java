package Baekjoon;

import java.util.Scanner;

public class _3036_Ring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1 ; i < size; i++){
            int GCD = gcd(arr[0],arr[i]);
            System.out.println(arr[0]/GCD+"/"+arr[i]/GCD);
        }
    }

    static int gcd(int a, int b){
        if(b > a){
            int t = a;
            a = b;
            b = t;
        }
        for(int i = b; i>1; i--){
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }
}
