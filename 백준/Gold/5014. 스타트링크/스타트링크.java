import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 전체층
        isVisited = new boolean[F + 1];
        S = Integer.parseInt(st.nextToken()); // 강호
        G = Integer.parseInt(st.nextToken()); // 스타트링크위치
        U = Integer.parseInt(st.nextToken()); //위
        D = Integer.parseInt(st.nextToken()); //아래
        int value = BFS(S);
        if (value < 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(value);
        }
    }

    public static int BFS(int firstData) {
        queue.offer(firstData);
        isVisited[firstData] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int start = queue.poll();
                if (start == G) {
                    return count;
                }
                int u = start + U;
                int d = start - D;
                if (u <= F && u >= 1 && !isVisited[u]) {
                    isVisited[u] = true;
                    queue.offer(u);
                }
                if (d <= F && d >= 1 && !isVisited[d]) {
                    isVisited[d] = true;
                    queue.offer(d);
                }
            }
            count++;
        }
        return -1;
    }
}