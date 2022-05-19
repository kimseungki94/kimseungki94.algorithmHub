import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean visited = true;
	static int result = 0;
	static int min_result = 0;
	static int result_temp = 0;
	static int[] num;
	static int[] arr_sep;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[] num = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		arr_sep = new int[4];
		for (int i = 0; i < 4; i++) {
			arr_sep[i] = Integer.parseInt(st.nextToken());
		}
		int[] arr = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			if (arr_sep[0] > 0) {
				arr[i] = 1;
				arr_sep[0]--;
			} else if (arr_sep[1] > 0) {
				arr[i] = 2;
				arr_sep[1]--;
			} else if (arr_sep[2] > 0) {
				arr[i] = 3;
				arr_sep[2]--;
			} else if (arr_sep[3] > 0) {
				arr[i] = 4;
				arr_sep[3]--;
			}
		}
		// 인덱스
		// + :0
		// - :1
		// x :2
		// / :3
		Arrays.sort(arr);
		for (int i = 0; i < N - 1; i++) {
			if (i == 0) {
				if (arr[i] == 1) {
					result = num[i] + num[i + 1];
				} else if (arr[i] == 2) {
					result = num[i] - num[i + 1];
				} else if (arr[i] == 3) {
					result = num[i] * num[i + 1];
				} else if (arr[i] == 4) {
					result = num[i] / num[i + 1];
				}
			} else {
				if (arr[i] == 1) {
					result += num[i + 1];
				} else if (arr[i] == 2) {
					result -= num[i + 1];
				} else if (arr[i] == 3) {
					result *= num[i + 1];
				} else if (arr[i] == 4) {
					result /= num[i + 1];
				}
			}
		}
		// System.out.println(result);
		min_result = result;
		int i = N - 2;

		while (visited) {
			i = N - 2;

			while (i > 0 && arr[i - 1] >= arr[i])
				i -= 1;
			int j = N - 2;
			if (i <= 0) {
				visited = false;
			} else {
				while (j > 0 && arr[i - 1] >= arr[j]) {
					j -= 1;
				}
				int temp = 0;
				if (j <= 0) {
				} else {
					temp = arr[i - 1];
					arr[i - 1] = arr[j];
					arr[j] = temp;
				}
				j = N - 2;
				while (i < j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i++;
					j--;
				}

			}
			if (visited) {
				for (int t = 0; t < N - 1; t++) {
					if (t == 0) {
						if (arr[t] == 1) {
							result_temp = num[t] + num[t + 1];
						} else if (arr[t] == 2) {
							result_temp = num[t] - num[t + 1];
						} else if (arr[t] == 3) {
							result_temp = num[t] * num[t + 1];
						} else if (arr[t] == 4) {
							result_temp = num[t] / num[t + 1];
						}
					} else {
						if (arr[t] == 1) {
							result_temp += num[t + 1];
						} else if (arr[t] == 2) {
							result_temp -= num[t + 1];
						} else if (arr[t] == 3) {
							result_temp *= num[t + 1];
						} else if (arr[t] == 4) {
							result_temp /= num[t + 1];
						}
					}
				}
				if (result < result_temp) {
					result = result_temp;

				} else {

				}
				if (min_result > result_temp) {
					min_result = result_temp;
					result_temp = 0;
				} else {
					result_temp = 0;
				}
			}

		}

		bw.write(result + "\n");
		bw.write(min_result + "\n");
		bw.flush();
	}

}
