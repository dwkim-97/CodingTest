import java.util.*;

public class Best_Matrix_Multiplication {
    public static void main(String args[]){
        Solution sol = new Solution();

    }

    static class Solution {
        public int solution(int[][] matrix_sizes) {
            int length = matrix_sizes.length;
            int[][] dp = new int[length][length];

            for(int i = 0; i < length; i++){
                for(int j = 0; j < length; j++){
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            for(int i = 0; i < length; i++){
                for(int j = 0; j < length-i; j++){
                    int a = j;
                    int b = j+i;
                    if(a == b) dp[a][b] = 0;
                    else{
                        for(int k = a; k < b; k++){
                            dp[a][b] = min(dp[a][b], dp[a][k] + dp[k+1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                        }
                    }
                }
            }

            return dp[0][length-1];
        }

        public int min(int a, int b){
            return a < b ? a : b;
        }
    }

//    class Solution {
//        ArrayList<Integer> multiple_list;
//        ArrayList<Integer> value_list;
//
//        public int solution(int[][] matrix_sizes) {
//            int answer = 0;
//            multiple_list = new ArrayList<>();
//            value_list = new ArrayList<>();
//
//            value_list.add(matrix_sizes[0][0]);
//            multiple_list.add(0);
//            for(int i = 0; i < matrix_sizes.length; i++){
//                value_list.add(matrix_sizes[i][1]);
//                if(i != matrix_sizes.length-1)
//                    multiple_list.add(matrix_sizes[i][0] * matrix_sizes[i][1] * matrix_sizes[i+1][1]);
//            }
//            multiple_list.add(0);
//
//            System.out.println(value_list);
//            System.out.println(multiple_list);
//
//            while(value_list.size() > 3){
//                int max = 0;
//                int max_idx = 0;
//                for(int i = 1; i < value_list.size()-1; i++){
//                    if(value_list.get(i) > max){
//                        max_idx = i;
//                        max = value_list.get(i);
//                    }
//                }
//
//                answer += multiple_list.get(max_idx);
//                multiple_list.remove(max_idx);
//                value_list.remove(max_idx);
//                if(max_idx-1 > 0)
//                    multiple_list.set(max_idx-1, value_list.get(max_idx-2) * value_list.get(max_idx-1) * value_list.get(max_idx));
//                if(max_idx < value_list.size()-1)
//                    multiple_list.set(max_idx, value_list.get(max_idx-1) * value_list.get(max_idx) * value_list.get(max_idx+1));
//
//                System.out.println(value_list);
//                System.out.println(multiple_list);
//            }
//
//            return answer + multiple_list.get(1);
//        }
//    }
}
