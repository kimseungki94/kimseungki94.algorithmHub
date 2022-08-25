import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M, K, count, T, max, min, maxValue;
    static int jCount, mCount;
    static int[] arrTwo, arrFive, map;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(sb.toString());
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int winTime;
        int team1Count, team2Count;
        winTime = team1Count = team2Count = 0;
        boolean isWinTeam1;
        N = Integer.parseInt(br.readLine());
        int winScore = 0;
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().replaceAll(":", " "));
            isWinTeam1 = st.nextToken().equals("1") ? true : false;
            int nowTime = Integer.parseInt(st.nextToken()) * 60;
            nowTime += Integer.parseInt(st.nextToken());
            if (winScore > 0) team1Count += nowTime - winTime;
            if (winScore < 0) team2Count += nowTime - winTime;
            winScore += isWinTeam1 ? 1 : -1;
            winTime = nowTime;
        }
        if (winScore > 0) team1Count += 2880 - winTime;
        if (winScore < 0) team2Count += 2880 - winTime;
        System.out.printf("%02d:%02d\n%02d:%02d\n", team1Count / 60, team1Count % 60, team2Count / 60, team2Count % 60);
    }

    public void Solution() {
    }
}
