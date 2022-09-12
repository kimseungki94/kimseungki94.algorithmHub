import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M,max;
    static int[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        input();
        DFS(0,0);
        System.out.println(max);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N][M];
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            for(int j=0;j<M;j++) {
                map[i][j]=text.charAt(j)-'0';
            }
        }
    }

    public static void DFS(int row,int col) {
        if(row>=N) {
            sum();
            return;
        }
        if(col>=M) {
            DFS(row+1,0);
            return;
        }
        isVisited[row][col]=true;
        DFS(row,col+1);

        isVisited[row][col]=false;
        DFS(row,col+1);
    }

    public static void sum() {
        int temp=0;
        int value=0;
        for(int i=0;i<N;i++) {
            temp=0;
            for(int j=0;j<M;j++) {
                if(isVisited[i][j]) {
                    temp*=10;
                    temp+=map[i][j];
                } else {
                    value+=temp;
                    temp=0;
                }
            }
            value+=temp;
        }
        for(int i=0;i<M;i++) {
            temp=0;
            for(int j=0;j<N;j++) {
                if(!isVisited[j][i]) {
                    temp*=10;
                    temp+=map[j][i];
                } else {
                    value+=temp;
                    temp=0;
                }
            }
            value+=temp;
        }

        max=Math.max(max,value);
    }
}