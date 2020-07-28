class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq= new int[26];
		for(int i = 0; i <tasks.length; i++){
		    char c = tasks[i];
            freq[c-'A']++;
        }
        
		Arrays.sort(freq);	
        int mostFreq= freq[25] -1;	
		int idleTime = mostFreq*n;
        
		for(int i=24; i>=0; i--){
            idleTime -= Math.min(mostFreq, freq[i]);	
            if(idleTime < 0 ) return tasks.length;
        }
        
        return idleTime + tasks.length;  
    }
}