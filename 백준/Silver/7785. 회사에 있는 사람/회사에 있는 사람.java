import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
// [7785 회사에 있는 사람]
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashMap<String, Boolean> enter = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String comm = st.nextToken();
			
			if(comm.equals("enter")) {
				enter.put(name, true);
			} else {
				enter.remove(name);
			}
			
		}
		
		ArrayList<String> list = new ArrayList<>(enter.keySet());
		Collections.sort(list, Collections.reverseOrder());
		
		for(String s : list) {
			System.out.println(s);
		}
	}
}
