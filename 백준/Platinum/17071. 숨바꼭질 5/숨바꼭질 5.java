import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        int cur, target, speed, even;
        public Point(int c, int t, int s, int e){
            cur=c;
            target=t;
            speed=s;
            even = e;
        }
    }
    static int N, M;
    static int[] time[] = new int[500001][2], dir = {-1, 1, 0};
    static boolean[][] isVisit = new boolean[500001][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(N >= 0 && M <= 500000? BFS() : -1);
    }
    
    static int BFS(){
        Queue<Point> queue = new LinkedList<>();

        isVisit[N][0] = true;
        queue.add(new Point(N, M, 0, 0));

        while(!queue.isEmpty()){
            Point p = queue.poll();
            int cur = p.cur;
            int target = p.target;
            int speed = p.speed;
            int even = p.even;

            if(cur == target) return time[target][even];

            dir[2] = cur;
            for(int a=0; a<3; a++){
                int next = cur + dir[a];
                int nTarget = target + (speed + 1);
                int nEven = even == 1? 0 : 1;

                if(next >= 0 && next <= 500000 && nTarget <= 500000) {
                    if(isVisit[nTarget][nEven])
                        return speed + 1;

                    if(!isVisit[next][nEven]) {
                        time[next][nEven] = time[cur][even] + 1;
                        isVisit[next][nEven] = true;
                        queue.add(new Point(next, nTarget, speed + 1, nEven));
                    }
                }
            }
        }
        return -1;
    }
}