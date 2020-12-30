package Baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class Tomato_7569 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int H = sc.nextInt();
        int size = N * M;
        LinkedList<Point> queue = new LinkedList<>();
        int[][] list = new int[H][size];
        int zero = 0;

        for (int h = 0; h<H; h++) {
            for (int i = 0; i < size; i++) { // 모든 입력을 1차원 배열로
                int integer = sc.nextInt();
                list[h][i] = integer;
                if (integer == 0) zero += 1; // 0의 갯수 세기
                else if (integer == 1) queue.offer(new Point(h,i)); // 1의 경우 바로 큐에 삽입
            }
        }

        if(zero == 0){ // 0(안 익은것)이 0개면 이미 다 익은 것!
            System.out.println(0);
        }else{
            int day = -1;
            int changes = 0; // 시간이 지나면서 익은 토마토의 갯수
            while(!queue.isEmpty()) { // day count
                day += 1;
                int queue_size = queue.size(); // 1 day 단위로 계산할 것이기 때문에 큐 사이즈 저장
                for(int q = 0; q< queue_size; q++){ // 저장된 큐 사이즈로 반복하여 1 day 단위 계산할 수 있도록
                    Point i = queue.poll();
                    if (i.position + N < size && list[i.height][i.position + N] == 0) { // 위 토마토가 익었는지?
                        list[i.height][i.position + N] = day+2;
                        queue.offer(new Point(i.height,i.position + N));
                        changes += 1;
                    }
                    if (i.position - N >= 0 && list[i.height][i.position - N] == 0) { // 아래 토마토가 익었는지?
                        list[i.height][i.position - N] = day+2;
                        queue.offer(new Point(i.height,i.position - N));
                        changes += 1;
                    }
                    if (i.position + 1 < size && (i.position + 1) % N != 0 &&
                            list[i.height][i.position + 1] == 0) { // 오른쪽?
                        list[i.height][i.position + 1] = day+2;
                        queue.offer(new Point(i.height,i.position + 1));
                        changes += 1;
                    }
                    if (i.position - 1 >= 0 && (i.position - 1) % N != N - 1 &&
                            list[i.height][i.position - 1]  == 0) { // 왼쪽?
                        list[i.height][i.position - 1] = day+2;
                        queue.offer(new Point(i.height,i.position - 1));
                        changes += 1;
                    }
                    if (i.height + 1 < H && list[i.height + 1][i.position] == 0){
                        list[i.height + 1][i.position] = day+2;
                        queue.offer(new Point(i.height + 1,i.position));
                        changes += 1;
                    }
                    if (i.height - 1 >= 0 && list[i.height - 1][i.position] == 0){
                        list[i.height - 1][i.position] = day+2;
                        queue.offer(new Point(i.height - 1,i.position));
                        changes += 1;
                    }
                }
            }
            if(changes != zero){ // 초기에 안 익은 토마토 수와 익게 된 토마토 수 비교
                System.out.println(-1);
            }
            else{
                System.out.println(day);
            }
        }
    }

    private static class Point {
        int position;
        int height;
        public Point(int h,int p){
            this.height = h;
            this.position = p;
        }
    }
}


