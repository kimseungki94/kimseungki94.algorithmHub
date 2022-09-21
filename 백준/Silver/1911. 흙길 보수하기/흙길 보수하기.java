import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M, K, max, sum, min, apple, count;
    static int[][] map, dir;
    static ArrayList<Point> list = new ArrayList<>();

    public static class Point {
        int start;
        int end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
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
        M = Integer.parseInt(st.nextToken());
        dir = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i][0] = Integer.parseInt(st.nextToken());
            dir[i][1] = Integer.parseInt(st.nextToken())-1;
            list.add(new Point(dir[i][0], dir[i][1]));
        }
        list.sort(((o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            else return o1.start - o2.start;
        }));
    }

    public static void Solution() {
        int block = 0;
        for (int i = 0; i < N; i++) {
            int start = list.get(i).start;
            int end = list.get(i).end;
            if (start > block) block = start;
            while (end >= block) {
                block += M;
                count++;
            }
        }
    }
}