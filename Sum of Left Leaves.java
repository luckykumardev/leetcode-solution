class Solution {
    int leftLeafSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return leftLeafSum;
    }
    private void helper(TreeNode root){
        if(root ==null) return;
        if(isLeafNode(root.left)) leftLeafSum += root.left.val;
        helper(root.left);
        helper(root.right);
    }
    
    private boolean isLeafNode(TreeNode root){
        if(root == null) return false;
        if(root.left == null && root.right == null)
            return true;
        
        return false;
    }
}