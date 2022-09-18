import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, max, sum;
    static long count;
    static int[] arr;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static ArrayList<Integer> airconRow = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(sum);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sum = 2;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
                if (map[i][j] == -1) {
                    airconRow.add(i);
                }
            }
        }
    }

    public static void Solution() {
        for (int i = 0; i < K; i++) {
            map = activateDirty();
            activateAirCon();
        }
        isCheckSum();
    }

    private static int[][] activateDirty() {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 0) {
                    tempMap[i][j] += map[i][j];
                    for (int k = 0; k < 4; k++) {
                        int row = i + dy[k];
                        int col = j + dx[k];
                        if (row < 0 || row >= N || col < 0 || col >= M) continue;
                        if (map[row][col] == -1) continue;
                        tempMap[row][col] += (map[i][j] / 5);
                        tempMap[i][j] -= (map[i][j] / 5);
                    }
                } else {
                    tempMap[i][j] = map[i][j];
                }
            }
        }
        return tempMap;
    }

    private static void activateAirCon() {
        int top = airconRow.get(0);
        for (int i = top - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < M - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for(int i=0;i<top;i++) {
            map[i][M-1]=map[i+1][M-1];
        }
        for(int i=M-1;i>1;i--) {
            map[top][i]=map[top][i-1];
        }
        map[top][1]=0;

        int bottom = airconRow.get(1);
        for(int i=bottom+1;i<N-1;i++) {
            map[i][0]=map[i+1][0];
        }
        for(int i=0;i<M-1;i++) {
            map[N-1][i]=map[N-1][i+1];
        }
        for(int i=N-1;i>bottom;i--) {
            map[i][M-1]=map[i-1][M-1];
        }
        for(int i=M-1;i>1;i--) {
            map[bottom][i]=map[bottom][i-1];
        }
        map[bottom][1]=0;
    }

    public static void isCheckSum() {
        sum = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
        }
    }
}