class solution {
    public String alienOrder(String[] words){
        boolean adj[] = new boolean[26][26];
        int visited[] = new int[26];
        buildGraph(words, adj, visited);
         
        StringBuilder sb = StringBuilder();
        for(int i =0; i <26; i++){
            if(visited[i] == 0){
                if(dfs(adj, visited, db, i) == false)
                  return "";
            }
        }

        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i){
        visited[i] = 1; //visited
        for(int j =0; j< 26; j++){
            if(adj[i][j] == true) {
                if(visited[j] == 1){
                    return false;
                }
                if(visited[j] == 0){
                   if(!dfs(adj, visited, db, j))
                    return false;
                }
            }
        }
        visited[i] = 2;
        sb.append((char) (i + 'a'));
        return true;
    } 

    public void buildGraph(String words[], boolean adj[][], int visited[]){
         for(int i =0; i <visited.length; i++)
         visited[i] = -1; //not exist yet

         for(int i =0; i <words.length; i++){
             for(char c : words[i].toCharArray()){
                 visited[c - 'a'] = 0; //letter exist
             }
             if(i>0){
                 String w1 = words[i -1];
                 String w2 = words[i];
                 int len = Math.min(w1.length(), w2.length());
                 for(int j =0; j <len; j++){
                     char c1 = w1.charAt(j);
                     char c2 = w2.charAt(j);
                     if(c1 != c2)
                     adj[c1-'a'][c2-'a'] = true;
                     break;
                 }
             }
         }
    }


}