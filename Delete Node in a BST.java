class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(list, root, key);	        
	    return buildTree(list, 0, list.size() - 1, null);
    }   

    public static void helper(ArrayList<Integer> list, TreeNode root, int key){
        if(root == null) return;
        helper(list, root.left, key);
        if(root.val  != key) list.add(root.val);
        helper(list, root.right, key);
    }

    TreeNode buildTree(ArrayList<Integer> list, int start, int end, TreeNode node)  
    {   
        if (start > end) 
            return null; 
         
        int mid=(start+((end-start)/2)); 
        node = new TreeNode(list.get(mid)); 
    
        if (start == end) 
            return node; 
        
        node.left = buildTree(list, start, mid - 1, node.left); 
        node.right = buildTree(list, mid + 1, end, node.right); 
        return node; 
    }     
}