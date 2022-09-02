import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int DAY = 0;
    static char[][] lake;
    static Queue<Point> waterQueue = new LinkedList<>();
    static Queue<Point> moveQueue = new LinkedList<>();

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static Point[] swan = new Point[2];

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lake = new char[N][M];

        int index = 0;
        for (int i = 0; i < N; i++) {
            String text = br.readLine();
            for (int j = 0; j < M; j++) {
                lake[i][j] = text.charAt(j);

                if (lake[i][j] == 'L') {
                    swan[index++] = new Point(i, j);
                    lake[i][j] = '.';
                }

                if (lake[i][j] == '.') {
                    waterQueue.offer(new Point(i, j));
                }
            }
        }
        Solution();

        System.out.print(DAY);
    }

    static void Solution() {
        moveQueue.add(swan[0]);

        while (true) {
            if (BFS()) break;
            else DAY++;
            melt();
        }
    }

    static boolean BFS() {
        Queue<Point> nextMoveQueue = new LinkedList<>();

        while (!moveQueue.isEmpty()) {
            Point currentSwanPoint = moveQueue.poll();

            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int Y = currentSwanPoint.row + dy[i];
                int X = currentSwanPoint.col + dx[i];

                if (X < 0 || X >= M || Y < 0 || Y >= N) continue;
                if (lake[Y][X] == 'O') continue;
                if (X == swan[1].col && Y == swan[1].row) return true;

                if (lake[Y][X] == 'X') {
                    if (!flag) {
                        nextMoveQueue.add(currentSwanPoint);
                        flag = true;
                    }
                    continue;
                }

                lake[Y][X] = 'O';
                moveQueue.add(new Point(Y, X));
            }

        }

        moveQueue = nextMoveQueue;
        return false;
    }

    static void melt() {
        int size = waterQueue.size();
        for(int t=0;t<size;t++){
            Point p = waterQueue.poll();

            for (int i = 0; i < 4; i++) {
                int Y = p.row + dy[i];
                int X = p.col + dx[i];

                if (X < 0 || X >= M || Y < 0 || Y >= N) continue;
                if(lake[Y][X] == 'X') {
                    lake[Y][X] = '.';
                    waterQueue.add(new Point(Y, X));
                }
            }
        }
    }
}