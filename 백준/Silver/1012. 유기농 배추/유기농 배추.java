import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T;
    static int[][] map;
    static boolean[][] isSelected;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};


    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                map[row][col] = 1;
            }
            isSelected = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        count++;
                        DFS(i, j);
                    }
                }
            }
            sb.append(count + "\n");
            count = 0;
        }
    }

    public void DFS(int row, int col) {
        map[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int Y = row + dy[i];
            int X = col + dx[i];
            if (Y < 0 || Y >= N || X < 0 || X >= M) continue;
            if (map[Y][X] == 1) DFS(Y, X);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(sb.toString());
    }
}
