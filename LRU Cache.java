public class LRUCache {
class Node {
	int key;
	int value;
	Node prev;
	Node next;

	Node(int k, int v) {
		key = k;
		value = v;
	}
}	
	private Map<Integer, Node> map = new HashMap<>();
	private Node head;
	private Node last;
	private int capacity;

	public LRUCache(final int capacity) {
		this.capacity = capacity;
		head = new Node(0, 0);
		last = new Node(0, 0);
		head.next = last;
		last.prev = head;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}
		remove(node);
		insert(node);
		return node.value;
	}

    public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		if (map.size() == capacity) {
			remove(last.prev);
		}
		insert(new Node(key, value));
	}
    
	private void insert(Node node) {
		map.put(node.key, node);
		node.next = head.next;
		head.next.prev = node;
		node.prev = head;
		head.next = node;
	}	

	private void remove(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

}
