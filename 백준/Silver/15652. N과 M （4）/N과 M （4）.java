import java.io.*;
import java.util.*;

public class Main {
    static int N, M, start;
    static int[] isSelected, isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isSelected = new int[M + 1];
    }

    public static void func(int limitNum) {
        if (limitNum == M + 1) {
            for (int index = 1; index <= M; index++) {
                sb.append(isSelected[index]).append(' ');
            }
            sb.append('\n');
        } else {
            start = isSelected[limitNum - 1];
            if (start == 0) {
                start = 1;
            }
            for (int index = start; index <= N; index++) {
                isSelected[limitNum] = index;
                func(limitNum + 1);
                isSelected[limitNum] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        func(1);
        System.out.println(sb.toString());
    }
}
