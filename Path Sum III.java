class Solution {
    int total = 0;
   public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        findPathSum(root, 0, sum, hm);  
        return total; 
   }
    private void findPathSum(TreeNode curr, int sum, int target, HashMap<Integer, Integer> hm) {
        if (curr == null)
            return;
        
        sum += curr.val;
        if(hm.containsKey(sum-target))
          total += hm.get(sum-target);
        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
         findPathSum(curr.left, sum, target, hm);
         findPathSum(curr.right, sum, target, hm);
        hm.put(sum, hm.get(sum) - 1);
        return;
    }
}