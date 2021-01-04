package Baekjoon;

import java.util.Scanner;
import java.util.LinkedList;

public class Breaking_Wall_and_Moving_2206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int size = N * M;
        int[] array = new int[size];
        int[] distance_plus = new int[size];
        int[] distance_minus = new int[size];
        LinkedList<Integer> queue = new LinkedList<>();

        int i = 0;
        for (int n = 0; n < N; n++) {
            String temp = sc.next();
            for (int m = 0; m < temp.length(); m++) {
                array[i] = Character.getNumericValue(temp.charAt(m));
                distance_plus[i] = 999999;
                distance_minus[i] = 999999;
                i++;
            }
        }

        queue.offer(0);
        int count = 0;
        while (!queue.isEmpty()) {
            int queue_size = queue.size();
            count += 1;
            for (int q = 0; q < queue_size; q++) {
                int popped = queue.poll();
                int popped_check_1 = (popped < 0) ? -1 : 1;
                int popped_value = Math.abs(popped);
                boolean check = false;
                if (popped_check_1 >= 0 && count < distance_plus[popped_value]) {
                    distance_plus[popped_value] = count;
                    check = true;
                } else if (popped_check_1 < 0 && count < distance_minus[popped_value]) {
                    distance_minus[popped_value] = count;
                    check = true;
                }
                if (check) {
                    {
                        if ((popped_value + 1) % M != 0) {
                            if (array[popped_value + 1] == 0)
                                queue.offer(popped_check_1 * (popped_value + 1));
                            else if (array[popped_value + 1] == 1 && popped_check_1 > 0)
                                queue.offer((popped_value + 1) * -1);
                        }

                        if (popped_value != 0 && (popped_value - 1) % M != M - 1) {
                            if (array[popped_value - 1] == 0)
                                queue.offer(popped_check_1 * (popped_value - 1));
                            else if (array[popped_value - 1] == 1 && popped_check_1 > 0)
                                queue.offer((popped_value - 1) * -1);
                        }

                        if (popped_value + M < size) {
                            if (array[popped_value + M] == 0)
                                queue.offer(popped_check_1 * (popped_value + M));
                            else if (array[popped_value + M] == 1 && popped_check_1 > 0)
                                queue.offer((popped_value + M) * -1);
                        }

                        if (popped_value - M >= 0) {
                            if (array[popped_value - M] == 0)
                                queue.offer(popped_check_1 * (popped_value - M));
                            else if (array[popped_value - M] == 1 && popped_check_1 > 0)
                                queue.offer((popped_value - M) * -1);
                        }
                    }
                }

            }
        }
        int answer = (distance_minus[size - 1] > distance_plus[size - 1]) ? distance_plus[size - 1] : distance_minus[size - 1];
        if (answer == 999999)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}

