import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K, count, size, min;
    static int[][] map;
    static boolean[][] isVisited;
    static StringBuilder[] sb;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        main.DFS(N-1, 0, 1);
        System.out.println(size);
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            for (int j = 0; j < M; j++) {
                if (text.charAt(j) == 'T') {
                    isVisited[i][j] = true;
                }
                map[i][j] = text.charAt(j);
            }
        }
        isVisited[N-1][0]=true;
    }

    public void DFS(int row, int col, int count) {
        if (count > K) return;
        if (count == K && row == 0 && col == M - 1) {
            size++;
            return;
        }
            for (int i = 0; i < 4; i++) {
                int Y = row + dy[i];
                int X = col + dx[i];
                if (Y < 0 || Y >= N || X < 0 || X >= M || isVisited[Y][X]) continue;
                isVisited[Y][X] = true;
                DFS(Y, X, count + 1);
                isVisited[Y][X] = false;
            }
    }
}