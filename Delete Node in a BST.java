class Solution {
       public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            if(root.left != null && root.right != null){
                int v = findmax(root.left, Integer.MIN_VALUE);
                root.val = v;
                root.left = deleteNode(root.left, v);
                return root;
            }else if(root.left != null){
                return root.left;
            }else if(root.right != null){
                return root.right;
            }else{
                return null;
            }
            
        }
        return root;
    }
    
    
    private static int findmax(TreeNode root, int max){
       while(root !=null){
           max = Math.max(max, root.val);
           root = root.right;
       }
        return max;
    }
}