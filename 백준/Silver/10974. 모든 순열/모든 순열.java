import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C, max;
    static int[][] map;
    static int[] isNumbers, isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        isNumbers = new int[N + 1];
        isSelected = new int[N + 1];
    }


    public static void func(int limit) {
        if (limit == N + 1) {
            for (int i = 1; i <= N; i++) sb.append(isNumbers[i]).append(' ');
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {
                if (isSelected[i] == 1) continue;
                else {
                    isSelected[i] = 1;
                    isNumbers[limit] = i;
                    func(limit + 1);
                    isSelected[i] = 0;
                    isNumbers[limit] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func(1);
        System.out.println(sb.toString());
    }
}
