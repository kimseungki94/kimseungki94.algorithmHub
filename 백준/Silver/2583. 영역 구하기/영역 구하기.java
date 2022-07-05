import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    static int N, M, K, count, size;
    static StringBuilder sb = new StringBuilder();
    static Deque<Character> deque = new LinkedList<>();
    static int[][] map,tempMap;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static ArrayList<Integer> list = new ArrayList<>();

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) + 1;
            int startY = Integer.parseInt(st.nextToken()) + 1;
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for (int row = startY; row <= endY; row++) {
                for (int col = startX; col <= endX; col++) {
                    map[row][col] = 1;
                }
            }
        }
    }

    public void DFS(int row, int col) {
        size++;
        map[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int y = row + dy[i];
            int x = col + dx[i];
            if (y >= 1 && y <= N && x >= 1 && x <= M && map[y][x] == 0) {
                DFS(y, x);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                size = 0;
                if (map[i][j] == 0) {
                    count++;
                    main.DFS(i, j);
                    list.add(size);
                }
            }
        }
        sb.append(count+"\n");
        Collections.sort(list);
        for(int i : list) {
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}
