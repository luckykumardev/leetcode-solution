class TopologicalSort {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        // add your code here
        
        
        int ans[] = new int[N];
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[N];
        for(int i =0; i <N; i++)
          if(visited[i] == false){
           visited[i] = true;
           topo(i, visited, adj, ans, s);
          }
         int k =0;
         while(!s.isEmpty())
          ans[k++] = s.pop();
        return ans;
    }
    
    private static void topo(int i, boolean  visited[], ArrayList<ArrayList<Integer>> adj, int ans[], Stack<Integer> s){
        for(int x : adj.get(i)){
            if(visited[x] == false){
                visited[x] = true;
                topo(x, visited, adj, ans, s);
            }
        }
        s.push(i);
    }
}