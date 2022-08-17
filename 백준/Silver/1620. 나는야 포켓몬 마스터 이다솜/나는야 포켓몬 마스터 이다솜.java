import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, max;
    static String[] arr,answer;
    static StringBuilder sb = new StringBuilder();
    static HashMap<String, Integer> hashMap = new HashMap<>();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N + 1];
        answer = new String[M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }
        for (int i = 1; i <= N; i++) {
            hashMap.put(arr[i], i);
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            answer[i]=st.nextToken();
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
        System.out.println(sb.toString());
    }

    public static void Solution() {
        for(int i=0;i<M;i++) {
            if(Character.isDigit(answer[i].charAt(0))) {
                sb.append(arr[Integer.parseInt(answer[i])]+"\n");
            } else {
                sb.append(hashMap.get(answer[i])+"\n");
            }
        }
    }
}
