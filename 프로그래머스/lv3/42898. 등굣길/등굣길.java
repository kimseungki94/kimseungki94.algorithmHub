import java.util.*;

class Solution {
    
    static int count, N, M;
    static int[][] map;
    
    public int solution(int m, int n, int[][] puddles) {
        N = n;
        M = m;
        map = new int[N][M];
        for(int[] p : puddles) {
            map[p[1]-1][p[0]-1]=-1;
        }
        map[0][0]=1;
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==-1) {
                    map[i][j]=0;
                    continue;
                }
                if(i != 0) map[i][j] += map[i - 1][j] % 1000000007;
                if(j != 0) map[i][j] += map[i][j - 1] % 1000000007;
            }
        }
        return map[N-1][M-1] % 1000000007;
    }
}