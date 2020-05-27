class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
       
        int[] color = new int[N+1];
        List<Integer>[] graph = new List[N+1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] v: dislikes) {
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }
        
        for(int i = 1; i <= N; i++) {
            if(color[i] == 0) {
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;
                while(queue.size() != 0) {
                    int top = queue.removeFirst();
                    for(int neighbor: graph[top]) {
                        if(color[neighbor] == color[top]) return false;
                        if(color[neighbor] == 0) {
                            color[neighbor] = -color[top];
                             queue.add(neighbor);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}