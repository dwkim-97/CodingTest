package Baekjoon;

import java.util.Scanner;

public class Integer_Triangle_1932 {
    static int[][] dp;
    static int[][] tree;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int depth = sc.nextInt();
        tree = new int[depth][];
        dp = new int[depth][];
        for(int i = 0 ; i < depth; i++){
            tree[i] = new int[i+1];
            dp[i] = new int[i+1];
            for(int j = 0 ; j <= i; j++){
                tree[i][j] = sc.nextInt();
                if(i == depth-1)
                    dp[i][j] = tree[i][j];
                else
                    dp[i][j] = -1;
            }
        }

        System.out.println(find_max(0,0));
    }

    static int find_max(int n, int depth){
        if(dp[depth][n] == -1){
            if(tree[depth+1].length > n+1){
                if(tree[depth+1].length > n){
                    dp[depth][n] = max(find_max(n, depth+1), find_max(n+1, depth+1)) + tree[depth][n];
                }
                else
                    dp[depth][n] = find_max(n,depth+1) + tree[depth][n];
            }
        }
        return dp[depth][n];
    }

    static int max(int a, int b){
        return a > b ? a : b;
    }
}
