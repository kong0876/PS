import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

// [1269] 대칭 차집합


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken()); // a
		int b = Integer.parseInt(st.nextToken()); // b

		HashSet<Integer> setA = new HashSet<>();
		HashSet<Integer> setB = new HashSet<>();

		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			setA.add(Integer.parseInt(st.nextToken()));

		}

		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			setB.add(Integer.parseInt(st.nextToken()));
		}

		int sizeA = setA.size();
		for (int i : setA) {
			if (setB.contains(i)) {
				sizeA--;
			}
		}

		int sizeB = setB.size();
		for (int i : setB) {
			if (setA.contains(i)) {
				sizeB--;
			}
		}

		System.out.println(sizeA+sizeB);


	}
}