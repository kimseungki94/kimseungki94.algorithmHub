import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K, count, size;
    static int[] arr = new int[10];
    static StringBuilder[] sb;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        main.DFS(0,arr.length-1,0);
        for(StringBuilder s : sb) {
            System.out.println(s.toString());
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2,N)-1;
        arr = new int[size];
        sb = new StringBuilder[N];
        for(int i=0;i<N;i++) {
            sb[i]=new StringBuilder();
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
    }

    public void DFS(int start, int end, int count) {
        if(count==N) {
            return;
        }
        int mid = (start+end)/2;
        sb[count].append(arr[mid]).append(" ");
        DFS(start,mid-1,count+1);
        DFS(mid+1,end,count+1);
    }
}