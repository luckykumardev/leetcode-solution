class Solution {
    private int kadanes(int[] a){
        int n = a.length;
        int sum = a[0], answer = a[0];
        for(int i=1; i<a.length; i++){
            sum += a[i];
            if(sum < a[i]) sum = a[i];
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    public int maxSubarraySumCircular(int[] A) {
        if(A.length == 0) return 0;
        int x = kadanes(A);
        int y = 0;
        for(int i=0; i<A.length;i++){
            y += A[i];
            A[i] *= -1;
        }
        int z = kadanes(A);
        if(y+z == 0) return x;
        return  Math.max(x, y+z);
    }
}