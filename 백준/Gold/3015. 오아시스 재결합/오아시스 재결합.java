import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Stack<Person> stack = new Stack<>();
    static long cnt;

    static class Person {
        int height;
        int cnt;

        Person(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(br.readLine());
            Person person = new Person(next, 1);

            while (!stack.empty() && stack.peek().height <= next) {
                Person p = stack.pop();
                cnt += p.cnt;
                if (p.height == next)
                    person.cnt += p.cnt;
            }

            if (!stack.empty())
                cnt++;

            stack.push(person);
        }
        System.out.println(cnt);
    }
}