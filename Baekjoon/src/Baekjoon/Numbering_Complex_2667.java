package Baekjoon;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Numbering_Complex_2667 {
    static int apartment_counts;
    static int[][] matrix;
    static boolean[][] visited;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static final int[][] CHECK = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        apartment_counts = sc.nextInt();
        matrix = new int[apartment_counts][apartment_counts];
        visited = new boolean[apartment_counts][apartment_counts];

        for(int i = 0; i < apartment_counts; i++){
            String input = sc.next();
            for(int j = 0; j < apartment_counts; j++){
                matrix[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }
        numberingComplex();
    }

    static void search(int starting_x, int starting_y, int complex_number){
        visited[starting_x][starting_y] = true;
        for(int i = 0; i < CHECK.length; i++){
            int new_x = starting_x + CHECK[i][0];
            int new_y = starting_y + CHECK[i][1];
            if(apartment_counts > new_x && apartment_counts > new_y && new_x >= 0 && new_y >= 0){
                if(matrix[new_x][new_y] == 1 && !visited[new_x][new_y]){
                    map.put(complex_number, map.get(complex_number)+1);
                    search(new_x, new_y, complex_number);
                }
            }
        }
    }

    static void numberingComplex(){
        int complex_number = 0;
        for(int i = 0; i < apartment_counts; i++){
            for(int j = 0; j < apartment_counts; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    map.put(++complex_number, 1);
                    search(i,j,complex_number);
                }
            }
        }
        Integer[] values = map.values().toArray(new Integer[0]);
        Arrays.sort(values);
        System.out.println(values.length);
        for(Integer value: values){
            System.out.println(value);
        }
    }
}
