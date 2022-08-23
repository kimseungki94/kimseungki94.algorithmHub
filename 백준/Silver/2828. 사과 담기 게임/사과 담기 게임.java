import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
        System.out.println(count);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
    }
    public void Solution() {
        int lt = 1;
        int rt = M;
        for(int i=0;i<K;i++) {
            while (true) {
                if(arr[i]>=lt && arr[i]<=rt) {
                    break;
                } else if(arr[i]<lt) {
                    lt--;
                    rt--;
                    count++;
                }
                else {
                    lt++;
                    rt++;
                    count++;
                }
            }
        }
    }
}
