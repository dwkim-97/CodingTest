
public class Track_Construction {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
        System.out.println(sol.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}}));
        System.out.println(sol.solution(new int[][]{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}));
        System.out.println((sol.solution(new int[][]{{0, 0, 1, 0, 1, 1, 0, 0, 0, 0},{0, 0, 0, 0, 1, 0, 1, 1, 0, 1},{1, 0, 0, 0, 0, 1, 1, 0, 1, 0},{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},{0, 0, 0, 0, 1, 0, 1, 0, 1, 1},{0, 0, 1, 0, 1, 1, 0, 1, 0, 1},{0, 1, 0, 0, 1, 0, 0, 0, 1, 0},{1, 0, 0, 1, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 1, 0, 1, 0, 0},{1, 0, 0, 0, 0, 0, 0, 0, 1, 0}})));
        System.out.println(sol.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 1, 0, 0}, {1, 0, 0, 0, 1}, {0, 1, 1, 0, 0}}));
    }

    static class Solution {
        int[][] board;
        int[][][] way_cost;
        int N;

        int ROW = 0;
        int COLUMN = 1;
        int MAX = 100000000;

        public int solution(int[][] board) {
            this.board = board;
            this.N = board.length;
            this.way_cost = new int[N][N][2];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    for(int k = 0; k < 2; k++)
                        way_cost[i][j][k] = MAX;
                }
            }
            way_cost[0][0][0] = 0;
            way_cost[0][0][1] = 0;

            if(board[0][1] != 1)
                search(0,1, 100, ROW);
            if(board[1][0] != 1)
                search(1,0, 100, COLUMN);

            if(this.way_cost[N-1][N-1][ROW] > this.way_cost[N-1][N-1][COLUMN])
                return this.way_cost[N-1][N-1][COLUMN];
            else
                return this.way_cost[N-1][N-1][ROW];
        }

        void search(int i, int j, int cost, int dir){
            this.way_cost[i][j][dir] = cost;

            if(i != this.N-1 && board[i+1][j] != 1){
                if(dir == COLUMN && this.way_cost[i+1][j][COLUMN] >= cost+100)
                    search(i+1, j, cost+100, COLUMN);
                else if(dir == ROW && this.way_cost[i+1][j][COLUMN] >= cost+600)
                    search(i+1, j, cost+600, COLUMN);
            }
            if(j != this.N-1 && board[i][j+1] != 1){
                if(dir == ROW && this.way_cost[i][j+1][ROW] >= cost+100)
                    search(i, j+1, cost+100, ROW);
                else if(dir == COLUMN && this.way_cost[i][j+1][ROW] >= cost+600)
                    search(i, j+1, cost+600, ROW);
            }
            if(i != 0 && board[i-1][j] != 1){
                if(dir == COLUMN && this.way_cost[i-1][j][COLUMN] >= cost+100)
                    search(i-1, j, cost+100, COLUMN);
                else if(dir == ROW && this.way_cost[i-1][j][COLUMN] >= cost+600)
                    search(i-1, j, cost+600, COLUMN);
            }

            if(j != 0 && board[i][j-1] != 1){
                if(dir == ROW && this.way_cost[i][j-1][ROW] >= cost+100)
                    search(i, j-1, cost+100, ROW);
                else if(dir == COLUMN && this.way_cost[i][j-1][ROW] >= cost+600)
                    search(i, j-1, cost+600, ROW);
            }

        }
    }


}
