import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M, K, max, sum, min;
    static int[][] map;
    static boolean[] isChecked;

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(max);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        map = new int[N][N];
        isChecked = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void Solution() {
        DFS(0);
    }

    public static void DFS(int limit) {
        if (limit == 5) {
            findValue();
            return;
        }
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }
        for (int j = 0; j < 4; j++) {
            move(j);
            DFS(limit + 1);
            for (int k = 0; k < N; k++) {
                map[k] = temp[k].clone();
            }
        }
    }

    public static void move(int direct) {
        switch (direct) {
            // 위로 올리기
            case 0:
                for (int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[j][i] != 0) {
                            if (block == map[j][i]) {
                                map[index - 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            } else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[j][i] != 0) {
                            if (block == map[j][i]) {
                                map[index + 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            } else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] != 0) {
                            if (block == map[i][j]) {
                                map[i][index - 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            } else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[i][j] != 0) {
                            if (block == map[i][j]) {
                                map[i][index + 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            } else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;

        }
    }

    public static void findValue() {
        int value = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                value = Math.max(value, map[i][j]);
            }
        }
        max = Math.max(max, value);
    }
}