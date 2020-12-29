package Baekjoon;

import java.util.Scanner;
import java.util.LinkedList;

public class Maze_Navigation_2178 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[sc.nextInt()][sc.nextInt()];
        for(int i = 0; i< matrix.length;i++){
            String line = sc.next();
            for(int j = 0; j < line.length(); j++){
                matrix[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        search(matrix);
    }

    static void search(int[][] matrix){
        int[][] CHECK_POSITION = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] distance = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        LinkedList<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0});
        distance[0][0] = 1;
        while(!queue.isEmpty()){
            int[] cur_position = queue.poll();
            int x = cur_position[0];
            int y = cur_position[1];
            if(x == N-1 && y == M-1){
                System.out.println(distance[x][y]);
                break;
            }
            for(int[] position: CHECK_POSITION){
                int new_x = x+position[0];
                int new_y = y+position[1];
                if(new_x >= 0 && new_y >= 0 && new_x < N && new_y < M){
                    if(matrix[new_x][new_y] == 1) {
                        if (!visited[new_x][new_y]) {
                            visited[new_x][new_y] = true;
                            distance[new_x][new_y] = distance[x][y] + 1;
                            queue.add(new int[]{new_x, new_y});
                        } else if (distance[new_x][new_y] > distance[x][y] + 1){
                            distance[new_x][new_y] = distance[x][y] + 1;
                            queue.add(new int[]{new_x, new_y});
                        }
                    }
                }
            }
        }
    }
}
