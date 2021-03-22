import java.util.*;

public class Wall_Inspection {
    public static void main(String[] args){
        Solution sol = new Solution();
        //System.out.println(sol.solution(12, new int[]{1,5,6,10}, new int[]{1,2,3,4}));
        //System.out.println(sol.solution(12, new int[]{1,3,4,9,10}, new int[]{3,5,7}));
        System.out.println(sol.solution(12, new int[]{1,3,4,9,10}, new int[]{3}));
    }
    static class Solution {
        int[] weak, dist;
        int[][] weak_cases;
        int n, answer;
        public int solution(int n, int[] weak, int[] dist) {
            weak_cases = new int[weak.length][weak.length];
            this.weak = weak;
            this.dist = dist;
            this.answer = dist.length+1;
            this.n = n;

            makeWeakCases();
            makeDistCases(new boolean[dist.length], new int[dist.length], 0);
            if(answer == dist.length+1)
                return -1;
            else
                return answer;
        }

        void makeWeakCases(){
            int[] weak_case = this.weak.clone();
            weak_cases[0] = weak_case.clone();
            for(int i = 1; i < weak.length; i++){
                int temp = weak_case[0];
                for(int j = 1; j < weak.length; j++){
                    weak_case[j-1] = weak_case[j];
                }
                weak_case[weak.length-1] = temp+n;
                weak_cases[i] = weak_case.clone();
            }
        }

        void makeDistCases(boolean[] dist_visit, int[] dist_case, int idx){
            if(idx == dist.length){
                for(int[] weak_case: weak_cases)
                    check(dist_case, weak_case);
            }
            for(int i = 0; i < dist.length; i++){
                if(!dist_visit[i]){
                    dist_visit[i] = true;
                    dist_case[idx] = dist[i];
                    makeDistCases(dist_visit, dist_case, idx+1);
                    dist_case[idx] = 0;
                    dist_visit[i] = false;
                }
            }
        }

        void check(int[] dist_case, int[] weak_case){
            int cur = 0, next;
            int dist_idx = 0;
            while(cur < weak_case.length && dist_idx < dist_case.length){
                next = cur+1;
                while(next < weak_case.length &&
                        weak_case[cur] + dist_case[dist_idx] >= weak_case[next]){
                   next++;
                }
                cur = next;
                dist_idx++;
            }

            if(cur == weak_case.length && dist_idx < answer)
                answer = dist_idx;
        }
    }
//    static class Solution {
//        HashMap<Integer, Boolean> visited;
//        HashMap<Integer, Boolean> gone;
//        Stack<Integer> weak;
//        int[] dist;
//        int[][] dist_case;
//        boolean[] dist_visited;
//        public int solution(int n, int[] weak, int[] dist) {
//            int answer, new_answer;
//            dist_case = new int[dist.length];
//            dist_visited = new boolean[dist.length];
//            visited = new HashMap<>();
//            gone = new HashMap<>();
//            this.dist = dist;
//            this.weak = new Stack();
//
//            for(int w: weak)
//                this.weak.push(w);
//
//            answer = dist.length+1;
//            for(int i = 0; i < weak.length; i++) {
//                new_answer = makeDistanceCases(0, dist.length + 1);
//                if (new_answer < answer)
//                    answer = new_answer;
//                this.weak.push(this.weak.firstElement())
//            }
//
//
//            return answer;
//        }
//
//        int makeDistanceCases(int idx, int answer){
//            if(idx == dist.length){
//                for(int w: weak)
//                    visited.put(w, false);
//                for(int d :dist)
//                    gone.put(d, false);
//                return search(0);
//            }
//            for (int i = 0; i < dist.length; i++) {
//                if(!dist_visited[i]) {
//                    dist_visited[i] = true;
//                    dist_case[idx] = dist[i];
//                    int new_answer = makeDistanceCases(idx + 1, answer);
//                    if (new_answer < answer)
//                        answer = new_answer;
//                    dist_visited[i] = false;
//                }
//            }
//            return answer;
//        }
//
//
//        int search(int cnt){
//            if(!visited.values().contains(false))
//                return cnt;
//            else if(!gone.values().contains(false))
//                return dist.length+1;
//
//            for(int i = 0; i < weak.size(); i++){
//                if(!visited.get(weak.get(i))) {
//                    visited.put(weak.get(i), true);
//                    int start = weak.get(i);
//                    for (int j = 0; j < dist.length; j++) {
//                        if(!gone.get(dist[j])){
//                            gone.put(dist[j], true);
//                            int next = i+1;
//                            while(next < weak.size() && weak.get(i) <= start + dist[j]){
//                                visited.put(weak.get(i), true);
//                                next++;
//                            }
//                            return search(cnt+1);
//                        }
//                    }
//                }
//            }
//            return cnt;
//        }
//    }
}
