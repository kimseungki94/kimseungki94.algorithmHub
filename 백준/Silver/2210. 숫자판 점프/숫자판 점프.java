import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count;
    static int[][] map = new int[5][5];
    static boolean[] isSelected = new boolean[1000000];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < 5; m++) {
                map[i][m] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                DFS(0, i, j, 0);
            }
        }
        System.out.println(count);
    }

    public static void DFS(int limit, int row, int col, int value) {
        if (limit == 6) {
            if (!isSelected[value]) {
                isSelected[value] = true;
                count++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int Y = row + dy[i];
            int X = col + dx[i];
            if (Y >= 0 && Y < 5 && X >= 0 && X < 5) {
                DFS(limit + 1, Y, X, value * 10 + map[Y][X]);
            }
        }
    }
}