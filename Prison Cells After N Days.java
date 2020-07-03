class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
		if(cells==null || cells.length==0 || N<=0) return cells;
        boolean hasCycle = false;
        int cycle = 0;
        HashSet<String> set = new HashSet<>(); 
        for(int i=0;i<N;i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){ 
                set.add(key);
                cycle++;
            }
            else{
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle){
            N = N%cycle;
            for(int i=0;i<N;i++){
                cells = nextDay(cells);
            }   
        }
       
        return cells;
    }
    
    private int[] nextDay(int[] cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            if(cells[i-1]==cells[i+1])
                tmp[i] = 1;
        }
        return tmp;
    }
}

