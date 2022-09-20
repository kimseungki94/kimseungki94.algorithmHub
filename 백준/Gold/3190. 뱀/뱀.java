import java.util.*;
import java.io.*;
 
 
class Main {
 
    static class Snake {
        int x, y;
        
        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int K;
    static int[][] map;
    static int L;
    static int[] time;
    static int[] dir;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0}; 
    static Deque<Snake> deque = new ArrayDeque<Snake>();
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];    // 1,1부터 시작
 
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
 
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;    // 사과 위치는 1
        }
 
        L = Integer.parseInt(br.readLine());
        time = new int[L];
        dir = new int[L];
 
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
 
            time[i] = Integer.parseInt(st.nextToken());
            dir[i] = Direction(st.nextToken());
        }
 
        int second = 0;
        int snakeDir = 1;    // 첫 방향은 오른쪽
        int timeIdx = 0;
        map[1][1] = 2;  // 처음 뱀의 위치는 (1,1)
        deque.add(new Snake(1, 1));
 
        while(true) {
            // 시간이 지나면 방향 바꾸기
            if(timeIdx < L && time[timeIdx] == second) {
                snakeDir = (snakeDir + dir[timeIdx])%4;
                timeIdx++;
            }
 
            // 1. 몸길이를 늘려 머리를 다음 칸에 위치시킨다
            int nx = deque.getFirst().x + dx[snakeDir];
            int ny = deque.getFirst().y + dy[snakeDir];
 
            //스태이지 예외처리
            if(nx <= 0 || nx > n || ny <= 0 || ny > n) {
                System.out.println(second + 1);
                break;
            }
            // 뱀 자기 자신에 부딫치면 break
            if(map[nx][ny] == 2) {
                System.out.println(second + 1);
                break;
            }        
 
            // 사과 있으면 사과를 자신의 몸통으로 바꾸기
            if(map[nx][ny] == 1) {
                map[nx][ny] = 2;
                deque.addFirst(new Snake(nx, ny));
            }
            // 3. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여 꼬리가 위치한 칸 비우기
            else if(map[nx][ny] == 0) {
                map[nx][ny] = 2;
                deque.addFirst(new Snake(nx, ny));
 
                Snake body = deque.removeLast();
                map[body.x][body.y] = 0;
            }
 
            second++;
        }
    }
    
    // 좌우 설정
    static int Direction(String s) {
        if(s.equals("L")) 
            return 3;
        else
            return 1;
    }
}