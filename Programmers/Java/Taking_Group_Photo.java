
import java.util.HashMap;

public class Taking_Group_Photo {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(2, new String[]{"N~F=0", "R~T>2"}));
        //System.out.println(sol.solution(2, new String[]{"M~C<2", "C~M>1"}));
    }

    static class Solution {
        HashMap<Character, Integer> map = new HashMap<>();
        int n;
        String[] data;
        public int solution(int n, String[] data) {
            int answer;
            this.n = n;
            this.data = data;

            map.put('A', 1);
            map.put('C', 2);
            map.put('F', 3);
            map.put('J', 4);
            map.put('M', 5);
            map.put('N', 6);
            map.put('R', 7);
            map.put('T', 8);
            answer = makeCase(0, new int[8], new int[]{1,2,3,4,5,6,7,8});
            return answer;
        }

        int makeCase(int idx, int[] aCase, int[] left){
            int cnt = 0;
            if(idx == 8) {
                cnt += check(aCase);
            }
            for(int i = 0; i < 8; i++) {
                if (left[i] != 0) {
                    aCase[idx] = left[i];
                    left[i] = 0;
                    cnt += makeCase(idx + 1, aCase, left);
                    left[i] = aCase[idx];
                    aCase[idx] = 0;
                }
            }
            return cnt;
        }

        int check(int[] aCase){
            int A, B, dist;
            int A_index = 0, B_index = 0;
            char con;
            for(int i = 0; i < n; i++){
                A = map.get(this.data[i].charAt(0));
                B = map.get(this.data[i].charAt(2));
                con = this.data[i].charAt(3);
                dist = this.data[i].charAt(4) - 47;

                for(int j = 0; j < 8; j++){
                    if(aCase[j] == A)
                        A_index = j;
                    else if(aCase[j] == B)
                        B_index = j;
                }


                if(con == '>'){
                    if(Math.abs(A_index - B_index) <= dist)
                        return 0;
                }else if(con == '<'){
                    if(Math.abs(A_index - B_index) >= dist)
                        return 0;
                }else{
                    if(Math.abs(A_index - B_index) != dist)
                        return 0;
                }
            }
            return 1;
        }
    }
}
