class Solution {
    int find (int x, int[] parent){
        if(parent[x]==-1)
            return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
    
    void union(int x, int y, int[] parent){
        int xp = find(x, parent);
        int yp = find(y, parent);
        if(xp != yp)
            parent[yp] = xp;
    }
    public int largestComponentSize(int[] A) {
        int n = A.length;
        int[] parent = new int[100001];
        for(int i = 0; i < 100001; ++i)
            parent[i] = -1;
        
           for(int i =0; i <n; i++){
            for(int k = 2; k <= Math.sqrt(A[i]); ++k){
                if(A[i]% k == 0){
                    union(A[i], k, parent);
                    union(A[i], A[i]/k, parent);
                }
            }
        }
        
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i =0; i <n; i++){
            int p = find(A[i], parent);
            count = Math.max(count, 1 + hm.getOrDefault(p, 0));
            hm.put(p, 1 + hm.getOrDefault(p, 0));
        }
        return count;
    }
}
