import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, Integer> map = new TreeMap<>();
		String input;
		int sum = 0;
		while ((input = br.readLine()) != null) {
			sum++;
			if (map.containsKey(input)) {
				map.put(input, map.get(input) + 1);
			} else {
				map.put(input, 1);
			}
		}

		for (String k : map.keySet()) {
			System.out.printf("%s %.4f\n",k,map.get(k)*1.0/sum * 100);
		}
	}
}
