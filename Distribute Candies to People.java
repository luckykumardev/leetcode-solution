class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int ans[]  = new int[num_people];
        int candy  = 1;
        int i      = 0;
        while(candy <= candies){
            if(i == num_people) i = 0;
            ans[i] += candy;
            candies -= candy;
            candy += 1;
            i++;
        }
      
        if(candies >0){
            if(i == num_people) i = 0;
             ans[i] += candies;
        }
        
        return ans;
    }
}