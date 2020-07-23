class Solution {
   public int[] singleNumber(int[] nums) {
    int xor2no = 0;
    for(int num: nums){
        xor2no ^= num;
    }
     int lowestBit = xor2no&(-xor2no);
    
    int[] result = new int[2];
    for(int num: nums){
        if((lowestBit & num) == 0){
            result[0] ^= num;
        }
        else{
            result[1] ^= num;
        }
    }
    return result;
 }
}