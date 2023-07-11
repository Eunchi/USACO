import java.util.*;

public class photoshoot {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] s = in.next().toCharArray();
		
		ArrayList<Boolean> items = new ArrayList<Boolean>();
		
		for (int i=0; i<n; i+=2) {		
			if (s[i] == 'G' && s[i+1] == 'H') {
				items.add(true);
			}
			if (s[i] == 'H' && s[i+1] == 'G') {
				items.add(false);
			}
		}
		
		System.out.println(solve(items));
	}
	
	public static int solve(ArrayList<Boolean> items) {
	
		if (items.size() == 0) {
			return 0;
		}
	
		boolean hasTrue = false;
		for (Boolean x: items) hasTrue = hasTrue || x;
	
		if (!hasTrue) {
			return 0;
		}
		
		int numRuns = 0, i = 0;
		
		while (i < items.size()) {
		
			while (i < items.size() && items.get(i) == false) {
				i++;
			}
		
			if (i == items.size()) {
				break;
			}
			
			numRuns++;
			while (i < items.size() && items.get(i) == true) {
				i++;
			}
		}
		
		int res = 2 * numRuns-1;
		
		if (items.get(0) == false) {
			res++;
		}
		
		return res;
	}
}
