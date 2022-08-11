import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min, limit;
    static int[][] arr;
    static boolean[] isVisited;

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.DFS(0,"");
    }

    private void DFS(int limit, String text) {
        if(limit==N) {
            System.out.println(text);
            System.exit(0);
        }
        for(int i=1;i<=3;i++) {
            if(check(text+i)) DFS(limit+1,text+i);
        }
    }

    private boolean check(String text) {
        if(text.length()==1) return true;
        int len = text.length()/2;
        for(int i=1;i<=len;i++) {
            String text1 = text.substring(text.length()-i);
            String text2 = text.substring(text.length()-text1.length()-i,text.length()-i);
            if(text1.equals(text2)) {
                return false;
            }
        }
        return true;
    }
}
