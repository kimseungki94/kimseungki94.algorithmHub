import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max;
    static long count;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        System.out.println(count);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void Solution() {
        boolean[] product = new boolean[101];
        int usePlug=0;
        for(int i=0;i<M;i++) {
            int index=arr[i];
            if(!product[index]) {
                if(usePlug<N) {
                    usePlug++;
                    product[index]=true;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int j=i;j<M;j++) {
                        if(product[arr[j]] && !list.contains(arr[j])) {
                            list.add(arr[j]);
                        }
                    }
                    if(list.size()<N) {
                        for(int j=0;j<product.length;j++) {
                            if(product[j] && !list.contains(j)) {
                                product[j]=false;
                                break;
                            }
                        }
                    } else {
                        int delete = list.get(list.size()-1);
                        product[delete]=false;
                    }
                    product[index]=true;
                    count++;
                }
            }
        }
    }
}