import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, dp;
    static int[][] data;

    public static void main(String[] args) throws IOException {
        input();
        Solution();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        data = new int[N][2];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void Solution() {
        Arrays.sort(data, ((o1, o2) -> o1[0] - o2[0]));
        for (int i = 0; i < N; i++) {
            dp[i] = Math.max(dp[i], findValue(i));
        }
        int value = 0;
        for (int i = 0; i < N; i++) {
            value = Math.max(value, dp[i]);
        }
        System.out.println(N - value);
    }

    private static int findValue(int index) {
        if (dp[index] == 0) {
            dp[index] = 1;
            for (int i = index + 1; i < N; i++) {
                if (data[index][1] < data[i][1]) {
                    dp[index] = Math.max(dp[index], findValue(i) + 1);
                }
            }
        }
        return dp[index];
    }
}