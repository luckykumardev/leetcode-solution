
class Solution {
    //recursive
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left  = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

     //iterative
   public TreeNode invertTree2(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node != null) {
            queue.add(node.left);
            queue.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }
    return root;
   }
   
}
 