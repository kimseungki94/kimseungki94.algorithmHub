import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int maxA, maxB, size;
    static int[] pizzaA, pizzaB;

    public static void main(String[] args) throws IOException {
        input();
        Solution();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        pizzaA = new int[a];
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            pizzaA[i] = Integer.parseInt(st.nextToken());
            maxA += pizzaA[i];
        }

        pizzaB = new int[b];
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            pizzaB[i] = Integer.parseInt(st.nextToken());
            maxB += pizzaB[i];
        }
    }

    public static void Solution() {
        int[] a_count = new int[Math.max(maxA, size) + 1];
        a_count[0] = 1;
        a_count[maxA] = 1;
        count(pizzaA, a_count, size);

        int[] b_count = new int[Math.max(maxB, size) + 1];
        b_count[0] = 1;
        b_count[maxB] = 1;
        count(pizzaB, b_count, size);

        int result = 0;
        for (int i = 0; i <= size; i++) {
            result += (a_count[i] * b_count[size - i]);
        }
        System.out.println(result);
    }

    public static void count(int[] pizza, int[] count, int size) {
        for (int i = 0; i < pizza.length; i++) {
            int sum = 0;
            for (int j = 1; j < pizza.length; j++) {
                int sum_j = pizza[(i + j) % pizza.length];
                if (sum + sum_j > size) break;
                sum += sum_j;
                count[sum]++;
            }
        }
    }
}