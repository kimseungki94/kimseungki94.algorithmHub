import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max;
    static long count;
    static ArrayList<Diamond> list = new ArrayList<>();
    static ArrayList<Integer> bag = new ArrayList<>();

    public static class Diamond {
        int weight;
        int price;

        public Diamond(int weight, int price) {
            this.weight = weight;
            this.price = price;
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
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Diamond(a, b));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            bag.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(((o1, o2) -> {
            if (o1.weight == o2.weight) return o2.price - o1.price;
            else return o1.weight - o2.weight;
        }));
        Collections.sort(bag);
    }

    public static void Solution() {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = 0; i < M; i++) {
            for (; j < N; j++) {
                if (bag.get(i) >= list.get(j).weight) pQ.offer(list.get(j).price);
                else break;
            }
            if(!pQ.isEmpty()) count += pQ.poll();
        }
    }

}