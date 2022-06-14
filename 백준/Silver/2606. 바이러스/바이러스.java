import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, count;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        arr = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }
    }

    public void DFS(int index) {
        arr[index]=1;
        for(int x : list.get(index)) {
            if(arr[x]==0) {
                arr[x]=1;
                count++;
                DFS(x);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        main.DFS(1);
        System.out.println(count);
    }
}