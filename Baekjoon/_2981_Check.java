package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _2981_Check {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        int difs[] = new int[size-1];
        arr[0] = sc.nextInt();
        for(int i = 1; i < size; i++){
            arr[i] = sc.nextInt();
            difs[i-1] = Math.abs(arr[i] - arr[i-1]);
        }
        Arrays.sort(difs);
        for(int i = 2; i < difs[0]+1 ; i++){
            boolean check = true;
            for(int df: difs){
                if(df % i != 0){
                    check = false;
                    break;
                }
            }
            if(check)
                System.out.print(i+" ");
        }
    }
}
