package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N_and_M_2_15650 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] array = new int[N];

        for(int n = 0 ; n < N; n++){
            array[n] = n+1;
        }

        for(int i = 0; i<N; i++){
            search(M, array[i], Arrays.copyOfRange(array,i+1 ,array.length), "");
        }
    }

    static void search(int M, int cur, int[] array, String string){
        string += cur;
        if(string.length() == M*2 - 1 ){
            System.out.println(string);
        }
        else{
            for(int i = 0; i < array.length; i++){

                search(M, array[i], Arrays.copyOfRange(array,i+1 ,array.length), string+" ");
            }
        }
    }
}
