import java.util.*;

class Solution {
    
    public int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        
        for(int i=1;i<size;i++) {
            int jSize = triangle[i].length;
            for(int j=0;j<jSize;j++) {
                if(j==0) triangle[i][j]+=triangle[i-1][0];
                else if(j==jSize-1) triangle[i][j]+=triangle[i-1][jSize-2];
                else {
                    int max = Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                    triangle[i][j]+=max;
                }
            }
        }
        
        for(int i=0;i<triangle[size-1].length;i++) {
            answer = Math.max(answer,triangle[size-1][i]);
        }
        return answer;
    }
}
/**
아래로 내려갈 때,
첫번째 인덱스 보다 크고, 마지막 인덱스 보다 작을 때, 위에 있는 수 중 큰거로 DP
첫번째 인덱스는 위의 첫번째 인덱스 넣고, 마지막 인덱스는 위의 마지막 인덱스 넣기

이후 맨 마지막까지 도달한 뒤, 그 중 가장 큰 수 찾기
*/