import java.io.*;
import java.util.*;

public class Main {

    static int N,count,max;
    static ArrayList<Problem> list = new ArrayList<>();
    static PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    public static class Problem {
        int deadLine;
        int food;

        public Problem(int deadLine, int food) {
            this.deadLine = deadLine;
            this.food = food;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(count);
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
        Collections.sort(list,((o1, o2) -> {
            if(o2.deadLine==o1.deadLine) return o2.food-o1.food;
            else return o2.deadLine-o1.deadLine;
        }));
        max = list.get(0).deadLine;
    }
    public static void Solution() {
        int j=0;
        for(int i=max;i>=1;i--) {
            for(;j<N;j++) {
                if (list.get(j).deadLine<i) break;
                pQ.offer(list.get(j).food);
            }
            if(!pQ.isEmpty()) count+=pQ.poll();
        }
    }

}