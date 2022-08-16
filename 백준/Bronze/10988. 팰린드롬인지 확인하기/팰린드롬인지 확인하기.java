import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, min, max, count, sum;
    static int[] carA, carB, carC, fee, arr;
    static boolean flag = false;
    static String text;
    static StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        text = st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
    }

    public static void Solution() {
        int len = text.length();
        char[] c = text.toCharArray();
        for (int i = 0; i < len; i++) {
            if(c[i]!=c[len-1-i]) {
                flag=true;
                break;
            }
        }
        if(flag) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
