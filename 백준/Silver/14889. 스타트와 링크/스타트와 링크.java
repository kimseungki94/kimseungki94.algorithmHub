import java.io.*;
import java.util.*;

public class Main {
    static int N, startIndex, linkIndex, startSum, linkSum, min;
    static int[] isSelected, startTeam, linkTeam;
    static int[][] team;


    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        team = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int index2 = 1; index2 <= N; index2++) {
                team[i][index2] = Integer.parseInt(st.nextToken());
            }
        }
        isSelected = new int[N + 1];
        startTeam = new int[N / 2];
        linkTeam = new int[N / 2];
        min = Integer.MAX_VALUE;
    }


    public static void func(int index, int count) {
        if (count == N / 2) {
            for (int i = 1; i <= N; i++) {
                if (isSelected[i] == 1) startTeam[startIndex++] = i;
                else linkTeam[linkIndex++] = i;
            }
            startIndex = 0;
            linkIndex = 0;
            startSum = calculate(startTeam);
            linkSum = calculate(linkTeam);
            min = Math.min(Math.abs(startSum - linkSum), min);
        } else {
            for (int i = index; i <= N; i++) {
                isSelected[i] = 1;
                func(i + 1, count + 1);
                isSelected[i] = 0;
            }
        }
    }

    private static int calculate(int[] teamNumber) {
        int value = 0;
        for (int i = 0; i < teamNumber.length; i++) {
            for (int j = i + 1; j < teamNumber.length; j++) {
                value += team[teamNumber[i]][teamNumber[j]]+team[teamNumber[j]][teamNumber[i]];
            }
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        input();
        func(1, 0);
        System.out.println(min);
    }
}