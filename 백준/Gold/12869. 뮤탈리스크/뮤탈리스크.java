import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, K, min, max, count;
    static int[] arr, answer;
    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        input();
        DFS(arr, 0);
        System.out.println(count);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[3];
        dp = new int[61][61][61];
        count = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void DFS(int[] scv, int limit) {
        if (count <= limit) return;
        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];
        if (dp[s1][s2][s3] != 0 && dp[s1][s2][s3] <= limit) return;
        dp[s1][s2][s3] = limit;
        if (s1 == 0 && s2 == 0 && s3 == 0) {
            count = Math.min(count, limit);
            return;
        }
        for (int i = 0; i < 6; i++) {
            DFS(new int[]{Math.max(s1 - attack[i][0], 0), Math.max(s2 - attack[i][1], 0), Math.max(s3 - attack[i][2], 0)}, limit + 1);
        }
    }
}