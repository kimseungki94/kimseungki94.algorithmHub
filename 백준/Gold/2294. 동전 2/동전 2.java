import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static int[] arr, dp;
    static int[][] data;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        if(dp[M]==Integer.MAX_VALUE-1) {
            System.out.println(-1);
        } else{
            System.out.println(dp[M]);
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
    }

    public static void Solution() {
        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j <= M; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
    }
}