import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T, count;
    static int[] arr1, arr2;
    static HashMap<Integer,Integer> hashMapA = new HashMap<>();
    static HashMap<Integer,Integer> hashMapB = new HashMap<>();
    static boolean[] judge1, judge2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.println(count);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr1 = new int[N];
        judge1 = new boolean[N+1];
        arr2 = new int[M];
        judge2 = new boolean[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
            hashMapA.put(arr1[i],1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
            hashMapB.put(arr2[i],1);
        }
    }

    public static void Solution() {
        for(int i=0;i<N;i++) {
            if(hashMapB.getOrDefault(arr1[i],0)==0) {
                count++;
            }
        }
        for(int i=0;i<M;i++) {
            if(hashMapA.getOrDefault(arr2[i],0)==0) {
                count++;
            }
        }
    }
}