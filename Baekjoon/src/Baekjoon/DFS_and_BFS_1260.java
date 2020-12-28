package Baekjoon;

import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_and_BFS_1260 {

    public static int vertices_num;
    public static int edges_num;
    public static int[][] matrix;
    public static boolean[] visited_dfs;
    public static boolean[] visited_bfs;
    public static int startVertex;
    public static Stack<Integer> stack = new Stack<>();
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args){
        System.out.println("Program Start.");

        Scanner sc = new Scanner(System.in);
        vertices_num = sc.nextInt()+1;
        edges_num = sc.nextInt();
        startVertex = sc.nextInt();

        matrix = new int[vertices_num][vertices_num];
        visited_dfs = new boolean[vertices_num];
        visited_bfs = new boolean[vertices_num];

        for(int i = 0; i< edges_num; i++){
            int head = sc.nextInt();
            int tail = sc.nextInt();
            matrix[head][tail] = 1;
            matrix[tail][head] = 1;
        }

        DFS(startVertex);
        System.out.println();
        BFS(startVertex);
    }

    public static void DFS(int startVertex){
        stack.push(startVertex);
        visited_dfs[startVertex] = true;
        while(!stack.empty()){
            int curVertex = stack.pop();
            System.out.print(curVertex+" ");
            for(int i = 0; i<vertices_num; i++){
                if(matrix[curVertex][i] == 1 && !visited_dfs[i]){
                    DFS(i);
                }
            }
        }
    }

    public static void BFS(int startVertex){
        queue.offer(startVertex);
        visited_bfs[startVertex] = true;
        while(!queue.isEmpty()){
            int curVertex = queue.poll();
            System.out.print(curVertex+ " ");
            for(int i = 0 ; i<vertices_num; i++){
                if(matrix[curVertex][i] == 1 && !visited_bfs[i]){
                    queue.offer(i);
                    visited_bfs[i] = true;
                }
            }
        }
    }
}
