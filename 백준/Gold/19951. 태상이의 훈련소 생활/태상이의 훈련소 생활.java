import java.util.*;
import java.io.*;

// [19951 태상이의 훈련소 생활] 
// 조교들의 지시를 모두 수행한 뒤 각 칸의 높이 구함

public class Main {

	static int n, m;
	static int[] ybj;
	static int[] work;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 연병장 크기 : n
		m = Integer.parseInt(st.nextToken()); // 조교 수 : m

		ybj = new int[n + 1]; // 1 ~ n까지의 연병장
		work = new int[n + 2]; // 땅 파는 계획

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			ybj[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println("연병장 : " + Arrays.toString(ybj));

		for (int i = 0; i < m; i++) {// m개의 조교 지시
			st = new StringTokenizer(br.readLine());
			// a ~ b 칸까지 k 만큼 연병장에 더함
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			// 걍 더하면 터짐 10만명의 조교가 10만개의 연병장에 다 연산할 수 있으므로, 10^10
			// a에서는 기존 값으로 넣고, b에서는 반대 값으로 넣은 뒤에 나중에, 판을 지나며 누적 값 만큼 높이 변경
			work[a] += k;
			work[b + 1] += -k;
		}

//		System.out.println("계획 : " + Arrays.toString(work));
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			sum += work[i];
			ybj[i] += sum;
		}

//		System.out.println("태상이가 지나간 후.. : " + Arrays.toString(ybj));

		for(int i = 1; i <= n; i ++) {
			System.out.print(ybj[i] + " ");
		}
	}
}
