
class Solution {  
  
  ////////////////
 ///recursion ///
////////////////
  public int numTrees(int n) {      
        return numTrees(1, n);
    }
    
    private int numTrees(int start, int end) {
        
        if (start >= end) {
            return 1;
        }        
        int countUnique = 0;        
        for (int i = start; i <= end; i++) { // take i as root
            countUnique += numTrees(start, i - 1) * numTrees(i + 1, end);
        }        
        return countUnique;
    }




  ////////////////
 ///memoization//
////////////////
public int numTrees(int n) {
        
        int[][] memo = new int[n + 1][n + 1];
        return numTrees(1, n, memo);
    }
    
    private int numTrees(int start, int end, int[][] memo) {
        
        if (start >= end) {
            return 1;
        }        
        if (memo[start][end] > 0) {
            return memo[start][end];
        }        
        int countUnique = 0;        
        for (int i = start; i <= end; i++) { // take i as root
            countUnique += numTrees(start, i - 1, memo) * numTrees(i + 1, end, memo);
        }        
        memo[start][end] = countUnique;
        
        return countUnique;
    }




  ////////////////
 ///tabulation///
////////////////
  public int numTrees(int n) {
    int[] U_BST = new int[n+1];
    U_BST[0] = 1;
    U_BST[1] = 1;
    for(int i=2;i<=n;i++){
        for(int j=1;j<=i;j++)
            U_BST[i] += U_BST[j-1] * U_BST[i-j];
    }
    return U_BST[n];
  }
}