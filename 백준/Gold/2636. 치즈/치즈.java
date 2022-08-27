import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue, cheese;
    static int[][] map;
    static boolean[][] isChecked;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static ArrayList<Point> list = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
        System.out.println(count);
        System.out.println(cheese);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isChecked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }
    }

    public void Solution() {
        while (true) {
            if (!isFindCheese()) break;
            for (boolean[] check : isChecked) {
                Arrays.fill(check, false);
            }
            isChecked[0][0] = true;
            cheese = 0;
            DFS(0, 0);
            count++;
        }
    }

    private boolean isFindCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private void DFS(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int Y = row + dy[i];
            int X = col + dx[i];
            if (Y < 0 || Y >= N || X < 0 || X >= M) continue;
            if (!isChecked[Y][X]) {
                isChecked[Y][X] = true;
                if (map[Y][X] == 1) {
                    cheese++;
                    map[Y][X] = 2;
                } else DFS(Y, X);
            }
        }
    }
}
