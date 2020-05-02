class Solution {
    //without hashmap
    public int numJewelsInStones(String J, String S) {
        char []temp = S.toCharArray();
        int n = 0;
        for(int i = 0; i < temp.length; ++i){
            if(J.indexOf(temp[i]) != -1){
                n++;
            }
        }
        return n;
    }
    
    //with hashmap
    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            char key = S.charAt(i);
            if(hm.containsKey(key))
                hm.put(key, hm.get(key) + 1);
            else
                hm.put(key, 1);
        }
        int ans = 0;
        for(int i =0; i <J.length(); i++){
            char key = J.charAt(i);
            if(hm.containsKey(key))
                ans = ans  + hm.get(key);
        }
            return ans;
    }
}