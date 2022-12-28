import java.util.*;

class Solution {
    static int count;
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs,(o1,o2) -> o1[2]-o2[2]);
        int answer = 0;
        
        parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i]=i;
        }
        for(int[] c : costs) {
            int fromNode = c[0];
            int toNode = c[1];
            int distance = c[2];
            fromNode = find(fromNode);
            toNode = find(toNode);
            if(fromNode==toNode) continue;
            answer+=distance;
            parent[toNode]=fromNode;
        }
        return answer;
    }
    
    public static int find(int node) {
        if(parent[node]==node) return node;
        else return parent[node]=find(parent[node]);
    }
}