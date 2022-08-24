import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue;
    static int jCount, mCount;
    static int[][] arr, map;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.BFS();
        for(int[] data : map) {
            for(int d : data) sb.append(d).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            for(int j=0;j<M;j++) {
                char value=text.charAt(j);
                if(value=='c') {
                    queue.offer(new Point(i,j));
                    map[i][j]=0;
                }
                else map[i][j]=-1;
            }
        }
    }
    public void BFS() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                Point point = queue.poll();
                int Y = point.row;
                int X = point.col;
                if(X+1<M) {
                    if(map[Y][X+1]<0) {
                        map[Y][X+1]=map[Y][X]+1;
                        queue.add(new Point(Y,X+1));
                    }
                }
            }
        }
    }

    public void Solution() {
    }
}
