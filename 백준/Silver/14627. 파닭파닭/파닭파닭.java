import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static long min, sum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Solution();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(arr[i], min);
            sum += arr[i];
        }
    }

    public static void Solution() {
        long lt = 1;
        long rt = 1_000_000_000;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            int value = 0;
            for (int a : arr) {
                value += a / mid;
            }
            if (value >= M) {
                lt = mid + 1;
            } else if (value < M) {
                rt = mid - 1;
            }
        }
        System.out.println(sum - (rt * M));
    }
}