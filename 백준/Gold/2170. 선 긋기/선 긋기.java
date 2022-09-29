import java.io.*;
import java.util.*;

class Point {
    long x, y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            lines.add(new Point(x, y));
        }

        lines.sort(((o1, o2) -> {
            if(o1.x>o2.x) return 1;
            else if(o1.x==o2.x) {
                if(o1.y>o2.y) {
                    return 1;
                }
            }
            return -1;
        }));

        long s = lines.get(0).x;
        long e = lines.get(0).y;
        long sum = e - s;

        for (int i = 1; i < N; i++) {
            long ns = lines.get(i).x;
            long ne = lines.get(i).y;

            if ((s <= ns) && (ne <= e)) {
                continue;
            } else if (ns < e) {
                sum += -(e - ns) + (ne - ns);
            } else {
                sum += ne - ns;
            }
            s = ns;
            e = ne;
        }

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}