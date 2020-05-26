class Solution {
    public int maxUncrsossedLines(int[] A, int[] B) {
        HashMap<String, Integer> hm = new HashMap<>();
        return rec(A, 0, B, 0, hm);
    }
    private int rec(int[] A, int i, int[] B, int j,  HashMap<String, Integer> hm){
        if(i == A.length || j == B.length) return 0;
        String key = i + "codebix"+ j;
        if(hm.containsKey(key)) return hm.get(key);
        int count = 0;
        if(A[i] == B[j]) 
            count = 1+rec(A, i+1, B, j+1);
        else
        	count += Math.max(rec(A, i+1, B, j), rec(A, i, B, j+1));
        hm.put(key, count);
        return count;
    }
}