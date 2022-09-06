import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, K, M, count, min, sum;
    private static char[][] map;
    private static int[] arr;
    private static boolean[] isVisited;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 1; i < N; i++) {
            combination(1, i);
        }
        if(min==Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        arr = new int[N + 1];
        isVisited = new boolean[N + 1];
        min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            for (int j = 0; j < len; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void combination(int index, int limit) {
        if (limit == 0) {
            Solution();
            return;
        }
        for (int i = index; i < N; i++) {
            list.add(i);
            combination(i + 1, limit - 1);
            list.remove(list.size() - 1);
        }
    }

    private static void Solution() {
        if (!BFS(list)) return;
        ArrayList<Integer> listB = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (list.contains(i)) {
                continue;
            } else {
                listB.add(i);
            }
        }
        if (!BFS(listB)) return;
        int aCount = 0;
        for (int index : list) {
            aCount += arr[index];
        }
        int bCount = sum - aCount;
        min = Math.min(min, Math.abs(aCount - bCount));

    }

    private static boolean BFS(ArrayList<Integer> road) {
        int size = road.size();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(road.get(0));
        isVisited = new boolean[N + 1];
        isVisited[road.get(0)] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int start = queue.poll();
            for (int next : graph.get(start)) {
                if (!isVisited[next] && road.contains(next)) {
                    count++;
                    isVisited[next] = true;
                    queue.offer(next);
                }
            }
        }
        if (count == size) {
            return true;
        }
        return false;
    }
}