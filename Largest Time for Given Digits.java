class Solution {
    public String largestTimeFromDigits(int[] A) {
        List<List<Integer>> res = new ArrayList<>();
    	List<String> valid = new ArrayList<>();
        boolean visited[] = new boolean[4];
        backtrack(res, A, new ArrayList<>(), visited);
        for(int i =0; i <res.size(); i++){
            String curr = "";
            for(int j =0; j <res.get(i).size(); j++){
               curr += res.get(i).get(j);
            }
           if(isValid(curr)) valid.add(curr); 
        }
        Collections.sort(valid);
        String ans = "";
        if(valid.size() >0) { 
           String temp = valid.get(valid.size() -1);
            ans = temp.substring(0, 2)+":" + temp.substring(2);
        }
        
        
        return ans;
    }


    private static boolean isValid(String s){
        if(s.charAt(0) > '2') return false;
        if(s.charAt(0) == '2'){
         if(s.charAt(1) >= '4') return false;   
        } 
        if(s.charAt(2) >= '6') return false;
        return true;
    }
 
     void backtrack( List<List<Integer>> res,int[] nums,List<Integer> curr, boolean[] visited){
                if(curr.size()==nums.length){
                 res.add(new ArrayList(curr));
                    return;
                }

                for(int i=0;i<nums.length;i++){
                    if(visited[i]==true)continue;
                    curr.add(nums[i]);
                    visited[i] = true;
                    backtrack(res,nums, curr,visited);
                    curr.remove(curr.size()-1);
                    visited[i] = false;
                } 
    }
    
 
}