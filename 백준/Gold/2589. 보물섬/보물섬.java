import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, min, max;
    static int[] arr, answer;
    static char[][] map;
    static boolean[][] isChecked;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Point {
        int row;
        int col;
        int cnt;

        public Point(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(max);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isChecked = new boolean[N][M];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'W') {
                    isChecked[i][j] = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isChecked[i][j]) {
                    int value = BFS(i, j);
                    max = Math.max(value,max);
                }
            }
        }
    }

    private static int BFS(int Y, int X) {
        boolean[][] isCheckedCopy = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            isCheckedCopy[i] = isChecked[i].clone();
        }
        queue.offer(new Point(Y, X, 0));
        int count = 0;
        isCheckedCopy[Y][X]=true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int t = 0; t < len; t++) {
                Point p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int row = p.row + dy[i];
                    int col = p.col + dx[i];
                    if (row < 0 || row >= N || col < 0 || col >= M) continue;
                    if (!isCheckedCopy[row][col]) {
                        isCheckedCopy[row][col] = true;
                        queue.add(new Point(row, col, p.cnt + 1));
                        count = Math.max(count, p.cnt + 1);
                    }
                }
            }
        }
        return count;
    }

    public static void Solution() {
    }
}