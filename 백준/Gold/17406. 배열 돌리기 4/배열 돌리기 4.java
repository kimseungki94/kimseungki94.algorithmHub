import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M, K, max, sum, min, apple, direction;
    static int[][] map, dir;
    static int[] arr;
    static boolean[] isVisited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Queue<Integer> list = new LinkedList<>();
    static HashMap<Integer, String> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(min);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dir = new int[K][3];
        arr = new int[K];
        isVisited = new boolean[K];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i][0] = Integer.parseInt(st.nextToken()) - 1;
            dir[i][1] = Integer.parseInt(st.nextToken()) - 1;
            dir[i][2] = Integer.parseInt(st.nextToken());
        }
    }

    public static void Solution() {
        DFS(0);
    }

    public static void DFS(int limit) {
        if(limit==K) {
            int[][] temp = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            isFindValue(temp);
            return;
        }
        for(int i=0;i<K;i++) {
            if(!isVisited[i]) {
                isVisited[i]=true;
                arr[limit]=i;
                DFS(limit+1);
                isVisited[i]=false;
            }
        }
    }

    private static void isFindValue(int[][] temp) {
        for(int i=0;i<K;i++) {
            int startX = dir[arr[i]][0] - dir[arr[i]][2];
            int startY = dir[arr[i]][1] - dir[arr[i]][2];
            int endX = dir[arr[i]][0] + dir[arr[i]][2];
            int endY = dir[arr[i]][1] + dir[arr[i]][2];
            rotates(startY,startX,endY,endX,temp);
        }
        findRowMin(temp);
    }

    private static void rotates(int startY, int startX, int endY, int endX, int[][] temp) {
        if(startX == endX && startY == endY) {
            return;
        }
        int[] data = new int[3];
        data[0] = temp[startX][endY];
        data[1] = temp[endX][endY];
        data[2] = temp[endX][startY];

        for(int i = endY; i > startY; i--) {
            temp[startX][i] = temp[startX][i - 1];
        }
        for(int i = endX; i > startX; i--) {
            if(i == startX + 1) temp[i][endY] = data[0];
            else temp[i][endY] = temp[i - 1][endY];
        }
        for(int i = startY; i < endY; i++) {
            if(i == endY - 1) temp[endX][i] = data[1];
            else temp[endX][i] = temp[endX][i + 1];
        }
        for(int i = startX; i < endX; i++) {
            if(i == endX - 1) temp[i][startY] = data[2];
            else temp[i][startY] = temp[i + 1][startY];
        }
        rotates(startY + 1, startX + 1, endY - 1, endX - 1, temp);
    }

    public static void findRowMin(int[][] temp) {
        for(int i = 0; i < temp.length; i++) {
            int sum = 0;
            for(int j = 0; j < temp[i].length; j++) {
                sum += temp[i][j];
            }
            min = Math.min(min, sum);
        }
    }

}