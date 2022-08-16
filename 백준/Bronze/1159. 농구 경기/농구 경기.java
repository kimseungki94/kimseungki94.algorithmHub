import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, min, max, count, sum;
    static int[] carA, carB, carC, fee, arr;
    static char[] first;
    static boolean flag = false;
    static String text;
    static StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[26];
        first=new char[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            first[i] = st.nextToken().toCharArray()[0];
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
    }

    public static void Solution() {
        isCount();
        isCheck();
    }
    public static void isCount() {
        for(int i=0;i<N;i++) {
            arr[first[i]-'a']++;
        }
    }
    public static void isCheck() {
        for(int i=0;i<26;i++) {
            if(arr[i]>=5) {
                flag=true;
                sb.append((char)(i+'a'));
            }
        }
        if(flag) {
            sb.toString();
        } else {
            System.out.println("PREDAJA");
        }
        System.out.println(sb.toString());
    }
}
