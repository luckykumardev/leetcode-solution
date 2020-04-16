class Solution {
    public int findDuplicate(int[] nums) {
         if(nums.length==0)
        return 0;
    
    
    for(int i=0;i<nums.length;i++)
    {
        int temp = Math.abs(nums[i]);
        
        if(nums[temp]>0)
            nums[temp]*=-1;
        else
            return temp;
    }    
    return -1;
    }
}