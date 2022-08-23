import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue;
    static int[][] map, arr;
    static boolean[][] isSelected;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.DFS(0, 0, N);
        System.out.println(sb.toString());
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = text.charAt(j)-'0';
            }
        }
    }

    public void DFS(int row, int col, int size) {
        if (isCheck(row, col, size)) {
            sb.append(map[row][col]);
            return;
        }
        int newSize = size/2;
        sb.append("(");
        DFS(row, col, newSize);
        DFS(row, col+newSize, newSize);
        DFS(row+newSize, col, newSize);
        DFS(row+newSize, col+newSize, newSize);
        sb.append(")");
    }

    private boolean isCheck(int row, int col, int size) {
        int data = map[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != data) {
                    return false;
                }
            }
        }
        return true;
    }
}
