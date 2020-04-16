class Solution {    
    void helper1(TreeNode root, Stack<Integer> s){
        if(root == null) return;
        helper1(root.left, s);
          s.push(root.val);
        helper1(root.right, s);  
    }
    void helper2(TreeNode root, Stack<Integer> s){
        if(root == null) return;
        helper2(root.left, s);
          root.val = s.pop();
        helper2(root.right, s);  
    }
    public TreeNode convertBST(TreeNode root) {
        
     Stack<Integer> s = new Stack<Integer>();
	  helper1(root, s);
	 Stack<Integer> s1 = new Stack<Integer>();
	  while(!s.isEmpty()){
	      if(s1.isEmpty()){
	          s1.push(s.pop());
	      }else {
	          s1.push(s1.peek() + s.pop());
	      }
	  }
	  helper2(root, s1);
        return root;       
    }
}