import java.util.*;
public class Muzi_Mukbang_Live {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{3,1,2},5));
        System.out.println(sol.solution(new int[]{5,7,10,9,2,11},22));
        System.out.println(sol.solution(new int[]{3,2,1,7,8,9},25));
        System.out.println(sol.solution(new int[]{4,2,3,6,7,1,5,8},16));
        System.out.println(sol.solution(new int[]{4,2,3,6,7,1,5,8},27));
        System.out.println(sol.solution(new int[]{1,1,1,1},5));
        System.out.println(sol.solution(new int[]{1,1,1,1,3},5));
    }

    static class Solution {
        class Food implements Comparable<Food>{
            int idx;
            int time;

            public Food(int idx, int time){
                this.idx = idx;
                this.time = time;
            }

            @Override
            public int compareTo(Food aFood){
                return this.time - aFood.time;
            }
        }

        List<Food> arr_food;
        public int solution(int[] food_times, long k) {
            arr_food = new LinkedList<>();
            int n = food_times.length;

            for(int i = 0; i < food_times.length; i++){
                arr_food.add(new Food(i+1, food_times[i]));
            }

            Collections.sort(arr_food);

            int prev_time = 0;
            int i = 0;
            for(Food f : arr_food){
                long dif = f.time - prev_time;
                if(dif != 0){
                    long cost = dif * n;
                    if(cost <= k){
                        k -= cost;
                        prev_time = f.time;
                    }else{
                        k %= n;
                        arr_food.subList(i, food_times.length).sort((Food a, Food b) ->{
                            return a.idx - b.idx;
                        });
                        return arr_food.get(i+(int)k).idx;
                    }
                }
                i++;
                n--;
            }

            return -1;
        }

    }
}
