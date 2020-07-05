class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int n = x^y;
        for(int i=0; i<32; i++)
        {
            if(((n>>i)&1) == 1){
                count++;
            }
                
        }
        return count;
    }
}