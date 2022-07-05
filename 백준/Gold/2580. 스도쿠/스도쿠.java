import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    static int N, M, K, count, size, max;
    static StringBuilder sb = new StringBuilder();
    static Deque<Character> deque = new LinkedList<>();
    static int[][] map, tempMap;
    static int[] isVieited = new int[26];
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};
    static ArrayList<Point> list =new ArrayList<>();
    static boolean flag = false;
    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[10][10];
        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int value=Integer.parseInt(st.nextToken());
                map[i][j]=value;
                if(value==0) list.add(new Point(i,j));
            }
        }
    }

    public void DFS(int count) {
        if(flag) return;
        if(count==list.size()) {
            flag=true;
            for(int i=1;i<=9;i++) {
                for(int j=1;j<=9;j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        Point point = list.get(count);
        int row = point.y;
        int col = point.x;
        for(int i=1;i<=9;i++) {
            if(findVert(row,i) && findHori(col,i) && findRectangle(row,col,i)){
                map[row][col]=i;
                DFS(count+1);
                map[row][col]=0;
            }
        }
    }

    public boolean findVert(int row, int data) {
        for(int col=1;col<=9;col++) {
            if(map[row][col]==data){
                return false;
            }
        }
        return true;
    }

    public boolean findHori(int col,int data) {
        for(int row=1;row<=9;row++) {
            if(map[row][col]==data) {
                return false;
            }
        }
        return true;
    }

    public boolean findRectangle(int row,int col,int data) {
        int[] rowRange = findRange(row);
        int[] colRange = findRange(col);
        for(int i=rowRange[0];i<=rowRange[1];i++) {
            for(int j=colRange[0];j<=colRange[1];j++) {
                if(map[i][j]==data) {
                    return false;
                }
            }
        }
        return true;
    }
    public int[] findRange(int data) {
        int[] range = new int[2];
        if(data%3==1){
            range[0]=data;
            range[1]=data+2;
        } else if(data%3==2) {
            range[0]=data-1;
            range[1]=data+1;
        } else if(data%3==0) {
            range[0]=data-2;
            range[1]=data;
        }
        return range;
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
        main.DFS(0);
    }
}
