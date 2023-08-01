package pack;

import java.io.*;
import java.util.*;

public class shell {
	
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new File("shell.in"));
		int n = in.nextInt();
		int[] cur = new int[3];
		for (int i = 0; i < 3; i++) cur[i] = i;
		
		int[] winCnt = new int[3];
		
		for (int i = 0; i < n; i++) {
			
			int idx1 = in.nextInt()-1;
			int idx2 = in.nextInt()-1;
			
			int tmp = cur[idx1];
			cur[idx1] = cur[idx2];
			cur[idx2] = tmp;
			
			int guess = in.nextInt()-1;
			
			winCnt[cur[guess]]++;
		}
		
		int res = winCnt[0];
		for (int i = 1; i < 3; i++) res = Math.max(res, winCnt[i]);
		
		PrintWriter out = new PrintWriter(new FileWriter("shell.out"));
		out.println(res);
		out.close();
		in.close();
	}

}
