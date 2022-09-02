import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point implements Comparable<Point> {
        int row;
        int col;
        int time;

        public Point(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            return this.time - o.time;
        }
    }

    static int N, M, count;
    static char[][] map;
    static boolean[][] isVisited;
    static int answerRow, answerCol;
    static int startRow, startCol;
    static PriorityQueue<Point> queue = new PriorityQueue<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        startRow = Integer.parseInt(st.nextToken()) - 1;
        startCol = Integer.parseInt(st.nextToken()) - 1;
        answerRow = Integer.parseInt(st.nextToken()) - 1;
        answerCol = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = text.charAt(j);
            }
        }
        System.out.println(BFS());
    }

    static int BFS() {
        queue.offer(new Point(startRow, startCol, 0));
        while (!queue.isEmpty()) {
            count++;
            int len = queue.size();
            for (int t = 0; t < len; t++) {
                Point point = queue.poll();
                int row = point.row;
                int col = point.col;
                int time = point.time;
                if (row == answerRow && col == answerCol) {
                    return time;
                }
                for (int i = 0; i < 4; i++) {
                    int Y = row + dy[i];
                    int X = col + dx[i];
                    if (Y < 0 || Y >= N || X < 0 || X >= M) continue;
                    if (!isVisited[Y][X]) {
                        isVisited[Y][X] = true;
                        queue.add(new Point(Y, X, map[Y][X] == '0' ? time : time + 1));
                    }
                }
            }
        }
        return -1;
    }
}