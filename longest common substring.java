import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	  Scanner sc = new Scanner(System.in);
	  int t = sc.nextInt();
	  while(t-- > 0){
	      int m   = sc.nextInt();
          int n   = sc.nextInt();
          String A = sc.next();
          String B = sc.next();
        HashMap<String, Integer> hm = new HashMap<>();
        System.out.println(lcs(A, B, 0, 0, 0, hm));
         
	  }
	 }
	 
public static int lcs(String X, String Y, int i, int j, int count,  HashMap<String, Integer> hm ) { 
        if (i >= X.length() || j >= Y.length()) 
            return count; 
        String key = i + "code" + j +"bix" + count;
        if(hm.containsKey(key))
          return hm.get(key);

        int same = count;
        if (X.charAt(i) == Y.charAt(j)) { 
            same = lcs(X, Y, i + 1, j + 1, count + 1, hm); 
        }
        int diff1 = lcs(X, Y, i, j + 1, 0, hm);
        int diff2 =  lcs(X, Y, i + 1, j, 0, hm);
        int res = Math.max(same, Math.max(diff1, diff2));
        hm.put(key, res);
        return res; 
    } 
}
	 