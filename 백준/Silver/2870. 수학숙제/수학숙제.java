import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue;
    static int jCount, mCount;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
        System.out.println(sb.toString());
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }
    }

    public void Solution() {
        List<BigInteger> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sb.delete(0, sb.length());
            for(int j=0;j<arr[i].length();j++) {
                while (Character.isDigit(arr[i].charAt(j))) {
                    sb.append(arr[i].charAt(j));
                    j++;
                    if(j==arr[i].length()) break;
                }
                if(sb.length()>0) {
                    list.add(new BigInteger(sb.toString()));
                }
                sb.delete(0,sb.length());
            }
        }
        Collections.sort(list);
        for(BigInteger data : list) sb.append(data).append(" ").append("\n");
    }
}
