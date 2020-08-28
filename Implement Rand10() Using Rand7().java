class Solution extends SolBase {
    public int rand10() {
        while(true){
          int row = 7*(rand7()-1);
          int col = rand7();
          int curr = row + col;
            if(curr <=40){
                return 1 + (curr -1)%10;
            }
        }  
    }
}