class Solution {
  public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
          
         //rec
          int ans = rec(0,0, grid);
       
      
      return ans;
    }

    public static int rec(int si, int sj, int grid[][]){
        int ei = grid.length-1;
        int ej = grid[0].length-1;
        if(si == ei && sj == ej)
             return grid[si][sj];
        
        
        if(si >ei || sj >ej)
            return Integer.MAX_VALUE;
        
        int op1 =  rec(si+1, sj, grid);
        int op2 =  rec(si, sj+1, grid);
        
        return grid[si][sj] + Math.min(op1, op2);
    }
    














    
    public static int memo(int si, int sj, int grid[][], HashMap<String, Integer> mhm){
        int ei = grid.length-1;
        int ej = grid[0].length-1;
        if(si == ei && sj == ej)
             return grid[si][sj];
        
        
        if(si >ei || sj >ej)
            return Integer.MAX_VALUE;
        
        String key = si+"#"+sj;
        if(mhm.containsKey(key))
             return mhm.get(key);
        int op1 =  memo(si+1, sj, grid, mhm);
        int op2 =  memo(si, sj+1, grid, mhm);
        
        mhm.put(key, grid[si][sj] + Math.min(op1, op2));
        return grid[si][sj] + Math.min(op1, op2);
    }
    
}
