import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        Solution();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }
    }

    public static void Solution() {
        int lt, rt, countMember, sum, mid;
        lt = 1;
        rt = max;
        countMember = 0;
        while (lt <= rt) {
            sum = 0;
            mid = (lt + rt) / 2;
            for (int i = 0; i < M; i++) {
                sum += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    sum++;
                }
            }
            if (sum > N) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
                countMember = mid;
            }
        }
        System.out.println(countMember);
    }
}