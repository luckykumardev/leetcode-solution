class Solution {
   public boolean isCousins(TreeNode root, int A, int B) {
    if (root == null) return false;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		boolean isAexist = false;		
		boolean isBexist = false;		
		for (int i = 0; i < size; i++) {
			TreeNode cur = queue.poll();
            if (cur.val == A) isAexist = true;
            if (cur.val == B) isBexist = true;
			if (cur.left != null && cur.right != null) { 
				if (cur.left.val == A && cur.right.val == B) { 
					return false;
				}
				if (cur.left.val == B && cur.right.val == A) { 
					return false;
				}
			}
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
		if (isAexist && isBexist)  return true;
	}
	return false;
}
}