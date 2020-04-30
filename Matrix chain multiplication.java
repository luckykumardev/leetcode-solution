class CodeBix
 {

	static int MatrixChainOrder(int p[], int start, int end, int memo[][]) 
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
            int cost[] = new int[n];
            for(int i = 0; i <n; i++)
             cost[i] = sc.nextInt();
            int memo[][] = new int[n][n];
            int ans = MatrixChainOrder(cost, 1, n-1, memo);
            System.out.println(ans);
    }

} 
