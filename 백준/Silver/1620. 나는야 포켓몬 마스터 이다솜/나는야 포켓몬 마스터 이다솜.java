import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

// [1620 나는야 포켓몬 마스터 이다솜]
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashMap<Integer, String> numToname = new HashMap<>();
		HashMap<String, Integer> nameTonum = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int num = 1; num <= n; num++) {
			String name = br.readLine();
			numToname.put(num, name);
			nameTonum.put(name, num);

		}

		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			if (Character.isDigit(input.charAt(0))) {
				System.out.println(numToname.get(Integer.parseInt(input)));
				;
			} else {
				System.out.println(nameTonum.get(input));
			}
		}
	}
}
