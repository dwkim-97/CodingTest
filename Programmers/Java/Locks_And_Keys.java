
public class Locks_And_Keys {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}},new int[][]{{1,1,1},{1,1,0},{1,0,1}}));
        //System.out.println(sol.solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}},new int[][]{{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}}));
    }

    static class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            int k_len = key.length;
            int l_len = lock.length;
            int board_size = l_len+2*k_len-2;
            int[][] board = new int[board_size][board_size];
            for(int i = 0; i < l_len; i++){
                for(int j = 0; j < l_len; j++){
                    board[i+k_len-1][j+k_len-1] = lock[i][j];
                }
            }

            int[][] new_board = new int[board_size][board_size];

            for(int r_cnt = 0; r_cnt < 4; r_cnt++){

                for (int i_k = 0; i_k < l_len+k_len-1; i_k++) {
                    for(int j_k = 0; j_k < l_len+k_len-1; j_k++) {
                        for (int i = 0; i < board_size; i++) {
                            new_board[i] = board[i].clone();
                        }
                        for (int i = 0; i < k_len; i++) {
                            for (int j = 0; j < k_len; j++) {
                                new_board[i + i_k][j + j_k] += key[i][j];
                            }
                        }
                        if (check_board(k_len, l_len, new_board))
                            return true;

                    }
                }
                key = rotate(k_len, key);
            }
            return false;
        }

        int[][] rotate(int M, int[][] key){
            int[][] new_key = new int[M][M];
            for(int i = 0; i < M; i++){
                for(int j = 0; j<M; j++){
                    if(key[i][j]==1)
                        new_key[j][M - 1 - i] = 1;
                    else
                        new_key[j][M - 1 - i] = 0;
                }
            }
            return new_key;
        }

        boolean check_board(int k_len, int l_len, int[][] board){
            for(int i = k_len-1; i < k_len-1+l_len; i++){
                for(int j = k_len-1; j < k_len-1+l_len; j++){
                    if(board[i][j] != 1){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
