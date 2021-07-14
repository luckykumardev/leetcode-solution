class Solution {
    int count  = 0;
    public int islandPerimeter(int[][] grid) {
        count = 0;
        for(int i = 0 ;i<grid.length ;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                     count+=dfs(grid,i,j,count);
                     break;
                }
            }
        }
       return count; 
    }
    
    private int dfs(int[][]grid,int i,int j,int count){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0 ){
           count++;
          return count;
        }
        if(grid[i][j] == -1)return count;
        
        grid[i][j] = -1;
        
        dfs(grid,i+1,j,count);
        dfs(grid,i-1,j,count);
        dfs(grid,i,j+1,count);
        dfs(grid,i,j-1,count);
        return count;
    }
}
