import java.util.*;

class Solution {
    
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] arr;
    static int finalDistance;
    public int solution(int n, int[][] edge) {
        arr = new int[n+1];
        int answer = 0;
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edge.length;i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        BFS(1, 1);
        for(int i=0;i<=n;i++) {
            if(arr[i]==finalDistance) answer++;
        }
        
        return answer;
    }
    
    public static void BFS(int start, int init) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        queue.add(init);
        arr[start]=init;
        
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            int distance = queue.poll();
            finalDistance=distance;
            
            List<Integer> list = graph.get(currentNode);
            for(int l : list) {
                if(arr[l]!=0) continue;
                arr[l]=distance+1;
                queue.offer(l);
                queue.offer(distance+1);
            }
        }
    }
}