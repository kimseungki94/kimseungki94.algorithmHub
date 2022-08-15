import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] store = new int[26];
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		char[] arr = str.toCharArray();
		for(int i=0;i<arr.length;i++) {
			store[((int)arr[i]-97)]+=1;
		}
		for(int i=0;i<store.length;i++) {
			bw.write(store[i]+" ");
		}
		bw.flush();
		bw.close();
	}
}