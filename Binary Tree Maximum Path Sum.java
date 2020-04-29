class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }

    private int findMaxPathSum(TreeNode root) {
         if(root == null) return 0;   
         int left =   Math.max(0, findMaxPathSum(root.left));
         int right =  Math.max(0, findMaxPathSum(root.right));        
         maxSum = Math.max(maxSum , left + right + root.val);
         return Math.max(left, right) + root.val;
    }
}

