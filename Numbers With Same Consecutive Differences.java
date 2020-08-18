class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        ArrayList<Integer> res = new ArrayList();
        if (N == 1)
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            
        for (int i = 1; i <= 9 ; i++)
            dfs(N, K, i, 0, i, res);
        
        int ans[] = new int[res.size()];
        for(int i =0; i<res.size(); i++)
             ans[i] = res.get(i);
     
        return ans;
    }
    
    private void dfs(int N, int K, int cur, int i, int prev, ArrayList<Integer> res) {
        
        if (i == N - 1) {
            res.add(cur);
            return;
        }
        int next = prev + K;
        if (next < 10){
            
            dfs(N, K, (cur * 10) + next, i + 1, next, res);
        }
         next = prev - K;

        if (K != 0 &&  next >= 0){
            dfs(N, K, (cur * 10) + next, i + 1, next, res);
        }
    }
}
