package pack;

import java.util.*;
import java.io.*;

public class blocks {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("blocks.in"));
		int n = Integer.parseInt(in.readLine());

		int[] freq = new int[26];

		for (int i=0; i<n; i++) {
			StringTokenizer tok = new StringTokenizer(in.readLine());
			String s = tok.nextToken();
			String t = tok.nextToken();

			int[] max = getMaxFreq(s, t);
			add(freq, max);
		}

		PrintWriter out = new PrintWriter(new FileWriter("blocks.out"));
		for (int i=0; i<26; i++)
			out.println(freq[i]);
		out.close();
		in.close();
	}

	public static void add(int[] a, int[] b) {
		for (int i=0; i<26; i++)
			a[i] += b[i];
	}

	public static int[] getMaxFreq(String s, String t) {
		int[] f1 = getFreq(s);
		int[] f2 = getFreq(t);
		int[] res = new int[26];
		for (int i=0; i<26; i++)
			res[i] = Math.max(f1[i], f2[i]);
		return res;
	}

	public static int[] getFreq(String s) {
		int[] res = new int[26];
		for (int i=0; i<s.length(); i++)
			res[s.charAt(i)-'a']++;
		return res;
	}
}
