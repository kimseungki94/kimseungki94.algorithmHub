import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static int arr[][];
    static boolean visit[][];
    static int moveX[] = {-1,0,1,0};
    static int moveY[] = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        visit = new boolean[R][C];
        for(int r=0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int room = 0;
        int max = 0;
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(!visit[r][c]) {
                    max = Math.max(max, bfs(r,c));
                    room++;
                }
            }
        }
        System.out.println(room);
        System.out.println(max);

        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                for(int bit=1; bit<=8; bit<<=1) {
                    if((arr[r][c] & bit)!=0) {
                        visit = new boolean[R][C];
                        arr[r][c] -= bit;
                        max = Math.max(max, bfs(r,c));
                        arr[r][c] += bit;
                    }
                }
            }
        }
        System.out.println(max);
    }
    private static int bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(col, row));
        visit[row][col] = true;
        int count = 1;
        while(!queue.isEmpty()) {

            Point po = queue.poll();
            int bit = 1;
            for(int d=0; d<4; d++) {
                if((arr[po.y][po.x] & bit)==0) {
                    int newX = po.x + moveX[d];
                    int newY = po.y + moveY[d];
                    if (!(0 <= newY && newY < R && 0 <= newX && newX < C))
                        continue;
                    if(0<=newY && newY<R && 0<=newX && newX<C && !visit[newY][newX]) {
                        count++;
                        visit[newY][newX]=true;
                        queue.add(new Point(newX, newY));
                    }
                }
                bit<<=1;
            }
        }
        return count;
    }


}
