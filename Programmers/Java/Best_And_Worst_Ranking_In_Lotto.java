public class Best_And_Worst_Ranking_In_Lotto {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            int erased = 0;

            int worst_cnt = 0;
            for(int i = 0; i < 6; i++){
                if(lottos[i] == 0) erased++;
                for(int j = 0; j < 6; j++){
                    if(lottos[i] == win_nums[j]){
                        worst_cnt++;
                        break;
                    }
                }
            }

            answer[0] = grade(worst_cnt+erased);
            answer[1] = grade(worst_cnt);

            return answer;
        }

        public int grade(int cnt){
            switch(cnt){
                case 6: return 1;
                case 5: return 2;
                case 4: return 3;
                case 3: return 4;
                case 2: return 5;
                default: return 6;
            }
        }
    }
}
