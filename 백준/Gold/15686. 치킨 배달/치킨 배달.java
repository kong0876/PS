import java.io.*;
import java.util.*;

public class Main {

    static class Loc {
        int row, col;

        Loc(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int n, m;
    static int[][] city;

    static List<Loc> houses = new ArrayList<>();
    static List<Loc> chickens = new ArrayList<>();
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                city[row][col] = Integer.parseInt(st.nextToken());
                if (city[row][col] == 1) {
                    houses.add(new Loc(row, col));
                } else if (city[row][col] == 2) {
                    chickens.add(new Loc(row, col));
                }
            }
        }

        comb(0, new ArrayList<>());
        System.out.println(minDist);
    }

    static void comb(int start, List<Loc> selected) {
        if (selected.size() == m) {
            int total = 0;
            for (Loc house : houses) {
                int d = Integer.MAX_VALUE;
                for (Loc chick : selected) {
                    int dist = Math.abs(house.row - chick.row) + Math.abs(house.col - chick.col);
                    d = Math.min(d, dist);
                }
                total += d;
            }
            minDist = Math.min(minDist, total);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            comb(i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }
}
