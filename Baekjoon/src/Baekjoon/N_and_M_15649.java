package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class N_and_M_15649 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for(int n = 0 ; n < N; n++){
            stack.add(n+1);
        }

        for(int i = 0; i<N; i++){
            Stack<Integer> temp = (Stack<Integer>)stack.clone();
            search(M, temp.remove(i), temp, "");
        }
    }

    static void search(int M, int cur, Stack<Integer> stack, String string){
        string += cur;
        if(string.length() == M*2 - 1 ){
            System.out.println(string);
        }
        else{
            int size = stack.size();
            for(int i = 0; i < size; i++){
                Stack<Integer> temp = (Stack<Integer>)stack.clone();
                search(M, temp.remove(i), temp, string+" ");
            }
        }
    }
}
