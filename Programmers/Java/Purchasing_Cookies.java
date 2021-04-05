public class Purchasing_Cookies {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1,1,2,3}));
        System.out.println(sol.solution(new int[]{1,2,4,5}));
    }

    static class Solution {
        public int solution(int[] cookie) {
            int[] forward = new int[cookie.length];
            int[] backward = new int[cookie.length];
            int answer = 0;
            int l = cookie.length;

            if(cookie.length == 1)
                return answer;

            forward[0] = cookie[0];
            backward[l-1] = cookie[l-1];
            for(int i = 1; i < cookie.length; i++){
                forward[i] = forward[i-1] + cookie[i];
                backward[l-1-i] = backward[l-1 - i+1] + cookie[l-1-i];
            }

            int toLeft, toRight, leftBias, rightBias;
            for(int i = 0; i < l-1; i++){
                toLeft = i;
                toRight = i+1;
                leftBias = backward[i+1];
                rightBias = forward[i];

                while(toRight < l && forward[toRight]-rightBias < answer)
                    toRight++;

                while(toLeft > -1 && backward[toLeft]-leftBias < answer)
                    toLeft--;

                while(toLeft > -1 && toRight < l){
                    int leftValue = backward[toLeft]-leftBias;
                    int rightValue = forward[toRight]-rightBias;
                    if(leftValue == rightValue){
                        answer = leftValue > answer ? leftValue : answer;
                        toRight++;
                        toLeft--;
                    }else if(leftValue < rightValue)
                        toLeft--;
                    else
                        toRight++;
                }
            }

            return answer;
        }
    }
}
