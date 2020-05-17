class Solution {
  public List<Integer> findAnagrams(String s, String p) {
        int st = 0;
        int e = p.length() -1;
        List<Integer> ans = new ArrayList<Integer>();
        if(p.length() > s.length() || st > e) return ans;
       
        HashMap<Character, Integer> hms = new HashMap<>();
        HashMap<Character, Integer> hmp = new HashMap<>();

        for(int i = 0; i < p.length(); i++){
           char ch = p.charAt(i);
           hmp.put(ch, hmp.getOrDefault(ch, 0) + 1);
        }
        
        
        for(int i = 0; i <=e ; i++){
           char ch = s.charAt(i);
           hms.put(ch, hms.getOrDefault(ch, 0) + 1);
        }
        
        if(hms.equals(hmp))
            ans.add(st);
        
         st++; e++;     
        while(e < s.length()){
        
            // add key for e
            char ch = s.charAt(e);
            hms.put(ch, hms.getOrDefault(ch, 0) + 1);
            
            //remove key for st
            ch = s.charAt(st-1);
            if(hms.containsKey(ch)){
               hms.put(ch, hms.get(ch) - 1);
                
              if(hms.get(ch) == 0)
                  hms.remove(ch);
            }
                    
            if(hms.equals(hmp))   ans.add(st);
            
            st++; e++;
        }
        
        return ans;
    }
}