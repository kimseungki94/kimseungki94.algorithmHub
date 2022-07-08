import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] isVisited;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    public static class Point {
        int rRow;
        int rCol;
        int bRow;
        int bCol;

        public Point(int rRow, int rCol, int bRow, int bCol) {
            this.rRow = rRow;
            this.rCol = rCol;
            this.bRow = bRow;
            this.bCol = bCol;
        }
    }

    public static class Turn {
        int row;
        int col;
        int cost;

        public Turn(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int rRow,rCol,bRow,bCol;
        rRow = rCol = bRow = bCol = 0;
        map = new char[N][M];
        isVisited = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    rRow = i;
                    rCol = j;
                }
                else if (map[i][j] == 'B') {
                    bRow = i;
                    bCol = j;
                }
            }
        }
        System.out.println(BFS(rRow,rCol,bRow,bCol));
    }

    public static int BFS(int rRow,int rCol,int bRow, int bCol) {
        Queue<Point> queue = new LinkedList<>();
        int time = 1;
        queue.offer(new Point(rRow, rCol, bRow, bCol));
        isVisited[rRow][rCol][bRow][bCol] = true;
        Turn rTurn = null;
        Turn bTurn = null;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                Point point = queue.poll();
                for (int i = 0; i < 4; i++) {
                    rTurn = move(point.rRow, point.rCol, 0, i);
                    bTurn = move(point.bRow, point.bCol, 0, i);

                    if (map[bTurn.row][bTurn.col] == 'O') continue;
                    if (map[rTurn.row][rTurn.col] == 'O') return 1;
                    if (bTurn.row == rTurn.row && bTurn.col == rTurn.col) {
                        if (rTurn.cost > bTurn.cost) {
                            rTurn.row -= dy[i];
                            rTurn.col -= dx[i];
                        } else {
                            bTurn.row -= dy[i];
                            bTurn.col -= dx[i];
                        }
                    }
                    if (isVisited[rTurn.row][rTurn.col][bTurn.row][bTurn.col]) continue;

                    isVisited[rTurn.row][rTurn.col][bTurn.row][bTurn.col] = true;
                    queue.offer(new Point(rTurn.row, rTurn.col, bTurn.row, bTurn.col));

                }
            }
            if (++time > 10) return 0;
        }
        return 0;
    }

    public static Turn move(int row, int col, int work, int button) {
        int rr = row;
        int cc = col;
        while (map[rr + dy[button]][cc + dx[button]] != '#' && map[rr][cc] != 'O') {
            rr += dy[button];
            cc += dx[button];
            work++;
        }
        return new Turn(rr, cc, work);
    }
}