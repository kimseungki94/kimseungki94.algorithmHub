import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		num = new int[9];
		visited = new boolean[9];
		for (int t = 0; t < 9; t++) {
			st = new StringTokenizer(br.readLine());
			num[t] = Integer.parseInt(st.nextToken());
			sum += num[t];
		}
		L: for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == j)
					continue;
				else {
					if (sum - num[i] - num[j]== 100) {
						num[i] = 0;
						num[j] = 0;
						break L;
					}
				}
			}
		}
		Arrays.sort(num);
		for (int i = 2; i < 9; i++)
			System.out.println(num[i]);

	}
}