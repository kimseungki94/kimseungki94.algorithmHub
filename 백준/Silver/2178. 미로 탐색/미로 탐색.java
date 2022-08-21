import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static Queue<Point> queue = new LinkedList<>();
    static int N, M, count;
    static int[][] map;
    static boolean[][] isSelected;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};


    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isSelected = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = value.charAt(j)-'0';
            }
        }
    }

    public int Solution() {
        count = 1;
        queue.offer(new Point(0, 0));
        isSelected[0][0]=true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int t = 0; t < len; t++) {
                Point point = queue.poll();
                if (point.row == N - 1 && point.col == M - 1) {
                    return count;
                }
                for (int i = 0; i < 4; i++) {
                    int Y = point.row+dy[i];
                    int X = point.col+dx[i];
                    if (Y >= 0 && Y < N && X >= 0 && X < M && map[Y][X] == 1 && !isSelected[Y][X]) {
                        isSelected[Y][X]=true;
                        queue.add(new Point(Y, X));
                    }
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(main.Solution());
    }
}
