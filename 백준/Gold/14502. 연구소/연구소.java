import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count, max;
    static int[][] map, temp;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static ArrayList<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 2) {
                    list.add(new Point(i, j));
                }
            }
        }
        temp = map.clone();
        DFS(0);
        System.out.println(max);
    }

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void DFS(int limit) {
        if (limit == 3) {
            BFS();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    DFS(limit + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
        }
        int[][] cloneMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            cloneMap[i] = map[i].clone();
        }
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int Y = point.row;
            int X = point.col;
            for (int i = 0; i < 4; i++) {
                int row = Y + dy[i];
                int col = X + dx[i];
                if (row < 0 || row >= N || col < 0 || col >= M) continue;
                if (cloneMap[row][col] == 0) {
                    cloneMap[row][col] = 2;
                    queue.offer(new Point(row, col));
                }
            }
        }
        isFindSafe(cloneMap);
    }

    public static void isFindSafe(int[][] cloneMap) {
        int size = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cloneMap[i][j] == 0) {
                    size++;
                }
            }
        }
        max = Math.max(max, size);
    }
}