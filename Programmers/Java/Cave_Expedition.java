import java.util.*;

public class Cave_Expedition {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(9, new int[][]{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}}, new int[][]{{8,5},{6,7},{4,1}}));
        System.out.println(sol.solution(9, new int[][]{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}}, new int[][]{{4,1},{8,7},{6,5}}));
    }


    static class Solution {
        public boolean solution(int n, int[][] path, int[][] order) {
            int[] visited = new int[n];
            Queue<Integer> queue = new LinkedList<>();
            ArrayList<Integer>[] adj_list = new ArrayList[n];
            HashMap<Integer, Integer> s_e = new HashMap<>();
            HashMap<Integer, Integer> e_s = new HashMap<>();
            int NOT_VISITED = 0, VISITED = 1, WAITING = 2;

            for(int i = 0; i < n; i++) adj_list[i] = new ArrayList<>();

            for(int[] p : path){
                adj_list[p[0]].add(p[1]);
                adj_list[p[1]].add(p[0]);
            }

            for(int[] o : order){
                s_e.put(o[0], o[1]);
                e_s.put(o[1], o[0]);
            }

            if(e_s.keySet().contains(0)) return false;

            queue.offer(0);
            visited[0] = VISITED;
            while(!queue.isEmpty()){
                int popped = queue.poll();
                for(int i = 0; i < adj_list[popped].size(); i++){
                    int next = adj_list[popped].get(i);
                    if(visited[next] == NOT_VISITED){
                        if(e_s.keySet().contains(next)){
                            if(visited[e_s.get(next)] == VISITED){
                                queue.offer(next);
                                visited[next] = VISITED;
                            }else
                                visited[next] = WAITING;
                        }else{
                            if(s_e.keySet().contains(next) && visited[s_e.get(next)] == WAITING){
                                queue.offer(s_e.get(next));
                                visited[s_e.get(next)] = VISITED;
                            }
                            queue.offer(next);
                            visited[next] = VISITED;
                        }
                    }
                }
            }


            for(int v : visited)
                if(v != VISITED) return false;

            return true;
        }
    }
}
