class Solution {

    public boolean backspaceCompare(String S, String T) {
       
       String  s  = backspaceString(S);
       String  t  = backspaceString(T);
   
      return s.equals(t);
    }
    
    private String backspaceString(String s) {
     
        StringBuilder sb = new StringBuilder();
        int count = 0;
		
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                count++;
            } else if (count != 0) {
                count--;
            } else {
                sb.append(s.charAt(i)); 
            }
        }
        return sb.toString();
    }
}