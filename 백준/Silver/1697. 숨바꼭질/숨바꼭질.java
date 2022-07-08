import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, limit, size;
    static int[] isVisit;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisit = new int[100001];
        if(N >= M)
            System.out.println(N-M);
        else
            System.out.println(BFS());
    }

    public static int BFS() {
        queue.offer(N);
        isVisit[N]=1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int start = queue.poll();
                for (int j = 1; j <= 3; j++) {
                    int value = outValue(start, j);
                    if(value==M) return isVisit[start];
                    if (value >= 0 && value <= 100000 && isVisit[value] == 0) {
                        isVisit[value]=isVisit[start]+1;
                        queue.offer(value);
                    }
                }
            }
        }
        return 0;
    }

    public static int outValue(int value, int button) {
        if (button == 1) return value + 1;
        if (button == 2) return value - 1;
        if (button == 3) return value * 2;
        return 1;
    }

    public static void DFS(int start, int count) {
        if (limit == count) {
            if (start == M) size++;
            return;
        }
    }
}
