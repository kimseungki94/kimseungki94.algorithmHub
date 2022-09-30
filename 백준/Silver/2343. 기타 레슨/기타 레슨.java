import java.io.*;
import java.util.*;

public class Main {
    static int N, M, min, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.println(min);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
    }

    public static void Solution() {
        int lt, rt, mid;
        lt = 0;
        rt = sum;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            int value = 1;
            int countSum = 0;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (countSum + arr[i] > mid) {
                    value++;
                    countSum = 0;
                }
                countSum += arr[i];
                if(arr[i]>mid) flag=true;
            }
            if (value > M || flag) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
                min = mid;
            }
        }
    }
}