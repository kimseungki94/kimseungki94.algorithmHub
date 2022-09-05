import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, M, count, min;
    private static boolean flag = false;
    private static int essentialA, essentialB, essentialC, essentialD;
    private static boolean[] isVisited;
    private static Food[] foodList;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static class Food {
        int a;
        int b;
        int c;
        int d;
        int price;

        public Food(int a, int b, int c, int d, int price) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        DFS(new Food(0, 0, 0, 0, 0), 0);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
            System.out.println(sb.toString());
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        essentialA = Integer.parseInt(st.nextToken());
        essentialB = Integer.parseInt(st.nextToken());
        essentialC = Integer.parseInt(st.nextToken());
        essentialD = Integer.parseInt(st.nextToken());
        foodList = new Food[N];
        isVisited = new boolean[N];
        arr = new int[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            foodList[i] = new Food(a, b, c, d, price);
        }
    }

    private static void DFS(Food food, int start) {
        if (min < food.price) return;
        if (food.a >= essentialA && food.b >= essentialB && food.c >= essentialC && food.d >= essentialD) {
            if (min > food.price) {
                min = food.price;
                sb.delete(0, sb.length());
                for (int i = 0; i < N; i++) {
                    if (isVisited[i]) {
                        sb.append(i + 1).append(" ");
                    }
                }
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                food.a += foodList[i].a;
                food.b += foodList[i].b;
                food.c += foodList[i].c;
                food.d += foodList[i].d;
                food.price += foodList[i].price;
                DFS(food, i + 1);
                food.a -= foodList[i].a;
                food.b -= foodList[i].b;
                food.c -= foodList[i].c;
                food.d -= foodList[i].d;
                food.price -= foodList[i].price;
                isVisited[i] = false;
            }
        }
    }
}