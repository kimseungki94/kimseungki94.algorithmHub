import java.io.*;
import java.util.*;

public class Main {
    static int N,count;
    static ArrayList<Meeting> list = new ArrayList<>();

    public static class Meeting {
        int money, day;

        public Meeting(int money, int day) {
            this.money = money;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        Solution();
        System.out.println(count);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Meeting(a, b));
        }
        list.sort(((o1, o2) -> {
            if(o1.money==o2.money) return o2.day-o1.day;
            else return o2.money - o1.money;
        }));
    }

    public static void Solution() {
        boolean[] isVisited = new boolean[10001];
        for(int i=0;i<N;i++) {
            for(int j=list.get(i).day;j>0;j--) {
                if(!isVisited[j]) {
                    isVisited[j]=true;
                    count+=list.get(i).money;
                    break;
                }
            }
        }
    }
}