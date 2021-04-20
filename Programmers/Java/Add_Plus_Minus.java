public class Add_Plus_Minus {
    public static void main(String[] args){
        Solution sol = new Solution();
        sol.solution(new int[]{4,7,2}, new boolean[]{true,false,true});
    }

    static class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for(int i = 0; i < absolutes.length; i++)
                answer += signs[i] ? absolutes[i] : -absolutes[i];
            return answer;
        }
    }
}
