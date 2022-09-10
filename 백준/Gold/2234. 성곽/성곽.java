import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

public class Main {

    private static int N, K, M, count, max;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int[] dy = {0, -1, 0, 1};
    private static int[] dx = {-1, 0, 1, 0};

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]) {
                    count++;
                    max = Math.max(max, BFS(i, j));
                }
            }
        }
        System.out.println(count);
        System.out.println(max);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int bit = 1; bit <= 8; bit <<= 1) {
                    if ((map[i][j] & bit) != 0) {
                        isVisited = new boolean[N][M];
                        map[i][j] -= bit;
                        max = Math.max(max, BFS(i, j));
                        map[i][j] += bit;
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int BFS(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, col));
        isVisited[row][col] = true;
        int size = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int Y = point.row;
            int X = point.col;
            int bit = 1;
            for (int i = 0; i < 4; i++) {
                if(i>0) bit=bit<<1;
                if ((map[Y][X] & bit) == 0) {
                    int newY = Y + dy[i];
                    int newX = X + dx[i];
                    if (newY < 0 || newY >= N || newX < 0 || newX >= M || isVisited[newY][newX]) continue;
                    size++;
                    isVisited[newY][newX] = true;
                    queue.add(new Point(newY, newX));
                }
            }
        }
        return size;
    }
}