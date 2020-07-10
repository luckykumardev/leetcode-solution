class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        
        int max = 1;
        while(!dq.isEmpty()) {
            while(!dq.isEmpty() && dq.getFirst() == null )    dq.removeFirst();
            while(!dq.isEmpty() && dq.getLast() == null )    dq.removeLast();
            max = Math.max(max, dq.size());
            int size = dq.size();
            for(int i =0; i <size; i++) {
                TreeNode temp = dq.poll();
                if(temp == null) {
                    dq.add(null);
                    dq.add(null);
                } else {
                    dq.add(temp.left);
                    dq.add(temp.right);
                }
                
            }
        }
        return max;
    }
}
