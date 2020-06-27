class Solution {
    public Node cloneGraph(Node node) {
         if(node == null) return null;
          Map<Node, Node> map = new HashMap<>();
          Queue<Node> queue = new ArrayDeque<>();
 
    queue.add(node);
    map.put(node, new Node(node.val, new ArrayList<>()));
    while (!queue.isEmpty()) {
        Node h = queue.poll();
 
        for (Node neighbor : h.neighbors) {
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                queue.add(neighbor);
            }
            map.get(h).neighbors.add(map.get(neighbor));
        }
    }
 
    return map.get(node);
    }
}`