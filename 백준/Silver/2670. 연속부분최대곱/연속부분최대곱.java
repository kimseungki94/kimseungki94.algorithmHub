import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static double[] arr,dp;
    static long min, sum;
    static double value;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Solution();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new double[N];
        dp = new double[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Double.parseDouble(st.nextToken());
        }
    }

    public static void Solution() {
        dp[0]=arr[0];
        for(int i=1;i<N;i++) {
            dp[i]=Math.max(dp[i-1]*arr[i],arr[i]);
            value=Math.max(dp[i],value);
        }
        System.out.println(String.format("%.3f",value));
    }
}