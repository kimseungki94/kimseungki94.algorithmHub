import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, max;
    static String[] texts;
    static boolean[] isSelected = new boolean[26];
    static ArrayList<Long> arrayList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public static void func() {
        for (int i = 0; i < 10; i++) {
            down(i);
        }
        Collections.sort(arrayList);
    }

    private static void down(long number) {
        arrayList.add(number);
        for (int i = 0; i < number % 10; i++) {
            down((number * 10) + i);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        if (N < 10) {
            System.out.println(N);
        } else if (N >= 1023) {
            System.out.println(-1);
        } else {
            func();
            System.out.println(arrayList.get(N));
        }

    }
}
