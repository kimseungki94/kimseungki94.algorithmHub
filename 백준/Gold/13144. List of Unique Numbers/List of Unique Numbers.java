import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max;
    static long count;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(count);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void Solution() {
        int lt = 0;
        int rt = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (true) {
            if (rt == N) {
                if (lt == N) break;
                else {
                    count += (rt - lt);
                    lt++;
                }

            } else if (!hashMap.containsKey(arr[rt])) {
                hashMap.put(arr[rt], 0);
                rt++;
            } else {
                count += rt - lt;
                hashMap.remove(arr[lt]);
                lt++;
            }
        }
    }
}