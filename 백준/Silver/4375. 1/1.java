import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int data = scanner.nextInt();
            int num=0;
            for (int i = 1; ; i++) {
                num=(num*10)+1;
                num=num%data;
                if (num == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
    }
}
