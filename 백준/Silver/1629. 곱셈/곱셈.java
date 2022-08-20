import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long N, M, K;

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        System.out.println(Solution(M));
    }

    public long Solution(long limit) {
        if(limit==1) {
            return N%K;
        }
        long temp = Solution(limit/2);
        if(limit%2==1) {
            return (temp*temp%K)*N%K;
        } else {
            return (temp*temp)%K;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
    }
}
