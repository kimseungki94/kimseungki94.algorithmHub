import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, K, min, max, count;
    static int[] arr, answer;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] isChecked;
    static Queue<Point> queue = new LinkedList<>();
    static Queue<Point> fireQueue = new LinkedList<>();

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        if(BFS()) System.out.println(count);
        else System.out.println("IMPOSSIBLE");
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isChecked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            for (int j = 0; j < M; j++) {
                char c = text.charAt(j);
                if (c == '#') {
                    isChecked[i][j] = true;
                } else if (c == 'F') {
                    fireQueue.offer(new Point(i, j));
                    isChecked[i][j] = true;
                } else if (c == 'J') {
                    queue.offer(new Point(i, j));
                }
                map[i][j]=c;
            }
        }
    }

    public static boolean BFS() {
        while (!queue.isEmpty()) {
            count++;
            int len = fireQueue.size();
            for(int t=0;t<len;t++) {
                Point start = fireQueue.poll();
                for(int i=0;i<4;i++) {
                    int row = start.row+dy[i];
                    int col = start.col+dx[i];
                    if(row<0 || row>=N || col<0 || col>=M || map[row][col]!='.') continue;
                    isChecked[row][col]=true;
                    map[row][col]='F';
                    fireQueue.add(new Point(row,col));
                }
            }
            len = queue.size();
            for(int t=0;t<len;t++) {
                Point start = queue.poll();
                for(int i=0;i<4;i++) {
                    int row = start.row+dy[i];
                    int col = start.col+dx[i];
                    if(row<0 || row>=N || col<0 || col>=M) {
                        return true;
                    }
                    if(!isChecked[row][col]) {
                        isChecked[row][col]=true;
                        queue.add(new Point(row,col));
                    }
                }
            }
        }
        return false;
    }
}