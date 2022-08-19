import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, max;
    static String text,answer;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        text = st.nextToken();
        arr = new int[26];
        for(char c : text.toCharArray()) {
            arr[c-'A']++;
        }
        int notPair=0;
        for(int value : arr) {
            if(value%2==1) {
                notPair++;
            }
        }
        answer="";
        if(notPair>1) answer+="I'm Sorry Hansoo";
        else {
            for(int i=0;i<arr.length;i++) {
                for(int j=0;j<arr[i]/2;j++) {
                    sb.append((char)(i+'A'));
                }
            }
            String front = sb.toString();
            String end = sb.reverse().toString();
            String mid = "";
            for(int i=0;i<arr.length;i++) {
                if(arr[i]%2==1) {
                    mid+=(char)(i+'A');
                }
            }
            answer+=(front+mid+end);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(answer);
    }
}
