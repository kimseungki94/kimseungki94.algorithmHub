import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, max;
    static String[] texts;
    static boolean[] isSelected = new boolean[26];
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        texts = new String[N + 1];
        max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            texts[i] = st.nextToken();
            texts[i] = texts[i].substring(4, texts[i].length() - 4);
        }
        if (K < 5) {
            max = 0;
        } else if (K == 26) {
            max = N;
        } else {
            isSelected['a' - 'a'] = true;
            isSelected['n' - 'a'] = true;
            isSelected['t' - 'a'] = true;
            isSelected['i' - 'a'] = true;
            isSelected['c' - 'a'] = true;
            func(1, 0);
        }
    }

    private static void read() {
        int size = 0;
        for (int i = 1; i <= N; i++) {
            boolean isJudge = true;
            for (int j = 0; j < texts[i].length(); j++) {
                if (!isSelected[texts[i].charAt(j) - 'a']) {
                    isJudge = false;
                    break;
                }
            }
            if (isJudge) {
                size++;
            }
        }
        max = Math.max(max, size);
    }

    public static void func(int limitCount, int start) {
        if (limitCount == K - 5 + 1) {
            read();
        } else {
            for (int i = start; i < 26; i++) {
                if (!isSelected[i]) {
                    isSelected[i] = true;
                    func(limitCount + 1, i + 1);
                    isSelected[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(max);
    }
}
