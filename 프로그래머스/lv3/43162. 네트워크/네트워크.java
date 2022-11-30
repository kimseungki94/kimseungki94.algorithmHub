import java.util.*;

class Solution {
    static boolean[] isChecked;
    static int size;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        size=computers.length;
        isChecked = new boolean[size];
        for(int i=0;i<size;i++) {
            if(!isChecked[i]) {
                DFS(i, computers);
                answer++;
            }
        }
        return answer;
    }
    public static void DFS(int i,int[][] computers) {
        isChecked[i] = true;

        for (int j = 0; j < size; j++) {
            if (i != j && computers[i][j] == 1 && isChecked[j] == false) {
                DFS(j, computers);
            }
        }
    }
}