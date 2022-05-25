import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, start;
    static long max, min;
    static String maxText, minText;
    static int[] isNumbers, isSelected;
    static int[] giho;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        giho = new int[N + 1];
        isNumbers = new int[N + 2];
        isSelected = new int[10];
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (st.nextToken().equals("<")) {
                giho[i] = 1;
            } else {
                giho[i] = 2;
            }
        }
    }

    public static void func(int limit) {
        if (limit == N + 2) {
            String text = "";
            for (int i = 1; i <= N+1; i++) text+=isNumbers[i];
            Long textValue = Long.parseLong(text);
            if(max<textValue) {
                max = textValue;
                maxText = text;
            }
            if(min>textValue) {
                min = textValue;
                minText = text;
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                if (isValidation(i, limit)) {
                    isNumbers[limit] = i;
                    isSelected[i] = 1;
                    func(limit + 1);
                    isNumbers[limit] = 0;
                    isSelected[i] = 0;
                } else {
                    continue;
                }
            }
        }
    }

    private static boolean isValidation(int index, int limit) {
        if (limit > 1) {
            if (isSelected[index] == 1) {
                return false;
            }

            if (giho[limit - 1] == 1) {
                if (isNumbers[limit - 1] < index) {
                    return true;
                }
            } else {
                if (isNumbers[limit - 1] > index) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }


    public static void main(String[] args) throws Exception {
        input();
        func(1);
        System.out.println(maxText);
        System.out.println(minText);
    }
}
