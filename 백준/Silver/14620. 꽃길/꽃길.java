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
        main.DFS(0, 0);
        System.out.println(min);
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
    }

    public void DFS(int sum, int count) {
        if (count == 3) {
            min = Math.min(min, sum);
            return;
        }
        if (min <= sum) return;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (!isVisited[i][j] && isCheck(i,j)) {
                        isVisited[i][j] = true;
                        for (int k = 0; k < 4; k++) {
                            int Y = i + dy[k];
                            int X = j + dx[k];
                            sum += map[Y][X];
                            isVisited[Y][X] = true;
                        }
                        DFS(sum + map[i][j], count + 1);
                        for (int k = 0; k < 4; k++) {
                            int Y = i + dy[k];
                            int X = j + dx[k];
                            sum -= map[Y][X];
                            isVisited[Y][X] = false;
                        }
                        isVisited[i][j] = false;
                }
            }
        }
    }

    public boolean isCheck(int row, int col) {
        for (int i=0; i<4; i++) {
            int Y = row + dy[i];
            int X = col + dx[i];

            if (isVisited[Y][X]) {
                return false;
            }
        }
        return true;
    }
}