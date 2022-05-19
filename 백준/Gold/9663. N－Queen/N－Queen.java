import java.io.*;
import java.util.*;

public class Main {
    static int N, count;
    static int[] isColumns;

    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        isColumns = new int[N + 1];
    }

    private static boolean isAttackable(int row1, int col1, int row2, int col2) {
        if (col1 == col2) return true;
        if (row1 + col1 == row2 + col2) return true;
        if (row1 - col1 == row2 - col2) return true;
        return false;
    }

    private static void func(int limit) {
        if (limit == N + 1) {
            count++;
        } else {
            for (int col = 1; col <= N; col++) {
                boolean isAvailable = true;
                for (int row = 1; row < limit; row++) {
                    if (isAttackable(row, isColumns[row], limit, col)) {
                        isAvailable = false;
                        break;
                    }
                }
                if (isAvailable) {
                    isColumns[limit] = col;
                    func(limit + 1);
                    isColumns[limit] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func(1);
        sb.append(count);
        System.out.println(sb.toString());
    }
}
