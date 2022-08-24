import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue;
    static int jCount, mCount;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
        System.out.println(sb.toString());
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        char lastChar;
        int lastCount = 0;
        while (!text.equals("end")) {
            boolean flag = mContainsCheck(text);
            lastChar = text.charAt(0);
            lastCount = 1;
            jCount = 0;
            mCount = 0;
            jCheck(text.charAt(0));
            for (int i = 1; i < text.length(); i++) {
                if(!flag) break;
                if (lastChar == text.charAt(i)) {
                    lastCount++;
                    jCheck(text.charAt(i));
                } else {
                    lastChar = text.charAt(i);
                    lastCount = 1;
                    jCheck(text.charAt(i));
                }
                if (lastCount == 2 && lastChar != 'o' && lastChar != 'e') {
                    flag = false;
                    break;
                }
                if (lastCount == 3 || jCount == 3 || mCount == 3) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append("<").append(text).append("> ").append("is acceptable.\n");
            } else {
                sb.append("<").append(text).append("> ").append("is not acceptable.\n");
            }
            st = new StringTokenizer(br.readLine());
            text = st.nextToken();
        }
    }

    public void jCheck(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            jCount=0;
            mCount++;
        }
        else {
            mCount = 0;
            jCount++;
        }
    }
    public boolean mContainsCheck(String text) {
        if(text.contains("e") || text.contains("a") || text.contains("i") || text.contains("o") || text.contains("u")) {
            return true;
        }
        else return false;
    }

    public void Solution() {
    }
}
