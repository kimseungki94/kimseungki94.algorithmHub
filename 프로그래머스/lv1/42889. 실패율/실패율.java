import java.util.*;

class Solution {
    static int[] arr;
    static int[] failArr;
    static ArrayList<Stage> list = new ArrayList<>();
    public static class Stage{
        int index;
        double fail;
        
        Stage(int index, double fail) {
            this.index=index;
            this.fail=fail;
        }
    }
    public int[] solution(int N, int[] stages) {
        arr = new int[N+1];
        failArr = new int[N+1];
        for(int s : stages) {
            int temp = 1;
            while(temp<=s) {
                if(N<temp) break;
                arr[temp]++;
                temp++;
            }
            if(s<=N) failArr[s]++;
        }

        for(int i=1;i<=N;i++) {
            if(arr[i]==0 || failArr[i]==0) {
                list.add(new Stage(i,0));
            } else {
                list.add(new Stage(i,((double)failArr[i]/(double)arr[i])));
            }
        }
        Collections.sort(list,(o1,o2)-> Double.compare(o2.fail,o1.fail));
        
        int[] answer = new int[N];
        for(int i=0;i<N;i++) {
            answer[i]=list.get(i).index;
        }
        return answer;
    }
}