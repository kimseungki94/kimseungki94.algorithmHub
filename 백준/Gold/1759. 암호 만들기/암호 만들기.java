import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static int[] isSelected, lottoNums;
    static int[][] team;
    static String[] text;
    static StringBuilder sb = new StringBuilder();


    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        text = new String[C];
        for (int i = 0; i < C; i++) {
            text[i] = st.nextToken();
        }
        Arrays.sort(text);
        isSelected = new int[L + 1];
    }


    public static void func(int index, int limit) {
        if (limit == L + 1) {
            isValidate();
        } else {
            for (int i = index; i <= C; i++) {
                isSelected[limit] = i-1;
                func(i + 1, limit + 1);
                isSelected[limit] = 0;
            }
        }
    }

    private static void isValidate() {
        int mText = 0;
        int jText = 0;
        String result = "";
        for (int i = 1; i <= L; i++) {
            if (text[isSelected[i]].equals("a")
                    || text[isSelected[i]].equals("e")
                    || text[isSelected[i]].equals("i")
                    || text[isSelected[i]].equals("o")
                    || text[isSelected[i]].equals("u")) {
                mText++;
            } else {
                jText++;
            }

            result += text[isSelected[i]];
        }
        if (mText >= 1 && jText >= 2) {
            sb.append(result).append('\n');
        }
    }


    public static void main(String[] args) throws Exception {
        input();
        func(1, 1);
        System.out.println(sb.toString());
    }
}