class Solution {
  public boolean isPalindrome(String s) {
    if (s == null) {
        return false;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
        if (!isAlphanumeric(s.charAt(left))) {
            left++;
        } else if (!isAlphanumeric(s.charAt(right))) {
            right--;
        } else if (lowerCase(s.charAt(left)) != lowerCase(s.charAt(right)))  {
            return false;
        } else {
            left++;
            right--;
        }
    }
    return true;
}

private boolean isAlphanumeric(char c) {
    return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9');
}
    
private char lowerCase(char c){
      if('a' <= c && c <= 'z' ||  ('0' <= c && c <= '9')) return c;
       
        return (char)((int)c+32);
    }
}