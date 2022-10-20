import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static int[] arr, weight, value;
    static boolean[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.print(sb.toString());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new boolean[N][N];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Solution();
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(dp[a][b]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
    }

    public static void Solution() {
        for(int i=0;i<N;i++) {
            dp[i][i]=true;
        }
        for(int i=0;i<N-1;i++) {
            if(arr[i]==arr[i+1]) {
                dp[i][i+1]=true;
            }
        }
        for(int i=2;i<N;i++) {
            for(int j=0;j<N-i;j++) {
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]) {
                    dp[j][j+i]=true;
                }
            }
        }
    }
}