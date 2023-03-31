import java.util.*;

class Solution {
    private class Position {
        int row;
        int col;
        
        Position(int row, int col) {
            this.row=row;
            this.col=col;
        }
    }
    int dy[] = new int[]{-1,1,0,0};
    int dx[] = new int[]{0,0,-1,1};
    
    public int solution(int[][] maps) {
        return BFS(maps);
    }
    private int BFS(int[][] maps) {
        int rowSize = maps.length;
        int colSize = maps[0].length;
        int[][] countArrays = new int[rowSize][colSize];
        boolean[][] isVisited = new boolean[rowSize][colSize];
        countArrays[0][0]=1;
        isVisited[0][0]=true;
        int answer = 0;
        
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0,0));
        while(!queue.isEmpty()) {
            Position startNode = queue.poll();
            int currentRow = startNode.row;
            int currentCol = startNode.col;
            int currentCount = countArrays[currentRow][currentCol];
            for(int i=0;i<4;i++) {
                int nextRow = currentRow+dy[i];
                int nextCol = currentCol+dx[i];
                if(nextRow<0 || nextRow>=rowSize || nextCol<0 || nextCol>=colSize 
                   || maps[nextRow][nextCol]==0) {
                    continue;
                }
                if(isVisited[nextRow][nextCol]) continue;
                
                isVisited[nextRow][nextCol]=true;
                countArrays[nextRow][nextCol]=currentCount+1;
                
                queue.offer(new Position(nextRow,nextCol));
            }
            answer++;
        }
        int count = countArrays[rowSize-1][colSize-1];
        if(count==0) return -1;
        return count;
    }
}