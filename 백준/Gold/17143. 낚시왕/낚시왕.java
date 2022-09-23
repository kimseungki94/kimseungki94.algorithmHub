import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, K;
    public static Shark[][] map;
    public static int answer = 0;
    public static int dy[] = {-1, 0, 1, 0};
    public static int dx[] = {0, -1, 0, 1};

    static class Shark {
        int row;
        int col;
        int move;
        int direction;
        int size;

        public Shark(int row, int col, int move, int direction, int size) {
            this.row = row;
            this.col = col;
            this.move = move;
            this.direction = direction;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Shark[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            if (direction == 1)
                direction = 0;
            else if (direction == 4)
                direction = 1;

            map[row - 1][col - 1] = new Shark(row - 1, col - 1, move, direction, size); // 격자판에 상어 저장
        }
    }

    public static void Solution() {
        for (int col = 0; col < M; col++) {
            personMove(col);
            sharkMove();
        }
    }

    public static void personMove(int col) {
        for (int row = 0; row < N; row++) {
            if (map[row][col] != null) {
                answer += map[row][col].size;
                map[row][col] = null;
                break;
            }
        }
    }

    public static void sharkMove() {
        Queue<Shark> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != null) {
                    queue.add(new Shark(i, j, map[i][j].move, map[i][j].direction, map[i][j].size));
                }
            }
        }

        map = new Shark[N][M];

        while (!queue.isEmpty()) {
            Shark shark = queue.poll();

            int speed = shark.move;
            if (shark.direction == 0 || shark.direction == 2)
                speed %= (N - 1) * 2;
            else if (shark.direction == 1 || shark.direction == 3)
                speed %= (M - 1) * 2;

            for (int s = 0; s < speed; s++) {
                int newR = shark.row + dy[shark.direction];
                int newC = shark.col + dx[shark.direction];

                if (newR < 0 || newR >= N || newC < 0 || newC >= M) {
                    shark.row -= dy[shark.direction];
                    shark.col -= dx[shark.direction];
                    shark.direction = (shark.direction + 2) % 4; // 방향 반대로
                    continue;
                }

                shark.row = newR;
                shark.col = newC;
            }

            if (map[shark.row][shark.col] != null) {
                if (map[shark.row][shark.col].size < shark.size) {
                    map[shark.row][shark.col] = new Shark(shark.row, shark.col, shark.move, shark.direction, shark.size);
                }
            } else {
                map[shark.row][shark.col] = new Shark(shark.row, shark.col, shark.move, shark.direction, shark.size);
            }
        }
    }

}

