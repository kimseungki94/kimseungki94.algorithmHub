import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static int[] arr, weight, value;
    static int[][] data, dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.println(dp[N][M]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weight = new int[N + 1];
        value = new int[N + 1];
        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void Solution() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (weight[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }
}