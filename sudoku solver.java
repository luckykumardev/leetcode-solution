import java.lang.*;
import java.io.*;
class GFG
 {
    
    public static boolean isSafe(int arr[][], int row, int col, int k){
        //row check
        for(int i =0; i<9; i++)
            if(arr[row][i] == k) return false;
        
        //col check
        for(int i =0; i<9; i++)
            if(arr[i][col] == k) return false;
        
         int boxRowStart = row - row % 3; 
         int boxColStart = col - col % 3; 
  
         for (int r = boxRowStart; r < boxRowStart + 3; r++)  
         { 
             for (int d = boxColStart; d < boxColStart + 3; d++)  
                { 
                 if (arr[r][d] == k)  
                   return false;
                } 
         }
         
         return true;
    }
    
    public static boolean fun(int arr[][]){
      int row = -1;
      int col = -1;
      boolean isEmpty  = true;
      for(int i =0; i <9; i++){
        for(int j =0; j<9; j++){
          if(arr[i][j] == 0){
            isEmpty = false;    
            row = i; col = j;
              break;
          } 
        }
        if(!isEmpty) break;
      }
      
      if(isEmpty) return true; 
    
      
      for(int k = 1; k<=9; k++){
          if(isSafe(arr, row, col, k)){
              arr[row][col] = k;
            if(fun(arr)){
               return true;
            } 
           else    arr[row][col] = 0;  
          }
      }
      
      return false;
    } 
     
	public static void main (String[] args)
	 {
	 //code
	  Scanner sc = new Scanner(System.in);
	  int t = sc.nextInt();
	  while(t-- > 0){
	     
	   int arr[][] = new int[9][9];
	   for(int i = 0; i <9; i++){
	     for(int j = 0; j<9; j++){
	      arr[i][j] = sc.nextInt();
	     }     
	   } 
	        fun(arr); 
	        print(arr);
	        System.out.println();
	  }
	 }
	 
	public static void print(int[][] board){  
       for (int r = 0; r < 9; r++){
        for (int d = 0; d < 9; d++)
            System.out.print(board[r][d] + " "); 
     }
    }  

}