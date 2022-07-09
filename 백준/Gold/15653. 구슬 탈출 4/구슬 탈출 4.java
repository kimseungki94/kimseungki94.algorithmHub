import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] map;
    static boolean[][][][] isVisited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    public static class Point {
        int rRow;
        int rCol;
        int bRow;
        int bCol;

        public Point(int rRow, int rCol, int bRow, int bCol) {
            this.rRow = rRow;
            this.rCol = rCol;
            this.bRow = bRow;
            this.bCol = bCol;
        }
    }
    public static class Task {
        int row;
        int col;
        int cost;

        public Task(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[N][M][N][M];
        int rRow,rCol,bRow,bCol;
        rRow=rCol=bRow=bCol=0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
            for(int j=0;j<M;j++) {
                if(map[i][j]=='R'){
                    rRow=i;
                    rCol=j;
                } else if(map[i][j]=='B') {
                    bRow=i;
                    bCol=j;
                }
            }
        }
        System.out.println(BFS(rRow,rCol,bRow,bCol));;
    }
    public static int BFS(int data1,int data2,int data3, int data4) {
        queue.offer(new Point(data1,data2,data3,data4));
        int count=0;
        isVisited[data1][data2][data3][data4]=true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            count++;
            for(int m=0;m<len;m++) {
                Point p = queue.poll();
                int rRow = p.rRow;
                int rCol = p.rCol;
                int bRow = p.bRow;
                int bCol = p.bCol;
                for(int i=0;i<4;i++) {
                    Task rTask = move(rRow,rCol,0,i);
                    Task bTask = move(bRow,bCol,0,i);

                    if(map[bTask.row][bTask.col]=='O') continue;
                    if(map[rTask.row][rTask.col]=='O') return count;

                    if(rTask.row==bTask.row && rTask.col==bTask.col) {
                        if(rTask.cost> bTask.cost) {
                            rTask.row-=dy[i];
                            rTask.col-=dx[i];
                        } else {
                            bTask.row-=dy[i];
                            bTask.col-=dx[i];
                        }
                    }
                    if(isVisited[rTask.row][rTask.col][bTask.row][bTask.col]) continue;
                    isVisited[rTask.row][rTask.col][bTask.row][bTask.col] = true;
                    queue.add(new Point(rTask.row, rTask.col, bTask.row, bTask.col));
                }
            }
        }
        return -1;
    }
    public static Task move(int row,int col,int cost,int button) {
        while (map[row+dy[button]][col+dx[button]]!='#' && map[row][col]!='O') {
            row+=dy[button];
            col+=dx[button];
            cost++;
        }
        return new Task(row,col,cost);
    }
}