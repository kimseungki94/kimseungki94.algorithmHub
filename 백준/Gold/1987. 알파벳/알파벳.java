import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C, max;
    static int[][] map, isSelected;
    static int[] isNumbers;
    static StringBuilder sb;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R + 1][C + 1];
        isSelected = new int[R + 1][C + 1];
        isNumbers = new int[R * C + 1];
        for (int i = 1; i <= R; i++) {
            String text = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = text.charAt(j - 1) - 'A' + 1;
            }
        }
        max = Integer.MIN_VALUE;
    }

    public static boolean isValidate(int row, int col, int limit) {
        if (limit == 1) {
            return true;
        }
        if (isSelected[row][col] == 1) {
            return false;
        }
        for (int i = 1; i < limit; i++) {
            if (isNumbers[i] == map[row][col]) {
                return false;
            }
        }
        return true;
    }

    public static void func(int row, int col, int limit) {
        if (limit == R * C + 1) {
            max = Math.max(max, limit-1);
            return;
        } else {
            if (isValidate(row, col, limit)) {
                isSelected[row][col] = 1;
                isNumbers[limit] = map[row][col];
                if (row - 1 > 0) {
                    func(row - 1, col, limit + 1);
                }
                if (row + 1 < R + 1) {
                    func(row + 1, col, limit + 1);
                }
                if (col - 1 > 0) {
                    func(row, col - 1, limit + 1);
                }
                if (col + 1 < C + 1) {
                    func(row, col + 1, limit + 1);
                }
                isSelected[row][col] = 0;
            } else {
                max = Math.max(max, limit-1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func(1, 1, 1);
        System.out.println(max);
    }
}
