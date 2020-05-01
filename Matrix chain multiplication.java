class CodeBix
 {
    //tabulation
 	public static int MatrixChainOrder(int p[]) 
    {   
        int n = p.length;
        int dp[][] = new int[n][n];

        for (int L=2; L<n; L++) 
        { 
            for (int  start =1; start <n-L+1; start++) 
            { 
                int end = start+L-1; 
                if(end == n) break; 
                dp[start][end] = Integer.MAX_VALUE; 
                for (int k=start; k<=end-1; k++) 
                { 
                    int cost = dp[start][k] + dp[k+1][end] + p[start-1]*p[k]*p[end]; 
                    if (cost < dp[start][end]) 
                        dp[start][end] = cost; 
                } 
            } 
        } 
  
        return dp[1][n-1];
    } 
    

    //memoization
	public static int MatrixChainOrder(int p[], int start, int end, int memo[][]) 
    { 
        if (start == end) 
            return 0; 
  
        int min = Integer.MAX_VALUE; 
        if(memo[start][end] > 0) return memo[start][end];
        for (int k = start; k < end; k++) { 
            int count = MatrixChainOrder(p, start, k, memo) + MatrixChainOrder(p, k + 1, end, memo) + p[start - 1] * p[k] * p[end]; 
  
            if (count < min) 
                min = count;        
        } 
         
        memo[start][end] = min;
        return min; 
    } 
  
  
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int p[] = new int[n];
            for(int i = 0; i <n; i++)
             p[i] = sc.nextInt();
            // int memo[][] = new int[n][n];
            // int ans = MatrixChainOrder(p, 1, n-1, memo);        
            int ans = MatrixChainOrder(p);
            System.out.println(ans);
    }

} 
