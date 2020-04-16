class solution{
    
   public static int countSteps(int n, int memo[]){
    if(n == 1){
      return 0;
    }


    if(memo[n] >0){
        return memo[n];
    }

    int op1 = countSteps(n-1, memo);
    int minSteps = op1;
    if(n%2 == 0){
        int op2 = countSteps(n/2, memo);
        if(op2 < minSteps){
            minSteps = op2;
        }
    }

    if(n%3 == 0){
        int op3 = countSteps(n/3, memo);
        if(op3 < minSteps){
            minSteps = op3;
        }
    }

     memo[n] = 1 +minSteps;
     
     return 1 + minSteps;
 
   } 

   public static int countSteps(int n){
      int dp[] = new int[n+1];
      dp[1] = 0;
    for(int i =2; i <=n; i++){
        int min = storage[i-1];
        if(i%3 == 0){
            if(min > dp[i/3])
              min = dp[i/3];
        }

        if(i%2 == 0){
            if(min > dp[i/2])
              min = dp[i/2];
        }
        
        dp[i] = 1 + min;
    }   
      return dp[n];
   }
  


  public static void main(String args[]){
    int n = 10;
    int memo[] = new int[n+1];
    int ans  = countSteps(n, memo);
    System.out.println(ans);
  }

}