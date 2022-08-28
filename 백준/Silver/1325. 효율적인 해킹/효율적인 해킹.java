import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static int max = Integer.MIN_VALUE;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<=N;i++) {
            list.add(new ArrayList<>(i));
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int value1 = Integer.parseInt(st.nextToken());
            int value2= Integer.parseInt(st.nextToken());
            list.get(value1).add(value2);
        }

        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            BFS(i);
        }

        for (int i = 1; i < N + 1; i++) {
            max = Math.max(result[i], max);
        }
        for (int i = 1; i <= N; i++) {
            if (max == result[i])
                sb.append(i + " ");
        }

        System.out.println(sb.toString());
    }

    static void BFS(int value) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        q.add(value);
        visit[value] = true;
        while (!q.isEmpty()) {
            int start = q.poll();
            for (int next : list.get(start)) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    result[next]++;
                }
            }
        }
    }
}
