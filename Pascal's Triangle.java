class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for(int i =1; i <numRows; i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j =1; j <i; j++){
               curr.add(res.get(i-1).get(j-1) + res.get(i-1).get(j)); 
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}