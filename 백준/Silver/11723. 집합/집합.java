import java.util.*;
import java.io.*;

// [11723] 집합
public class Main {

	static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> all = new HashSet<>();
		
		for(int i = 1; i <= 20; i++) {
			all.add(i);
		}
		
		m = Integer.parseInt(br.readLine()); // 연산의 수
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			String com = st.nextToken();
			int num;
			
			switch (com) {
			case ("add"):
				num = Integer.parseInt(st.nextToken());
				set.add(num);
				break;
			case ("remove"):
				num = Integer.parseInt(st.nextToken());
				set.remove(num);
				break;
			case ("check"):
				num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case ("toggle"):
				num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					set.remove(num);
				} else {
					set.add(num);
				}
				break;
			case ("all"):
				set.addAll(all);
				break;
			case ("empty"):
				set.removeAll(set);
				break;
			}
		}
		System.out.println(sb);
	}
}
