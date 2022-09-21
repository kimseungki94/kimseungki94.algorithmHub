import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M, K, max, sum, min, apple, count;
    static int[][] map, dir;

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(count);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][8];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] temp = st.nextToken().toCharArray();
            for (int j = 0; j < 8; j++) {
                map[i][j] = temp[j] - '0';
            }
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        dir = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i][0] = Integer.parseInt(st.nextToken())-1;
            dir[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void Solution() {
        for (int i = 0; i < M; i++) {
            int number = dir[i][0];
            int flag = dir[i][1];

            plusDFS(number+1, flag*-1);
            minusDFS(number-1, flag*-1);
            if (flag == 1) {
                clock(number);
            } else {
                antiClock(number);
            }
        }
        findValue();
    }

    public static void clock(int index) {
        int temp = map[index][7];
        for (int i = 7; i > 0; i--) {
            map[index][i] = map[index][i - 1];
        }
        map[index][0] = temp;
    }

    public static void antiClock(int index) {
        int temp = map[index][0];
        for (int i = 0; i < 7; i++) {
            map[index][i] = map[index][i + 1];
        }
        map[index][7] = temp;
    }

    public static void plusDFS(int number, int flag) {
        if(number==N) {
            return;
        }
        if(map[number-1][2]==map[number][6]) {
            return;
        }
        plusDFS(number+1, flag*-1);
        if (flag == 1) {
            clock(number);
        } else {
            antiClock(number);
        }
    }

    public static void minusDFS(int number, int flag) {
        if(number==-1) {
            return;
        }
        if(map[number][2]==map[number+1][6]) {
            return;
        }
        minusDFS(number-1, flag*-1);
        if (flag == 1) {
            clock(number);
        } else {
            antiClock(number);
        }
    }

    public static void findValue() {
        for(int i=0;i<N;i++) {
            if(map[i][0]==1) {
                count++;
            }
        }
    }
}