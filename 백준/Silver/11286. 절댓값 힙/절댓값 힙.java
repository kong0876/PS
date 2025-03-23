import java.io.*;
import java.util.*;

// [11286] 절댓값 힙

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) ->  {
			int absX = Math.abs(x);
			int absY = Math.abs(y);
			
			if(absX == absY) {
				if(x <= y) 
					return -1;
				else
					return 1;
			}
			
			else if(absX <= absY)
				return -1;
			else
				return 1;
		});

		int n = Integer.parseInt(br.readLine()); // n개의 연산

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) { // 배열에 x 추가
				pq.offer(x);
			} else { // x == 0 배열에서 절대값이 가장 작은 값 출력
				if(!pq.isEmpty())
					System.out.println(pq.poll());
				else
					System.out.println(0);
			}
		}
	}
}