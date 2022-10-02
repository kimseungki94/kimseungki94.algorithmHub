import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T, count;
    static int[] arr, data;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            data = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            Arrays.sort(data);
            Solution();
        }
    }

    public static void Solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i] > data[j]) {
                    count++;
                } else {
                    break;
                }
            }
        }
        sb.append(count).append("\n");
        count=0;
    }
}