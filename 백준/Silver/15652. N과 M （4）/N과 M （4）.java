import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] num;
	static int N;
	static int limit;
	static boolean[] visited;
	static int[] store;
	static String str;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		str = null;
		N = Integer.parseInt(st.nextToken()); // 수
		limit = Integer.parseInt(st.nextToken()); // 제한된 수
		num = new int[limit];
		visited = new boolean[N + 1];
		sb = new StringBuilder();
		dfs(0, "",0);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(sb.toString().trim());
		bw.close();
	}

	private static void dfs(int index, String str,int last) {
		if (index == limit) {
			sb.append(str.trim() + "\n");
			// System.out.println();
			return;
		}
		for (int j = 1; j <= N; j++) {
			if (visited[j] == false && j>=last) {
				num[index] = j;
				last = j;
				// visited[j]=true;
					dfs(index + 1, str + " " + j, last);

				// visited[j]=false;
			}
		}

	}

}