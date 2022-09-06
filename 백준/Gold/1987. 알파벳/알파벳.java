import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    static int N, M, K, count, size, max;
    static StringBuilder sb = new StringBuilder();
    static Deque<Character> deque = new LinkedList<>();
    static int[][] map, tempMap;
    static int[] isVieited = new int[26];
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static ArrayList<Integer> list = new ArrayList<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            for (int j = 1; j <= M; j++) {
                map[i][j] = text.charAt(j - 1) - 'A';
            }
        }
    }

    public void DFS(int row, int col, int limit) {
        if(isVieited[map[row][col]]==1) {
            max = Math.max(limit,max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int y = row + dy[i];
            int x = col + dx[i];
            isVieited[map[row][col]]=1;
            if (y >= 1 && y <= N && x >= 1 && x <= M) {
                DFS(y,x,limit+1);
            }
            isVieited[map[row][col]]=0;
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        main.DFS(1, 1,0);
        System.out.println(max);
    }
}
