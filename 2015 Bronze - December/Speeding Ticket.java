import java.util.*;
import java.io.*;

public class speeding {

    final public static int DISTANCE = 100;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("speeding.in"));
		StringTokenizer t = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(t.nextToken());
        int m = Integer.parseInt(t.nextToken());

        int[] limits = new int[DISTANCE];
        int mile = 0;

        for (int i = 0; i < n; i++) {
            t = new StringTokenizer(in.readLine());
            int dist = Integer.parseInt(t.nextToken());
            int speed = Integer.parseInt(t.nextToken());
            for (int j = 0; j < dist; j++)
                limits[mile++] = speed;
        }

        int[] bessie = new int[DISTANCE];
        mile = 0;
        for (int i = 0; i < m; i++) {
            t = new StringTokenizer(in.readLine());
            int dist = Integer.parseInt(t.nextToken());
            int speed = Integer.parseInt(t.nextToken());
            for (int j = 0; j < dist; j++)
                bessie[mile++] = speed;
        }

        int res = 0;
        for (int i = 0; i < DISTANCE; i++)
            res = Math.max(res, bessie[i] - limits[i]);

		FileWriter fout = new FileWriter(new File("speeding.out"));
        fout.write(res + "\n");
		fout.close();
	}
}
