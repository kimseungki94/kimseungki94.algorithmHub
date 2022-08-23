import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue;
    static int[] arr;
    static HashMap<Integer,Point> hashMap = new HashMap<>();
    public class Point implements Comparable<Point> {
        int value;
        int count;
        int start;

        public Point(int value, int count, int start) {
            this.value = value;
            this.count = count;
            this.start = start;
        }

        @Override
        public int compareTo(Point o) {
            if(o.count==this.count) return this.start-o.start;
            else return o.count-this.count;
        }
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
        System.out.println(sb.toString());
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int value = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(value)) {
                hashMap.get(value).count++;
            } else {
                hashMap.put(value,new Point(value,1,i));
            }
        }
    }
    public void Solution() {
        ArrayList<Point> data = new ArrayList<>(hashMap.values());
        Collections.sort(data);
        for(Point p : data) {
            for(int i=0;i<p.count;i++) {
                sb.append(p.value).append(" ");
            }
        }
    }
}
