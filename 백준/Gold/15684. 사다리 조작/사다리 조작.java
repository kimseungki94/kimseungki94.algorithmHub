import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, M, count;
    private static int[][] map;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i <= 3; i++) {
            count = i;
            DFS(1, 1, 0);
            if (flag) break;
        }
        if(flag) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[K + 1][N + 1];

        for (int y = 0; y < M; y++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col] = 1;
            map[row][col + 1] = 2;
        }
    }

    private static void DFS(int y, int x, int limit) {
        if (flag) return;
        if (count == limit) {
            if (isCheck()) flag = true;
            return;
        }

        for (int i = y; i <= K; i++) {
            for (int j = x; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    DFS(1, 1, limit + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean isCheck() {
        for (int i = 1; i <= N; i++) {
            int row = 1;
            int col = i;
            while (row <= K) {
                if (map[row][col] == 1) col++;
                else if (map[row][col] == 2) col--;
                row++;
            }
            if (col != i) return false;
        }
        return true;
    }
}