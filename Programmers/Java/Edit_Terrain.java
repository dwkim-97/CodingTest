public class Edit_Terrain {
    public static void main(String[] args){
        Solution sol = new Solution();
//        System.out.println(sol.solution(new int[][]{{1,2},{2,3}},3,2));
//        System.out.println(sol.solution(new int[][]{{5,1},{1,1}},1,1));
//        System.out.println(sol.solution(new int[][]{{10}},1,1));
        System.out.println(sol.solution(new int[][]{{2,1,2},{2,1,2},{2,1,2}},1,3));

    }
    public static class Solution {
        int[][] land;
        int P,Q;
        int N;

        public long solution(int[][] land, int P, int Q) {
            long answer = 0;

            this.land = land;
            this.P = P;
            this.Q = Q;
            this.N = land.length;

            long end = this.land[0][0];
            long start = this.land[0][0];
            for(int i = 0; i < this.N; i++){
                for(int j = 0; j < this.N; j++){
                    if(this.land[i][j] > end)
                        end = this.land[i][j];
                    if(this.land[i][j] < start)
                        start = this.land[i][j];
                }
            }

            long mid;
            while(start <= end){

                mid = (start + end)/ 2;

                long leftCost = calculateCost(mid);
                long rightCost = calculateCost(mid+1);

                if(leftCost > rightCost){
                    answer = rightCost;
                    start = mid+1;
                }
                else{
                    answer = leftCost;
                    if(leftCost == rightCost) break;
                    end = mid-1;
                }
            }

            return answer;
        }

        long calculateCost(long height){
            long cost = 0;
            for(int i = 0; i < this.N; i++){
                for(int j = 0; j < this.N; j++){
                    if(land[i][j] > height){
                        cost += (land[i][j] - height) * Q;
                    }
                    else{
                        cost += (height - land[i][j]) * P;
                    }
                }
            }
            return cost;
        }
    }
}
