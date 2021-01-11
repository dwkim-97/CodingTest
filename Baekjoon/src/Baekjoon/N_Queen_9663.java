package Baekjoon;

import java.util.Scanner;

public class N_Queen_9663 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] board = new int[N];
        int count = 0;

        for(int i = 0; i < N; i++){
            board[0] = i;
            count += put_Queen(1, board);
        }
        System.out.println(count);

    }

    static int put_Queen(int cur_line, int[] board){
        int count = 0;
        int len = board.length;
        if (cur_line == len){
            return 1;
        }
        else{
            for(int i = 0; i < len; i++){
                board[cur_line] = i;
                if(isRight(board, cur_line, i)){
                    count += put_Queen(cur_line+1, board);
                }
            }
        }
        return count;
    }

    static boolean isRight(int[] board, int cur_line, int pos){
        for(int b = 0; b< cur_line ; b++){
            if(board[b] == pos) return false;
            if(Math.abs(b-cur_line) == Math.abs(board[b] - pos)) return false;
        }
        return true;
    }
}
