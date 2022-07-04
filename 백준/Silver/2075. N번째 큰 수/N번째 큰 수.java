import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static Deque<Character>  deque = new LinkedList<>();
    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int value = Integer.parseInt(st.nextToken());
                if(set.size()<N) {
                    set.add(value);
                } else if(set.size()==N && set.last()<value) {
                    set.remove(set.last());
                    set.add(value);
                }
            }
        }
        System.out.println(set.last());
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.input();
    }
}
