import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue;
    static int[][] map,arr;
    static boolean[][] isSelected;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static List<Integer> list = new ArrayList<>();


    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int t=0;t<K;t++) {
            st = new StringTokenizer(br.readLine());
            int X1 = Integer.parseInt(st.nextToken());
            int Y1 = N-Integer.parseInt(st.nextToken());
            int X2 = Integer.parseInt(st.nextToken());
            int Y2 = N-Integer.parseInt(st.nextToken());

            for(int i=Y2;i<Y1;i++) {
                for(int j=X1;j<X2;j++) {
                    map[i][j]=1;
                }
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==0){
                    count=0;
                    DFS(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
    }

    public void DFS(int row, int col) {
        map[row][col] = 1;
        count++;
        for (int i = 0; i < 4; i++) {
            int Y = row + dy[i];
            int X = col + dx[i];
            if (Y < 0 || Y >= N || X < 0 || X >= M) continue;
            if (map[Y][X] == 0) DFS(Y, X);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(list.size());
        for(int value : list) sb.append(value+" ");
        System.out.println(sb.toString());
    }
}
