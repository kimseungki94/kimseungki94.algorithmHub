import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

public class Main {

    private static int N, K, M, count;

    public static void main(String[] args) throws IOException {
        input();
        DFS(64,N);
        System.out.println(count);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    private static void DFS(int value, int limit) {
        while (limit!=0) {
            if(value>limit) {
                value/=2;
            } else {
                limit=limit-value;
                count++;
            }
        }
    }
}