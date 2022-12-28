import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];
        for(int i=1;i<=rows;i++) {
            for(int j=1;j<=columns;j++) {
                map[i][j]=j+((i-1)*columns);
            }
        }
        for(int t=0;t<queries.length;t++) {
            int[] init = queries[t];
            
            int y1 = init[0];
            int y2 = init[2];
            int x1 = init[1];
            int x2 = init[3];
            
            int startData = map[y1][x2];
            int min = startData;
            
            for(int i=x2-1;i>=x1;i--) {
                min=Math.min(min,map[y1][i]);
                map[y1][i+1]=map[y1][i];
            }
            
            for(int i=y1+1;i<=y2;i++) {
                min=Math.min(min,map[i][x1]);
                map[i-1][x1]=map[i][x1];
            }
            
            for(int i=x1+1;i<=x2;i++) {
                min=Math.min(min,map[y2][i]);
                map[y2][i-1]=map[y2][i];
            }
            
            for(int i=y2-1;i>=y1;i--) {
                min=Math.min(min,map[i][x2]);
                map[i+1][x2]=map[i][x2];
            }
            map[y1+1][x2]=startData;

            answer[t]=min;
        }
        return answer;
    }
}