class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    
       TreeNode root = helper(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
       return root;
    }

    public  TreeNode helper(int ino[], int pre[], int sti, int endi, int stp, int endp){
           if(sti >endi) return null;
           TreeNode  root = new TreeNode(pre[stp]);
           int x  = -1;
           for(int i =sti; i <=endi; i++){
               if(root.val == ino[i]){
                   x = i;
                   break;
               }
           }
           if(x == -1) return null;
         int leftIns  = sti;
         int leftIne  = x-1;
         int leftprs  = stp +1;
         int leftpre  = leftIne - leftIns + leftprs;
         int rightIns = x+1;
         int rightIne = endi;
         int rightprs = leftpre +1;
         int rightpre = endp;
         root.left = helper( ino, pre, leftIns,  leftIne,  leftprs, leftpre);
         root.right = helper( ino, pre, rightIns,  rightIne,  rightprs, rightpre);          

         return root;
    }    
}