package Baekjoon;
import java.util.Scanner;
import java.util.Stack;

public class Virus_2606 {
    public static int[][] matrix;
    public static boolean[] visited;
    public static int computer_num;
    public static int link_num;
    public static Stack<Integer> stack = new Stack<>();

    public static int infected = -1 ;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        computer_num = sc.nextInt()+1;
        link_num = sc.nextInt();

        matrix = new int[computer_num][computer_num];
        visited = new boolean[computer_num];

        for(int i = 0; i < link_num; i++){
            int head = sc.nextInt();
            int tail = sc.nextInt();
            matrix[head][tail] = 1;
            matrix[tail][head] = 1;
        }

        search(1);
        System.out.println(infected);
    }

    public static void search(int computer){
        stack.push(computer);
        visited[computer] = true;
        while(!stack.empty()){
            infected += 1;
            int cur = stack.pop();
            for(int i = 0; i < computer_num; i++){
                if(matrix[cur][i] == 1 && !visited[i]){
                    search(i);
                }
            }
        }
    }
}
