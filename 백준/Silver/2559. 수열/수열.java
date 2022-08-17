import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M,max;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        if(N==M) {
            for(int data : arr) max+=data;
        } else {
            main.Solution();
        }
        System.out.println(max);
    }

    public static void Solution() {
        int sum=0;
        for(int i=0;i<M;i++) {
            sum+=arr[i];
        }
        max = sum;
        for(int i=M;i<N;i++) {
            sum+=arr[i];
            sum-=arr[i-M];
            if(max<sum) max=sum;
        }
    }
}
