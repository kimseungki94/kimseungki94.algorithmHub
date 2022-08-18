import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, max;
    static String[] arr, answer;
    static StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String key = st.nextToken();
                String value = st.nextToken();
                hashMap.put(value, hashMap.getOrDefault(value, 1) + 1);
            }
            int count=1;
            for (String value : hashMap.keySet()) {
                count*=hashMap.get(value);
            }
            sb.append(count-1+"\n");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(sb.toString());
    }
}
