class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (count == k - 1) {
            return root.val;
        }
        if (count > k - 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - count - 1);
        }
    }
    int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}