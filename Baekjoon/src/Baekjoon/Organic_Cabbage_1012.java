package Baekjoon;

import java.util.Scanner;

public class Organic_Cabbage_1012 {
    static int[][] matrix;
    static int[][] CHECK_POSITION = {{-1,0}, {0,1}, {1,0}, {0,-1}};


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int case_num = sc.nextInt();

        for(int i = 0; i < case_num; i++){
            matrix = new int[sc.nextInt()][sc.nextInt()];
            int cabbages = sc.nextInt();
            for(int j = 0; j < cabbages; j++){
                matrix[sc.nextInt()][sc.nextInt()] = 1;
            }
            System.out.println(countGroups());
        }
    }

    static int countGroups(){
        int count = 0;
        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[0].length; y++){
                if(matrix[x][y] == 1){
                    count += 1;
                    search(x,y);
                }
            }
        }
        return count;
    }

    static void search(int x, int y){
        matrix[x][y] = 999;
        for(int i = 0 ; i < CHECK_POSITION.length; i++){
            int new_x = x + CHECK_POSITION[i][0];
            int new_y = y + CHECK_POSITION[i][1];
            if(new_x >= 0 && new_y >= 0 && new_x < matrix.length && new_y < matrix[0].length){
                if(matrix[new_x][new_y] == 1)
                    search(new_x,new_y);
            }
        }
    }
}
