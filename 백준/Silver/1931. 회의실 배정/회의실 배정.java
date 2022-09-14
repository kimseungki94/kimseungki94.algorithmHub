
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;

	static class MeetingRoom implements Comparable<MeetingRoom> {
		int start, end;

		public MeetingRoom(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		// 회의가 5시~ 5시로 될수도 있다! 종료시간이 빠른게 우선이고 종료시간이 같으면 시작시작이 빠른걸 먼저!
		@Override
		public int compareTo(MeetingRoom o) {
			int res = this.end - o.end;
			if (res == 0) {
				return this.start - o.start; // res가 같으면 시작시간을 보자!
			}
			return res;
		}
	}
	static MeetingRoom[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		list = new MeetingRoom[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			list[i] = new MeetingRoom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		}
		
		System.out.println(getCount());
	}

	private static int getCount() {
		Arrays.sort(list);
		ArrayList<MeetingRoom> pick = new ArrayList<MeetingRoom>();
		pick.add(list[0]);
		
		for (int i = 1; i < N; i++) {
			if(pick.get(pick.size()-1).end<=list[i].start) {
				pick.add(list[i]);
			}
		}
		
		return pick.size();
	}

}
