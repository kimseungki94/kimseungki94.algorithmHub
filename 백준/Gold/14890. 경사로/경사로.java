import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, K, M, count, min, sum, max;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.println(count);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void Solution() {
        for (int i = 0; i < N; i++) {
            // 행 검사
            if (isCheck(i, 0, 1)) {
                count++;
                // 열 검사
            }
            if (isCheck(0, i, 2)) {
                count++;
            }
        }
    }

    private static boolean isCheck(int row, int col, int menu) {
        int[] arr = new int[N];
        boolean[] isVisited = new boolean[N];
        if (menu == 1) {
            for (int i = 0; i < N; i++) {
                arr[i] = map[row][i];
            }
        } else {
            for (int i = 0; i < N; i++) {
                arr[i] = map[i][col];
            }
        }
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) continue;
            else if (Math.abs(arr[i] - arr[i + 1]) == 1) {
                // 내리막길
                if (arr[i] - 1 == arr[i + 1]) {
                    for (int j = i + 1; j < i + 1 + M; j++) {
                        if (j >= N || arr[i + 1] != arr[j] || isVisited[j]) return false;
                        isVisited[j] = true;
                    }
                }
                // 오르막길
                else if (arr[i] + 1 == arr[i + 1]) {
                    for (int j = i; j > i - M; j--) {
                        if (j < 0 || arr[i] != arr[j] || isVisited[j]) return false;
                        isVisited[j] = true;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}