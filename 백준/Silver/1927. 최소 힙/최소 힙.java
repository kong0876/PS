import java.io.*;
import java.util.*;

// [1927] 최소 힙

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if(!pq.isEmpty())
					System.out.println(pq.poll());
				else
					System.out.println(0);
			} else {
				pq.offer(x);
			}
		}
	}
}