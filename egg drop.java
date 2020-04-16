
public static int eggdrop(int eggs, int floors){
      int dp[][] = new int [eggs+1][floors+1];

      for(int e =1; e<=eggs; e++){
        for(int f =1; f<=floors; f++){
              if(f == 1){
                dp[e][f] =1;
              
              }else if(e ==1){
                  dp[e][f] = f; 
              } else{

               int ans = Integer.MAX_VALUE;
               for(int i =1; i <=f; i++){
                    int egg_break   = dp[e-1][i-1];
                    int egg_survive = dp[e][f-i];
                   
                   //best of worst     oor min of max
                 ans = Math.min(ans, Math.max(egg_break, egg_survive));
               }
               
               dp[e][f] = ans +1;

              }

        }
      }
       return dp[eggs][floors];
}
