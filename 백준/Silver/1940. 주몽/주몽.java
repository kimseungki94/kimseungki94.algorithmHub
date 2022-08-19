import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, count;
    static String text,answer;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int lt = 0;
        int rt = N-1;
        while (lt<rt) {
            int value = arr[lt]+arr[rt];
            if(value==M) {
                count++;
                rt--;
                lt++;
            } else if(value<M) {
                lt++;
            } else {
                rt--;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(count);
    }
}
