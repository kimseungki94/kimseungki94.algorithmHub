import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N, M;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N];
		dfs(0, 0);
		bw.write(sb + "\n");
		bw.flush();
		bw.close();
	}

	private static void dfs(int base, int count) throws IOException {
		if (count == M) {
			for (int val : arr) {
				// bw.write(val+" ");
				sb.append(val).append(" ");
			}
			// bw.write("\n");
			sb.append("\n");
			return;
		}
		for (int i = base; i < N; i++) {
			arr[count] = i + 1;
			dfs(i + 1, count + 1);
		}

	}
}