import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, limit, size, min, count;
    static int[] isVisit;
    static Queue<Point> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static class Point {
        int value;
        int time;
        String text;

        public Point(int value, int time, String text) {
            this.value = value;
            this.time = time;
            this.text = text;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisit = new int[100001];
        if (N >= M) {
            sb.append(N-M+"\n");
            while (N>=M) sb.append(N--+" ");
        } else {
            BFS();
        }
        System.out.println(sb.toString());
    }

    public static void BFS() {
        queue.offer(new Point(N, 0, N + " "));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int value = p.value;
            int time = p.time;
            String text = p.text;
            isVisit[value] = 1;
            if (value == M) {
                sb.append(time+"\n");
                sb.append(text);
                return;
            }
            for (int j = 1; j <= 3; j++) {
                int data = outValue(value, j);
                if (data < 0 || data > 100000) continue;
                if (isVisit[data] == 0) {
                    String textData = text+data+" ";
                    queue.offer(new Point(data, time + 1, textData));
                }
            }
        }
    }

    public static int outValue(int value, int button) {
        if (button == 1) return value + 1;
        if (button == 2) return value - 1;
        if (button == 3) return value * 2;
        return 1;
    }
}
