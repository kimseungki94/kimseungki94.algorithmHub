import java.io.*;
import java.util.*;

public class Main {
    static int N, min, left, right;
    static boolean[] isSelected;
    static int[] value;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        value = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            value[i] = Integer.parseInt(st.nextToken());
        }
        isSelected = new boolean[10001];
    }

    public static void setNumber() {
        isSelected[0] = true;
        isSelected[1] = true;
        for (int i = 2; i <= 10000; i++) {
            for (int j = i * 2; j <= 10000; j += i) {
                isSelected[j] = true;
            }
        }
    }

    public static void func() {
        for (int index = 0; index < N; index++) {
            left = right = 0;
            min = Integer.MAX_VALUE;
            for (int i = 2; i <= value[index] / 2; i++) {
                if (!isSelected[i] && !isSelected[value[index] - i]) {
                    if(min>value[index]-i) {
                        min = Math.min(min, value[index] - i);
                        left = i;
                        right = value[index] - i;
                    }
                }
            }
            sb.append(left + " " + right + "\n");
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        setNumber();
        func();
        System.out.println(sb.toString());
    }
}
