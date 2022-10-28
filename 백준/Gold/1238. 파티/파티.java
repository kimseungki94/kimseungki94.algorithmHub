import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;
    static ArrayList<ArrayList<Town>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Town>> reverse_graph = new ArrayList<>();

    public static class Town {
        int end;
        int weight;

        public Town(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int getEnd() {
            return end;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverse_graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Town(end, weight));
            reverse_graph.get(end).add(new Town(start, weight));
        }

        int[] dp1 = diastria(graph);
        int[] dp2 = diastria(reverse_graph);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp1[i] + dp2[i]);
        }
        System.out.println(max);
    }

    private static int[] diastria(ArrayList<ArrayList<Town>> graph) {
        PriorityQueue<Town> pQ = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] check = new boolean[N + 1];
        dist[X] = 0;
        pQ.add(new Town(X, 0));
        while (!pQ.isEmpty()) {
            Town town = pQ.poll();
            int end = town.end;
            if (!check[end]) {
                check[end] = true;
                for (Town t : graph.get(end)) {
                    if (!check[t.end] && dist[t.end] > t.weight + dist[end]) {
                        check[town.end] = true;
                        dist[t.end] = t.weight + dist[end];
                        pQ.add(new Town(t.end, dist[t.end]));
                    }
                }
            }
        }
        return dist;
    }
}