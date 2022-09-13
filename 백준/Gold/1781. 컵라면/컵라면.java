import java.io.*;
import java.util.*;

public class Main {
    static int N,count,max;
    static ArrayList<Problem> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(count);
    }

    public static class Problem {
        int day;
        int food;

        public Problem(int day, int food) {
            this.day = day;
            this.food = food;
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Problem(a,b));
        }
        Collections.sort(list,((o1, o2) -> o2.day-o1.day));
        max = list.get(0).day;
    }
    public static void Solution() {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int dayIndex=0;
        for(int i=max;i>=1;i--) {
            for( ;dayIndex<N;dayIndex++) {
                if(list.get(dayIndex).day<i) break;
                pQ.offer(list.get(dayIndex).food);
            }
            if(!pQ.isEmpty()) count+=pQ.poll();
        }
    }

}