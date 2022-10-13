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
        System.out.println(dp[N]);
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
    }
    public static void Solution() {
        for(int i=2;i<=N;i++) {
            dp[i]=dp[i-1]+1;
            if(i%3==0) {
                dp[i]=Math.min(dp[i],dp[i/3]+1);
            }
            if(i%2==0) {
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            }
        }
        DP(N);
    }

    public static void DP(int data) {
        if(data==0) return;
        sb.append(data).append(" ");
        if(data>0 && dp[data-1]==dp[data]-1) {
            DP(data-1);
        } else if(data%3==0 && dp[data/3]==dp[data]-1) {
            DP(data/3);
        } else if(data%2==0 && dp[data/2]==dp[data]-1) {
            DP(data/2);
        }
    }
}