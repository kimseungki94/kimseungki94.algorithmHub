import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

public class Main {

    private static int N, K, M, count;

    public static void main(String[] args) throws IOException {
        input();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String text = st.nextToken();
        boolean flag = true;
        text=text.replaceAll("pi","A").replaceAll("ka","A").replaceAll("chu","A");
        for(char c : text.toCharArray()) {
            if(c!='A') {
                flag=false;
                break;
            }
        }
        if(flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}