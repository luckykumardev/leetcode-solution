class Solution {
   public int numDecodings(String s) {

    //recursive
    // int ans = numDecodings(s, 0); 
    
    //memo
    // int arr[] = new int[s.length() +1];
    // int ans = numDecodings(s, 0, arr); 
    
    //tabulation
     int ans = numDecodingsTab(s); 


    return ans;
}

//tabulation
public int numDecodingsTab(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

//memo

private int numDecodings(String s, int index, int arr[]) {
	if (index == s.length() ) {
		return 1;
	}
	if (s.charAt(index) == '0') {
		return 0;
	}
    
    if (index == s.length() - 1) {
		return 1;
	}
    if(arr[index] > 0){
        return arr[index];
    }
    
    int way1 = numDecodings(s, index + 1, arr);
	int way2 = 0;
	if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
		way2 = numDecodings(s, index + 2, arr);
	}

    arr[index] = way1 + way2;
	return arr[index];
}



//recusive
private int numDecodings(String s, int index) {
	if (index == s.length() ) {
		return 1;
	}
	if (s.charAt(index) == '0') {
		return 0;
	}
    
    if (index == s.length() - 1) {
		return 1;
	}
    
    int way1 = numDecodings(s, index + 1);
	int way2 = 0;
	if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
		way2 = numDecodings(s, index + 2);
	}
	return way1 + way2;
}
    
}