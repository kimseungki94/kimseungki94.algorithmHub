import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M, K;
    public static int[][] map;
    public static int[][] copyMap;
    public static int[] output;
    public static ArrayList<CCTV> cctvList;
    public static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌 시계방향 순서
    public static int[] dy = {0, 1, 0, -1};
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        DFS(0);
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctvList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new CCTV(map[i][j], i, j));
                }
            }
        }
        K = cctvList.size();
        output = new int[K];
    }

    public static void DFS(int index) {
        if (index == K) {
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < K; i++) {
                BFS(cctvList.get(i), output[i]);
            }
            find();
            return;
        }

        for (int i = 0; i < 4; i++) {
            output[index] = i;
            DFS(index + 1);
        }
    }

    public static void BFS(CCTV cctv, int d) {
        int cctvNum = cctv.num;

        if (cctvNum == 1) {
            if (d == 0) watch(cctv, 0); // 상
            else if (d == 1) watch(cctv, 1); // 우
            else if (d == 2) watch(cctv, 2); // 하
            else if (d == 3) watch(cctv, 3); // 좌
        } else if (cctvNum == 2) {
            if (d == 0 || d == 2) {
                watch(cctv, 0);
                watch(cctv, 2); // 상하
            } else {
                watch(cctv, 1);
                watch(cctv, 3); // 좌우
            }
        } else if (cctvNum == 3) {
            if (d == 0) {
                watch(cctv, 0); // 상우
                watch(cctv, 1);
            } else if (d == 1) {
                watch(cctv, 1); // 우하
                watch(cctv, 2);
            } else if (d == 2) {
                watch(cctv, 2); // 하좌
                watch(cctv, 3);
            } else if (d == 3) {
                watch(cctv, 0); // 좌상
                watch(cctv, 3);
            }
        } else if (cctvNum == 4) {
            if (d == 0) {
                watch(cctv, 0); // 좌상우
                watch(cctv, 1);
                watch(cctv, 3);
            } else if (d == 1) {
                watch(cctv, 0); // 상우하
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (d == 2) {
                watch(cctv, 1); // 좌하우
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (d == 3) {
                watch(cctv, 0); // 상좌하
                watch(cctv, 2);
                watch(cctv, 3);
            }
        } else if (cctvNum == 5) { // 상우하좌
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    public static void watch(CCTV cctv, int direction) {
        Queue<CCTV> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(cctv);
        visited[cctv.x][cctv.y] = true;

        while (!queue.isEmpty()) {
            CCTV c = queue.poll();
            int row = c.y + dy[direction];
            int col = c.x + dx[direction];
            if (col < 0 || col >= N || row < 0 || row >= M || copyMap[col][row] == 6) {
                break;
            }

            if (copyMap[col][row] == 0) {
                copyMap[col][row] = -1;
                queue.add(new CCTV(cctv.num, col, row));
            } else {
                queue.add(new CCTV(cctv.num, col, row));
            }
        }
    }

    public static void find() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        answer = Math.min(answer, cnt);
    }


}

class CCTV {
    int num;
    int x;
    int y;

    CCTV(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}