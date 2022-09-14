import java.io.*;
import java.util.*;

public class Main {
    static int N, count, max;
    static ArrayList<Point> list = new ArrayList<>();
    public static class Point {
        int start;
        int interval;

        public Point(int start, int interval) {
            this.start = start;
            this.interval = interval;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(count);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Point(a,b));
        }
        list.sort(((o1, o2) -> o1.start-o2.start));
    }

    public static void Solution() {
        count=list.get(0).start;
        for(int i=0;i<N;i++) {
            int start = list.get(i).start;
            int interval = list.get(i).interval;
            if(count<start) count=start;
            count+=interval;
        }
    }

}