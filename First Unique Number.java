class FirstUnique {
    
class Node {
	int value =0;
	Node prev = null;
	Node next = null;

	Node(int value) {
		this.value = value;
	}
}    
	 private HashMap<Integer, Integer> hm = new HashMap<>();
	 private Node head ;
	 private Node tail ;
	 
    
    public FirstUnique(int[] nums) {
        head = new Node(0);
		tail = new Node(0);
		head.next = tail;
		tail.prev = head;
        
        for(int i =0; i <nums.length; i++){
          if(hm.containsKey(nums[i])){
              hm.put(nums[i], hm.get(nums[i])+1);
          } else {
              hm.put(nums[i], 1);
          }
      }
        
        for(int i =0; i <nums.length; i++){
            if(hm.get(nums[i]) == 1)
                insert(new Node(nums[i]));
        }
                
    }
    public int showFirstUnique() {
        while(hm.containsKey(head.next.value) && hm.get(head.next.value) >1){
            remove(head.next);
        }
        if(hm.containsKey(head.next.value)){
            return head.next.value;
        } return -1;
    }
    
    public void add(int data) {
        if(hm.containsKey(data)){
            hm.put(data, hm.get(data) + 1);
        } else{
            hm.put(data, 1);
            insert(new Node(data));
        }
    }
    
	private void insert(Node node) {
	    tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    
	private void remove(Node node) {
		node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}