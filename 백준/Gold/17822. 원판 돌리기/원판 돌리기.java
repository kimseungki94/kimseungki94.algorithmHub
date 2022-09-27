import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M, T;
    static boolean isFindSameNumber = false;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int x, d, k;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= N; j++) {
                if (j % x == 0) {
                    rotate(j - 1, d, k);
                }
            }
            checkPlate();
        }
        System.out.println(sumData());
    }

    public static void rotate(int x, int d, int k) {
        int[] rotateXPlate = new int[M];
        int index;
        for (int i = 0; i < M; i++) {
            index = calculateIndex(d, i, k);
            rotateXPlate[index] = map[x][i];
        }
        map[x] = rotateXPlate;
    }

    public static void checkPlate() {
        boolean isDelete = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isFindSameNumber = false;
                if (map[i][j] != 0) {
                    DFS(i, j, map[i][j]);
                }
                if (isFindSameNumber) {
                    map[i][j] = 0;
                    isDelete = true;
                }
            }
        }
        if (!isDelete) {
            noDelete();
        }

    }

    public static void DFS(int x, int y, int num) {
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = (y + dy[i]) % M;
            if (ny < 0) {
                ny = M - 1;
            }
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (map[nx][ny] == num) {
                isFindSameNumber = true;
                map[nx][ny] = 0;
                DFS(nx, ny, num);
            }
        }
    }

    public static int calculateIndex(int d, int i, int k) {
        if (d == 0) {
            return (i + k) % M;
        }
        if (i - k < 0) {
            return M + (i - k);
        }
        return i - k;
    }

    public static void noDelete() {
        double sum = 0;
        int totalNumber = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    sum += map[i][j];
                    totalNumber++;
                }
            }
        }

        double average = sum / totalNumber;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && map[i][j] < average) {
                    map[i][j] += 1;
                } else if (map[i][j] != 0 && map[i][j] > average) {
                    map[i][j] -= 1;
                }
            }
        }
    }

    public static int sumData() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }
}