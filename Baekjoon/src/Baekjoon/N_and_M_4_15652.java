package Baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N_and_M_4_15652 {
    static BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] array = new int[M];

        search(0, array, N);
        try {
            buf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void search(int count, int[] array, int N) {
        try {
            if (count == array.length) {
                for(int a :array){
                    buf.append(a+" ");
                }
                buf.write("\n");
            } else if(count == 0){
                for (int i = 0; i < N; i++) {
                    array[0] = i + 1;
                    search(1, array, N);
                }
            } else {
                for (int i = 0; i < N; i++) {
                    if (i + 1 >= array[count-1]){
                        array[count] = i + 1;
                        search(count + 1, array, N);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
