import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max;
    static long count;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] arr;

    public static class Diamond {
        int weight;
        int price;

        public Diamond(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        findNumber();
        Solution();
        System.out.println(count);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr  = new int[N+1];
    }

    public static void Solution() {
        int lt,rt,sum;
        lt=rt=sum=0;
        while (true) {
            if(sum>=N) sum-=list.get(lt++);
            else if(rt==list.size()) break;
            else sum+=list.get(rt++);
            if(N==sum) count++;
        }
    }

    public static void findNumber() {
        boolean[] isVisited = new boolean[N+1];
        isVisited[0]=true;
        isVisited[1]=true;
        for(int i=2;i*i<=N;i++) {
            for(int j=i*2;j<=N;j+=i) {
                if(isVisited[j]) continue;
                isVisited[j]=true;
            }
        }
        for(int i=0;i<=N;i++) {
            if(!isVisited[i]) list.add(i);
        }
    }
}