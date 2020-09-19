class Solution {
    public int lengthOfLIS(int[] nums) {
        return LISHelper(-1, 0, nums);
    }
    
    private static int LISHelper(int prev, int curr, int nums[]){
        if(curr == nums.length) return 0;
        
        int op1 = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            op1 =  1 + LISHelper(curr, curr+1,nums);
        }        
        int op2 = LISHelper(prev, curr+1,nums);
       
        return Math.max(op1, op2);
    }
}