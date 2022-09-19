import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M, K, max, sum, min;
    static int[][] map;
    static boolean[] isChecked;

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(min);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        map = new int[N][N];
        isChecked = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void Solution() {
        DFS(0, 0);
    }

    public static void DFS(int index, int limit) {
        if (limit == N / 2) {
            findDiff();
            return;
        }
        for (int i = index; i < N; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                DFS(i + 1, limit + 1);
                isChecked[i] = false;
            }
        }
    }

    public static void findDiff() {
        int value = 0;
        int diffValue = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (i == j) continue;
                if (isChecked[i] && isChecked[j]) {
                    value += map[i][j];
                    value += map[j][i];
                }
                if (!isChecked[i] && !isChecked[j]) {
                    diffValue += map[i][j];
                    diffValue += map[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(value - diffValue));
    }
}