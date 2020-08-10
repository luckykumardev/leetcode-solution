class Solution {
    public int titleToNumber(String s) {
        int ans  = 0;
        int p  = 0;
        for(int i = s.length() -1; i>=0; i--){
           char c = s.charAt(i);
           int val = (int)c - 65 + 1;
           ans += val*Math.pow(26, p);
            p++;
        }
        
        return ans;
    }
}