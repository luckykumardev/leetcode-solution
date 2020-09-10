class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() !=  t.length())
            return false;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            if(hm.containsKey(s.charAt(i)))
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            else
                hm.put(s.charAt(i), 1);
        }
        
        for(int i =0; i < t.length(); i++){
            if(hm.containsKey(t.charAt(i))){
                hm.put(t.charAt(i), hm.get(t.charAt(i)) - 1);   
                if(hm.get(t.charAt(i))  == 0)
                    hm.remove(t.charAt(i));
            }
            else
               return false;
        }
        return true;
    }
}