class LUCKY
{
    Node constructTree(int n, int pre[], char preLN[])
    {
	    //Add your code here.
	    if(n == 0) return null;
	    java.util.Stack<Node> s = new java.util.Stack<Node>();
	    Node root = new Node(pre[0]);
	    s.push(root);
	    for(int i =1; i <n; i++){
	       
	       Node p = new Node(pre[i]);
	       if(s.peek().left == null){
	          s.peek().left  = p;
	       } else if(s.peek().right == null){
	          s.peek().right = p;
	          s.pop();
	       }
	       if(preLN[i] == 'N') s.push(p);
	    }
	    
	    return root;
    }
}