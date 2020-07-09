class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int max = 1;
        while(!queue.isEmpty()) {
            while(!queue.isEmpty() && queue.getFirst() == null )    queue.removeFirst();
            while(!queue.isEmpty() && queue.getLast() == null )    queue.removeLast();
            max = Math.max(max, queue.size());
            int size = queue.size();
            for(int i =0; i <size; i++) {
                TreeNode temp = queue.poll();
                if(temp == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
                
            }
        }
        return max;
    }
}