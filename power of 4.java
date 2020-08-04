class Solution {
    public boolean isPowerOfFour(int num) {
        int count = 0;
        for(int i =0;i <32; i++){
            if (((num >>> i) & 1) != 0){ 
                count++;
                if(i%2 == 1) return false;
            }
        }
        if(count == 1) return true;
        else return false;
    }
}