import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, M, count, min;
    private static boolean flag = false;
    private static int essentialA, essentialB, essentialC, essentialD;
    private static boolean[][] isVisited;
    private static char[][] map;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.println(min);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }
        min = Integer.MAX_VALUE;
    }

    private static void Solution() {
        for (int bit = 0; bit < (1 << N); bit++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int back = 0;
                for (int j = 0; j < N; j++) {
                    char c = map[i][j];
                    if ((bit & (1 << j)) != 0) c = change(c);
                    if (c == 'T') back++;
                }
                sum += Math.min(back, N - back);
            }
            min = Math.min(sum, min);
        }
    }

    static char change(char c) {
        if (c == 'T') return 'H';
        else return 'T';
    }
}