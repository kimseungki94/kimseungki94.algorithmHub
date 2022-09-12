import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K, T, max;
    static int[][] map;
    static int[] arr;
    static String command;
    static boolean[][] isVisited;
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String text = st.nextToken().replace("[", "").replace("]", "");
            if (N > 0) {
                int index = 0;
                String[] data = text.split(",");
                for (String d : data) {
                    deque.offerLast(Integer.parseInt(d));
                }
            }
            Solution();
        }
    }

    public static void Solution() {
        boolean flag = true;
        if (N == 0) {
            for (char c : command.toCharArray()) {
                if (c == 'D') {
                    flag = false;
                }
            }
            if (flag) {
                sb.append("[]").append("\n");
            } else {
                sb.append("error").append("\n");
            }
        } else {
            int reverseCount = 0;
            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    reverseCount++;
                } else if (c == 'D' && reverseCount % 2 == 0 && deque.size() > 0) {
                    deque.pollFirst();
                } else if (c == 'D' && reverseCount % 2 == 1 && deque.size() > 0) {
                    deque.pollLast();
                } else if (c == 'D' || deque.size() == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                if (deque.size() == 0) {
                    sb.append("[]").append("\n");
                } else {
                    List<Integer> list = new ArrayList<>();
                    while (deque.size() != 0) {
                        list.add(deque.pollFirst());
                    }
                    sb.append("[");
                    if (reverseCount % 2 == 1) {
                        Collections.reverse(list);
                    }
                    for (int i = 0; i < list.size(); i++) {
                        if (i == list.size() - 1) sb.append(list.get(i));
                        else sb.append(list.get(i)).append(",");
                    }

                    sb.append("]").append("\n");
                }
            } else {
                sb.append("error").append("\n");
            }
        }
        deque.clear();
    }
}