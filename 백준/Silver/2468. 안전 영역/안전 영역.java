import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,max,min,answer;
    static int[][] map,arr;
    static int[] dy={-1,1,0,0};
    static int[] dx={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j]=value;
                max = Math.max(value,max);
                min = Math.min(value,min);
            }
        }
        answer=1;
        for(int rain=min;rain<=max;rain++) {
            arr = new int[N][N];
            int count=0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j]<=rain) {
                        arr[i][j]=-1;
                    }
                }
            }
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(arr[i][j]==0) {
                        DFS(i,j);
                        count++;
                    }
                }
            }
            answer=Math.max(answer,count);
        }
        System.out.println(answer);
    }
    public static void DFS(int row,int col) {
        for(int i=0;i<4;i++) {
            int y=row+dy[i];
            int x=col+dx[i];
            if(y>=0 && y<N && x>=0 && x<N && arr[y][x]==0) {
                arr[y][x]=-1;
                DFS(y,x);
            }
        }
    }
}