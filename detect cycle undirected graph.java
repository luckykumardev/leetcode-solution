class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean visited[] = new boolean[V];
        boolean helper[]  = new boolean[V];       
        for(int i =0; i <V; i++){
            if(visited[i] == false){
              boolean ans = DFS(adj, i, visited, helper);
              if(ans == true) return true;
            }
        }
        return false;
    }    
    private static boolean DFS(ArrayList<ArrayList<Integer>> adj, int i, boolean visited[], boolean helper[]){
        visited[i] = true;        
        helper[i] = true;
        ArrayList<Integer> neighbours = adj.get(i);
        for(int k =0; k <neighbours.size(); k++){
            int curr = neighbours.get(k);
            if(helper[curr] == true) return true;
            if(visited[curr] == false){
                boolean ans = DFS(adj, curr, visited, helper);
                if(ans == true)  return true;
            }   
        }   
        helper[i] = false;
        return false;
    }
}