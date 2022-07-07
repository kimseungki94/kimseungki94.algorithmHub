import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int F, S, G, U, D, N,M;
    static Queue<Point> queue = new LinkedList<>();
    static boolean[] isVisited;
    static boolean flag = true;
    static char[][] map;
    static int[] dy={-1,1,0,0};
    static int[] dx={0,0,-1,1};
    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            for(int j=0;j<M;j++) {
                map[i][j]=text.charAt(j);
                if(map[i][j]=='W') {
                    queue.offer(new Point(i,j));
                }
            }
        }
        BFS();
        if(flag) {
            System.out.println(1);
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println(0);
        }
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int Y = point.row;
            int X = point.col;
            for(int i=0;i<4;i++) {
                int row = Y+dy[i];
                int col = X+dx[i];
                if(row>=0 && row < N && col>=0 && col<M) {
                    if(map[row][col]=='.') {
                        map[row][col]='D';
                    } else if(map[row][col]=='S') {
                        flag=false;
                        return;
                    }
                }
            }
        }
    }
}