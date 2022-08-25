import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue;
    static int jCount, mCount;
    static int[] arrTwo, arrFive, map;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(sb.toString());
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            long five = 0L;
            for (int i = 5; i <=value; i*=5) {
                five+=value/i;
            }
            sb.append(five).append("\n");
        }
    }

    public void Solution() {
    }
}
