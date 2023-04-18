class Solution {
    public int[] solution(int[] num_list) {
        int a=0;
        int b=0;
        for(int num : num_list) {
            if(num%2==0) {
                b++;
            } else {
                a++;
            }
        }
        int[] answer = {b,a};
        return answer;
    }
}