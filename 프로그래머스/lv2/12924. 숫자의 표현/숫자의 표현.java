class Solution {
    public int solution(int n) {
        int answer = 0;
        int lt,rt,sum;
        lt=rt=sum=1;
        
        while(lt<=rt) {
            if(sum>=n) {
                if(sum==n) {
                    answer++;
                }
                sum-=lt;
                lt++;
            } else {
                rt++;
                sum+=rt;
            }
        }
        return answer;
    }
}