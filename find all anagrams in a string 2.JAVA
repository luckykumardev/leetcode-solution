class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(p.length() >= s.length()) return  list;
       
            int N = s.length(); 
            int M = p.length();
            int[] count = frequency(p);
            
            int[] currentCount = frequency(s.substring(0, M));
            
            if(areSame(count, currentCount)) 
                list.add(0);
        
            int i;
            for(i = M; i < N; i++){
                currentCount[s.charAt(i - M) - 'a']--;
                currentCount[s.charAt(i) - 'a']++;
                if(areSame(count, currentCount)){
                    list.add(i - M + 1);
                }
            }
        
        return list;
    }
    
    private boolean areSame(int[] x, int[] y){
        for(int i = 0; i < 26; i++){
            if(x[i] != y[i])
                return false;
        }
        
        return true;
    }
    
    private int[] frequency(String s){
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        
        return count;
    }
}