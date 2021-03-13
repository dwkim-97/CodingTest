import java.util.Arrays;
import java.util.HashMap;

public class Hotel_Room_Assignment {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(10, new long[]{1,3,4,1,3,1})));
    }

    static class Solution {
        HashMap<Long, Long> map = new HashMap<>();
        public long[] solution(long k, long[] room_number) {
            long[] answer = new long[room_number.length];

            for(int i = 0; i < room_number.length; i++){
                answer[i] = findEmptyRood(room_number[i]);
            }
            return answer;
        }

        long findEmptyRood(long request){
            if(!map.containsKey(request)){
                map.put(request, request+1);
                return request;
            }

            long next_room = map.get(request);
            long empty_room = findEmptyRood(next_room);
            map.put(request, empty_room);
            return empty_room;
        }
    }
}
