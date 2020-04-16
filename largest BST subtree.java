

class Solution{

  public int largestBst(Node root){
       if(root == null) return 0;

       if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
         return size(root);

         return Math.max(largestBst(root.left), largestBst(root.right));
    }

    public int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public boolean isBST(Node root, int min, int max){
        if(root == null) return true;
        if(root.data < min || root.data  > max) return false;

        return isBST(root.left, min, root.data-1) && isBST(root.right, root.data+1, max);
    }    
}

