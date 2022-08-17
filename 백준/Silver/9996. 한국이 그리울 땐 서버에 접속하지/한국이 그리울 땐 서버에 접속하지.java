import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static String text;
    static String patternFirst="";
    static String patternLast="";
    static boolean flag = false;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        text = st.nextToken();
        for(int i=0;i<text.length();i++) {
            if(text.charAt(i)=='*') {
                flag=true;
                continue;
            }
            if(!flag) {
                patternFirst+=text.charAt(i);
            } else {
                patternLast+=text.charAt(i);
            }
        }
        arr = new String[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]=st.nextToken();
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
    }

    public static void Solution() {
        for(int t=0;t<N;t++) {
            boolean isNe = false;
            if(patternFirst.length()+patternLast.length()<=arr[t].length()) {
                for(int i=0;i<patternFirst.length();i++) {
                    if(arr[t].charAt(i)!=patternFirst.charAt(i)) {
                        isNe=true;
                        break;
                    }
                }
                if(!isNe) {
                    int len = arr[t].length()-1;
                    int lastLen = patternLast.length()-1;
                    int index=0;
                    for(int i=len-lastLen;i<arr[t].length();i++) {
                        if(arr[t].charAt(i)!=patternLast.charAt(index)) {
                            isNe=true;
                            break;
                        }
                        index++;
                    }
                }
                if(isNe) {
                    System.out.println("NE");
                } else {
                    System.out.println("DA");
                }


            } else {
                System.out.println("NE");
            }
        }
    }
}
