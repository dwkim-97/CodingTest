import java.util.*;

public class Shuttle_Bus {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(1,1,5,new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(sol.solution(2,10,2,new String[]{"09:10", "09:09", "08:00"}));
        System.out.println(sol.solution(2,1,2,new String[]{"09:00", "09:00", "09:00", "09:00"}));
        System.out.println(sol.solution(1,1,5,new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println(sol.solution(1,1,1,new String[]{"23:59"}));
        System.out.println(sol.solution(10,60,45,new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));

    }

    static class Solution {
        HashMap<Integer, Stack<Integer>> map;
        Queue<Integer> queue;
        int[] keys;
        int[] times;
        public String solution(int n, int t, int m, String[] timetable) {
            map = new HashMap<>();
            queue = new LinkedList<>();
            keys = new int[n];
            times = new int[timetable.length];
            for(int i = 0; i < times.length; i++){
                times[i] = changeTimeToInt(timetable[i]);
            }
            Arrays.sort(times);
            for(int time: times){
                queue.add(time);
            }

            for(int i = 0; i < n; i++){
                map.put(540 + t * i, new Stack<>());
                keys[i] = 540 + t * i;
            }

            int key_cnt = 0;
            while (key_cnt < n){
                if(queue.isEmpty())
                    break;
                if(keys[key_cnt] >= queue.peek() && map.get(keys[key_cnt]).size() < m){
                    map.get(keys[key_cnt]).push(queue.poll());
                }else{
                    key_cnt++;
                }
            }

            if(map.get(keys[keys.length-1]).size() < m){
                return changeTimeToString(keys[keys.length-1]);
            }
            else{
                return changeTimeToString(map.get(keys[keys.length-1]).peek()-1);
            }
        }
        int changeTimeToInt(String time){
            return Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3,5));
        }

        String changeTimeToString(int time){
            String hours = Integer.toString(time/60);
            String minutes = Integer.toString(time%60);
            hours = hours.length() < 2 ? "0"+hours : hours;
            minutes = minutes.length() < 2 ? "0"+minutes : minutes;
            return hours+":"+minutes;
        }
    }
}
