import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, min, max, count,sum;
    static int[] carA, carB, carC, fee;
    static boolean flag = false;
    static String text;
    static StringBuilder sb = new StringBuilder();

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        fee = new int[3];
        for(int i=0;i<3;i++) {
            fee[i]=Integer.parseInt(st.nextToken());
        }
        carA = new int[2];
        carB = new int[2];
        carC = new int[2];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2;i++) {
            carA[i]=Integer.parseInt(st.nextToken());
            if(carA[i]<min) min = carA[i];
            if(carA[i]>max) max = carA[i];
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2;i++) {
            carB[i]=Integer.parseInt(st.nextToken());
            if(carB[i]<min) min = carB[i];
            if(carB[i]>max) max = carB[i];
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2;i++) {
            carC[i]=Integer.parseInt(st.nextToken());
            if(carC[i]<min) min = carC[i];
            if(carC[i]>max) max = carC[i];
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.Solution();
        System.out.println(sum);
    }

    public static void Solution() {
        for(int i=min;i<=max;i++) {
            inParking(i);
            outParking(i);
            isFee();
        }
    }
    public static void isFee() {
        if(count==1) {
            sum+=count*fee[0];
        } else if(count==2) {
            sum+=count*fee[1];
        } else if(count==3) {
            sum+=count*fee[2];
        }
    }
    public static void inParking(int time) {
        if(time==carA[0]) {
            count++;
        }
        if(time==carB[0]) {
            count++;
        }
        if(time==carC[0]) {
            count++;
        }
    }
    public static void outParking(int time) {
        if(time==carA[1]) {
            count--;
        }
        if(time==carB[1]) {
            count--;
        }
        if(time==carC[1]) {
            count--;
        }
    }
}
