import java.util.*;

class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        double temp;
        temp = ((double) num1 / (double) num2) * 1000;
        System.out.println((int)temp);
        answer = (int)temp;
        return answer;
    }
}