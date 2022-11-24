import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt,rt;
        lt = 0;
        rt = people.length-1;
        while(lt<=rt) {
            if(lt<rt) {
                if(people[lt]+people[rt]<=limit) {
                    lt++;
                    rt--;
                } else {
                    rt--;
                }
            } else {
                lt++;
                rt--;
            }
            answer++;
        }
        return answer;
    }
}