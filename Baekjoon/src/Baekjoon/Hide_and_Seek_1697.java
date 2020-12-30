package Baekjoon;

import java.util.Scanner;
import java.util.LinkedList;

public class Hide_and_Seek_1697 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> queue = new LinkedList<>();
        int start = sc.nextInt();
        int target = sc.nextInt();
        boolean[] visited = new boolean[100001];
        int queue_size;
        int count;

        if (start == target){
            System.out.println(0);
            return;
        }

        queue.add(start);
        visited[start] = true;
        count = 0;
        while(true) {
            queue_size = queue.size();
            count += 1;
            for (int i = 0; i < queue_size; i++) {
                int popped = queue.poll();
                if (popped + 1 == target || popped - 1 == target
                        || popped * 2 == target) {
                    System.out.println(count);
                    return;
                } else {
                    if (popped + 1 <= 100000 && !visited[popped + 1]) {
                        visited[popped + 1] = true;
                        queue.add(popped + 1);
                    }
                    if (popped - 1 >= 0 && !visited[popped - 1]) {
                        visited[popped - 1] = true;
                        queue.add(popped - 1);
                    }if (popped*2 <= 100000 && !visited[popped * 2]) {
                        visited[popped * 2] = true;
                        queue.add(popped * 2);
                    }
                }
            }
        }
    }
}


