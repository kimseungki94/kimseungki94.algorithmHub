import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N, S;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		judge(0, 0);
		if(S==0) {
			System.out.println(result-1);
		}else {
			System.out.println(result);
		}
		
	}

	private static void judge(int index, int sum) {
		if (index == N && sum == S) {
			result++;
			return;
		}
		if(index <N) {
			judge(index + 1, sum + arr[index]);
			judge(index + 1, sum);
		}
		

	}
}