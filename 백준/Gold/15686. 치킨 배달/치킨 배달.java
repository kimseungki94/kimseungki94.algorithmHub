import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, min;
    static int[] arr, answer;
    static int[][] map;
    static ArrayList<Point> chicken = new ArrayList<>();

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
        System.out.println(min);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int location = Integer.parseInt(st.nextToken());
                map[i][j] = location;
                if (location == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        arr = new int[chicken.size()];
        DFS(0, 0);
    }

    public static void DFS(int index, int limit) {
        if (limit == M) {
            min=Math.min(min,Solution());
            return;
        }
        for (int i = index; i < chicken.size(); i++) {
            arr[i] = 1;
            DFS(i + 1, limit + 1);
            arr[i] = 0;
        }
    }

    public static int Solution() {
        int data = 0;
        ArrayList<Point> list = new ArrayList<>();
        for(int i=0;i<chicken.size();i++) {
            if(arr[i]==1) {
                list.add(chicken.get(i));
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]==1) {
                    int value = Integer.MAX_VALUE;
                    for(Point p : list) {
                        value=Math.min(value,Math.abs(i-p.row)+Math.abs(j-p.col));
                    }
                    data+=value;
                }
            }
        }
        return data;
    }
}