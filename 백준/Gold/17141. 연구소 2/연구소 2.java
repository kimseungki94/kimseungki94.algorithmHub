import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    static int N, M, count, max, min;
    static boolean flag = true;
    static boolean[] isSelected;
    static int[][] map, temp;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static ArrayList<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 2) {
                    list.add(new Point(i, j));
                }
                if (value == 0) {
                    count++;
                }
            }
        }
        count += list.size() - M;
        isSelected = new boolean[list.size()];
        if (count == 0) min = 0;
        else DFS(0, 0);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void DFS(int limit, int start) {
        if (limit == M) {
            BFS(isFixedMap(), count);
            return;
        }
        for (int i = start; i < list.size(); i++) {
            isSelected[i] = true;
            DFS(limit + 1, i + 1);
            isSelected[i] = false;
        }
    }

    public static void BFS(int[][] fixedMap, int size) {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (isSelected[i]) queue.add(list.get(i));
        }
        int time = 0;
        while (!queue.isEmpty()) {
            if (min <= time) break;
            int len = queue.size();
            for (int m = 0; m < len; m++) {
                Point point = queue.poll();
                int Y = point.row;
                int X = point.col;
                for (int i = 0; i < 4; i++) {
                    int row = Y + dy[i];
                    int col = X + dx[i];
                    if (row < 0 || row >= N || col < 0 || col >= N) continue;
                    if (fixedMap[row][col] != 0) continue;
                    fixedMap[row][col] = 2;
                    queue.offer(new Point(row, col));
                    size--;
                }
            }
            time++;
            if (size == 0) {
                min = time;
                return;
            }
        }
    }


    public static int[][] isFixedMap() {
        int[][] fixedMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) fixedMap[i][j] = 0;
                else fixedMap[i][j]=map[i][j];
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (isSelected[i]) {
                int Y = list.get(i).row;
                int X = list.get(i).col;
                fixedMap[Y][X] = 2;
            }
        }
        return fixedMap;
    }
}