import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> deque = new LinkedList<Integer>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		String str1;
		int value;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			str1=st.nextToken();
			if(str1.equals("push_back")) {
				value=Integer.parseInt(st.nextToken());
				deque.addLast(value);
			}else if(str1.equals("push_front")) {
				value=Integer.parseInt(st.nextToken());
				deque.addFirst(value);
			}else if(str1.equals("pop_front")) {
				if(deque.isEmpty()) {
					bw.write("-1"+"\n");
				}else {
					value=deque.pollFirst();
					bw.write(value+"\n");
				}
				
			}else if(str1.equals("pop_back")) {
				if(deque.isEmpty()) {
					bw.write("-1"+"\n");
				}else {
					value=deque.pollLast();
					bw.write(value+"\n");
				}
			}else if(str1.equals("front")) {
				if(deque.isEmpty()) {
					bw.write("-1"+"\n");
				}else {
					bw.write(deque.peekFirst()+"\n");
				}
			}else if(str1.equals("back")) {
				if(deque.isEmpty()) {
					bw.write("-1"+"\n");
				}else {
					bw.write(deque.peekLast()+"\n");
				}
			}else if(str1.equals("size")) {
				bw.write(deque.size()+"\n");
			}else if(str1.equals("empty")) {
				if(deque.isEmpty()) {
					bw.write("1"+"\n");
				}else {
					bw.write("0"+"\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}