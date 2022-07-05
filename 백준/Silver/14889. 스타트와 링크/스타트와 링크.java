import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    static int N, M, K, count, size, max, sum, min;
    static StringBuilder sb = new StringBuilder();
    static int[][] map, tempMap;
    static int[] arr;
    static boolean flag = false;
    static ArrayList<Integer> list = new ArrayList<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                sum += value;
            }
        }
        arr = new int[N + 1];
    }

    public void DFS(int limit, int index) {
        if (min == 0) return;
        if (limit == N / 2) {
            int data = 0;
            int data2 = 0;
            for (int i = 1; i < N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (arr[i] == 1 && arr[j] == 1) {
                        data += map[i][j] + map[j][i];
                    }
                    if (arr[i] == 0 && arr[j] == 0) {
                        data2 += map[i][j] + map[j][i];
                    }
                }

            }
            min = Math.min(min, Math.abs(data - data2));
            return;
        }
        for (int i = index; i <= N; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                DFS(limit + 1, i + 1);
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        main.DFS(0, 1);
        System.out.println(min);
    }
}
