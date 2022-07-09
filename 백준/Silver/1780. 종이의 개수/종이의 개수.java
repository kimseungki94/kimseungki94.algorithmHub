import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count, count1, count0, countMinus1;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0, N);
        System.out.println(countMinus1);
        System.out.println(count0);
        System.out.println(count1);
    }

    public static void DFS(int row, int col, int size) {
        if (isFind(row, col, size)) {
            if (map[row][col] == -1) {
                countMinus1++;
            } else if (map[row][col] == 1) {
                count1++;
            } else if (map[row][col] == 0) {
                count0++;
            }
            return;
        }

        int len = size / 3;
        DFS(row, col, len);
        DFS(row, col + len, len);
        DFS(row, col + len * 2, len);

        DFS(row + len, col, len);
        DFS(row + len, col + len, len);
        DFS(row + len, col + len * 2, len);

        DFS(row + len * 2, col, len);
        DFS(row + len * 2, col + len, len);
        DFS(row + len * 2, col + len * 2, len);
    }

    public static boolean isFind(int row, int col, int size) {
        int value = map[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}