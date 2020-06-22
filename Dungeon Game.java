class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        HashMap<String, Integer> hm = new HashMap<>();
        return rec(0, 0, dungeon, hm);
    }
    
    private int rec(int i, int j, int[][] dungeon, HashMap<String, Integer> hm) {
        if(i >= dungeon.length || j >= dungeon[0].length)
            return Integer.MAX_VALUE;
        String key = i + "Codebix"  + j;
        if(hm.containsKey(key))
             return hm.get(key);
        int next = Math.min(rec(i+1, j, dungeon, hm), rec(i, j+1, dungeon, hm));
    
        if(next == Integer.MAX_VALUE)
           next  = 1;
        
        int res = Math.max(next - dungeon[i][j], 1);
        hm.put(key, res);
        return res;
    }
}