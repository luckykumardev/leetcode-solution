class Solution {
    public Node flatten(Node head) {
        Node cur = head;
        Node tail = head;
        Stack<Node> stack = new Stack<>();
        while(cur != null) {
            if(cur.child != null) {
                Node child = cur.child;
                if(cur.next != null){ 
                    stack.push(cur.next);
                    cur.next.prev = null; 
                }
                cur.next = child;
                child.prev = cur;
                cur.child = null;
            }
            tail = cur;
            cur = cur.next;
        }
        while(!stack.isEmpty()) {
            cur = stack.pop();
            tail.next = cur;
            cur.prev = tail;
            while(cur != null) {
                tail = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}