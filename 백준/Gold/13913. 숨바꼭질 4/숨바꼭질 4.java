import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, limit, size, min, count;
    static String answerLoad;
    static int[] isVisit;
    static Queue<Point> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static class Point {
        int value;
        int time;
        String load;

        public Point(int value, int time, String load) {
            this.value = value;
            this.time = time;
            this.load = load;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        isVisit = new int[100001];
        if (N >= M) {
            System.out.println(N - M);
            for(int i=N;i>=M;i--) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());
        } else {
            BFS();
            System.out.println(min);
            System.out.println(answerLoad);
        }
    }

    public static int BFS() {
        queue.offer(new Point(N,0,N+" "));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int value = p.value;
            int time = p.time;
            String load = p.load;
            isVisit[value]=1;
            if(value==M) {
                if(min>time) {
                    min=time;
                    answerLoad=load;
                    return 0;
                }
            }

            for(int i=1;i<=3;i++) {
                int editValue=outValue(value,i);
                if(editValue<0 || editValue>100000) continue;
                if(isVisit[editValue]==0) {
                    queue.add(new Point(editValue,time+1,load+editValue+" "));
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
