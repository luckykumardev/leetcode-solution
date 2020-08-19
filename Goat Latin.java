class Solution {
    public String toGoatLatin(String S) {
       String arr[] = S.split(" ");
       int n = arr.length;
       StringBuilder sb1 = new StringBuilder("ma");
       StringBuilder sb2 = new StringBuilder();
       for(int i = 0; i<n; i++){
           sb1.append('a');
           if(isVowel(arr[i].charAt(0))){
               arr[i] += sb1.toString();
           }else{
               arr[i] = arr[i].substring(1) + arr[i].charAt(0) + sb1.toString(); 
           }
            sb2.append(arr[i] + " ");
       }   
  
       sb2.deleteCharAt(sb2.length() -1);
       return sb2.toString();
    }
    
     private boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
               c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    } 
    
}