import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, answer;
    static int[] arr, dp;
    static StringBuilder sb = new StringBuilder();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void DP() {
        dp[0]=arr[0];
        if(N==1) return;
        dp[1]=arr[1]+arr[0];
        if(N==2) return;
        dp[2]=Math.max(arr[0],arr[1])+arr[2];
        if(N==3) return;
        for(int i=3;i<N;i++) {
            dp[i] = Math.max(dp[i-2],dp[i-3]+arr[i-1])+arr[i];
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        main.DP();
        System.out.println(dp[N-1]);
    }
}
