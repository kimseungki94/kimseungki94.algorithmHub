import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] map = {
            0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, //0 ~ 21
            10, 13, 16, 19, 25, 30, 35, 40, 0,  //22 ~ 30
            20, 22, 24, 25, 30, 35, 40, 0,      //31 ~ 38
            30, 28, 27, 26, 25, 30, 35, 40, 0}; //39 ~ 47
    static int[] dice = new int[10];
    static int[] gamePiece = new int[10];
    static boolean[] isVisited;
    static int count;
    public static void main(String[] args) throws Exception {
        input();
        DFS(0);
        System.out.println(count);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void DFS(int cnt) {
        if(cnt == 10) {
            playGame();
            return;
        }

        for(int i=0; i<4; i++) {
            gamePiece[cnt] = i;
            DFS(cnt+1);
        }
    }

    public static void playGame() {
        isVisited = new boolean[map.length];
        int score = 0;
        int[] p = new int[4];

        for(int i=0 ; i<10 ; i++) {
            int diceNumber = dice[i];
            int startHouseNumber = gamePiece[i];
            if(isFinish(p[startHouseNumber])) return;

            int next = nextPoint(p[startHouseNumber], diceNumber);
            if(isFinish(next)) {
                setVisited(p[startHouseNumber], false);
                p[startHouseNumber] = next;
                continue;
            }
            if(isVisited[next]) return;
            setVisited(p[startHouseNumber], false);
            setVisited( next, true);

            p[startHouseNumber] = next;
            score += map[p[startHouseNumber]];
        }
        count = Math.max(count, score);
    }


    public static void setVisited(int index, boolean check) {
        if(index == 20 || index == 29 || index == 37 || index == 46) {
            isVisited[20] = check;
            isVisited[29] = check;
            isVisited[37] = check;
            isVisited[46] = check;
        } else if(index == 26 || index == 34 || index == 43) {
            isVisited[26] = check;
            isVisited[34] = check;
            isVisited[43] = check;
        } else if(index == 27 || index == 35 || index == 44) {
            isVisited[27] = check;
            isVisited[35] = check;
            isVisited[44] = check;
        }else if(index == 28 || index == 36 || index == 45) {
            isVisited[28] = check;
            isVisited[36] = check;
            isVisited[45] = check;
        }else {
            isVisited[index] = check;
        }
    }

    public static int nextPoint(int nowIndex, int diceNumber) {
        int nextIndex = nowIndex + diceNumber;
        if(nowIndex < 21) {
            if(nextIndex >= 21) nextIndex = 21;
        } else if(nowIndex < 30) {
            if(nextIndex >= 30) nextIndex = 30;
        } else if(nowIndex < 38) {
            if(nextIndex >= 38) nextIndex = 38;
        } else if(nowIndex < 47) {
            if(nextIndex >= 47) nextIndex = 47;
        }

        if(nextIndex == 5) return 22;
        if(nextIndex == 10) return 31;
        if(nextIndex == 15) return 39;
        return nextIndex;
    }

    public static boolean isFinish(int index) {
        return index == 21 || index == 30 || index == 38 || index == 47;
    }
}