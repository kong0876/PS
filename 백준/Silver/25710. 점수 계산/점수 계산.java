import java.util.*;
import java.io.*;

// [25710 점수 계산] 

public class Main {

	static int n;
	static HashSet<Integer> set1 = new HashSet<>();
	static HashSet<Integer> set2 = new HashSet<>();
	static ArrayList<Integer> arr = new ArrayList<>();
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (!set1.contains(input)) {
				set1.add(input);
			} else {
				set2.add(input);
			}
		}

		for (int n : set1) {
			arr.add(n);
		}

		for (int n : set2) {
			arr.add(n);
		}

//		System.out.println(arr);

		int res = 0;

		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = i + 1; j < arr.size(); j++) {

				int tempRes = calc(arr.get(i) * arr.get(j));
				res = Math.max(res, tempRes);
			}
		}

		System.out.println(res);

	}

	static int calc(int num) {
		int sum = 0;
		
		while(num != 0) {
			sum += num%10;
			num/=10;
		}
		
		return sum;
	}
}
