class Solution {
     public int minFallingPathSum(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int ans = Integer.MAX_VALUE;
       for(int i = 0; i<c; i++)
          ans = Math.min(ans, rec(0, i, A));
        
        
        return ans;
    }
    private static int rec(int i, int j, int arr[][]){
        int r = arr.length;
        int c = arr[0].length;
        if( i == r){
            return 0;
        }
        if(j <0 || j >=c) return Integer.MAX_VALUE;
           
        
        int op1 =  rec(i+1, j-1, arr);
        int op2 =  rec(i+1, j,   arr);  
        int op3 =  rec(i+1, j+1, arr);
   
        return arr[i][j] + Math.min(op1, Math.min(op2, op3));
    }
}