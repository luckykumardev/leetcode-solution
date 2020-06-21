class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        return rec(0, 0, dungeon);
    }
    
    private int rec(int i, int j, int[][] dungeon) {
        if(i >= dungeon.length || j >= dungeon[0].length)
            return Integer.MAX_VALUE;
       
        int health = Math.min(rec(i+1, j, dungeon), rec(i, j+1, dungeon));
    
        if(health == Integer.MAX_VALUE)
           health  = 1;
        
        int res = 0;
        if(health - dungeon[i][j] > 0)
            res = health - dungeon[i][j];
        else 
            res = 1;
        
        return res;
    }
}