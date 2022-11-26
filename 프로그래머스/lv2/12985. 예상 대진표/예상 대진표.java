class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while(true) {
            if(a%2!=0) {
                a+=1;
            }
            if(b%2!=0) {
                b+=1;
            }
            if(a==b) {
                break;
            }
            a/=2;
            b/=2;
            answer++;
        }
        return answer;
    }
}