package pack;

import java.util.*;
import java.io.*;

public class lineup {

	final public static String[] cows = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};

	public static int n;
	public static int[][] list;
	
	public static void main(String[] args) throws Exception {
		
		HashMap<String,Integer> m = new HashMap<String,Integer>();
		for (int i = 0; i < cows.length; i++) m.put(cows[i], i);
		
		Scanner in = new Scanner(new File("lineup.in"));
		n = in.nextInt();
		
		list = new int[n][2];
		for (int i = 0; i < n; i++) {
			list[i][0] = m.get(in.next());
			for (int j = 0; j < 4; j++) in.next();
			list[i][1] = m.get(in.next());
		}
		
		int[] perm = new int[cows.length];
		boolean[] used = new boolean[cows.length];
		go(perm, used, 0);
		
		PrintWriter out = new PrintWriter(new FileWriter("lineup.out"));
		for (int i = 0; i < cows.length; i++)
			out.println(cows[perm[i]]);
		out.close();		
		in.close();
	}
	
	public static boolean go(int[] perm, boolean[] used, int k) {
		
		if (k == perm.length) return valid(perm);
			
		for (int i = 0; i < perm.length; i++) {
			if (!used[i]) {
				perm[k] = i;
				used[i] = true;
				boolean tmp = go(perm, used, k + 1);
				if (tmp) return true;
				used[i] = false;
			}
		}
		
		return false;
	}
	
	public static boolean valid(int[] perm) {
		
		int[] indexOf = new int[perm.length];
		for (int i = 0; i < perm.length; i++) {
			indexOf[perm[i]] = i; 
		}
		
		for (int i = 0; i < n; i++) 
			if (Math.abs(indexOf[list[i][0]]-indexOf[list[i][1]]) != 1) {
				return false;
			}

		return true;
	}
}
