class Solution {
    public String stringShift(String s, int[][] shift) {
        int n = s.length();
        String temp =  "";
          
        for(int i = 0 ; i <shift.length; i++){
             temp ="";
           
            if(shift[i][0] == 1){
                     temp = temp + s.substring(n - shift[i][1]);
                     temp  = temp + s.substring(0, n - shift[i][1]);
            }
            else{
                  temp = temp + s.substring(shift[i][1]);
                  temp = temp + s.substring(0, shift[i][1]);
                
             }
            s = temp;
                
        }
        return s;
    }
}