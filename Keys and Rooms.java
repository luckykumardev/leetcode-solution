class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[rooms.size()];
        
        visited[0] = true;
        for(int i : rooms.get(0)) {
            queue.add(i);
            visited[i] = true;
        }
        
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i : rooms.get(temp)) {
                if(visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        
        for (int i = 1; i < visited.length; i++) {
            if(visited[i] == false) return false;
        }
        
        return true;
    }
}