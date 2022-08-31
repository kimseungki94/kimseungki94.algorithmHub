import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, limit, size, min, count;
    static int[] isVisit;
    static Queue<Point> queue = new LinkedList<>();

    public static class Point {
        int value;
        int time;

        public Point(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        isVisit = new int[100001];
        count = 1;
        if (N >= M) {
            System.out.println(N - M);
            System.out.println(count);
        } else {
            BFS();
            System.out.println(min);
            System.out.println(count);
        }
    }

    public static int BFS() {
        queue.offer(new Point(N,0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int value = p.value;
            int time = p.time;
            isVisit[value]=1;
            if(value==M) {
                if(min>time) {
                    min=time;
                } else if(min==time) {
                    count++;
                } else {
                    continue;
                }
            }

            for(int i=1;i<=3;i++) {
                int editValue=outValue(value,i);
                if(editValue<0 || editValue>100000) continue;
                if(isVisit[editValue]==0) {
                    queue.add(new Point(editValue,time+1));
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

}
