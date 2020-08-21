class Solution {
    public int[] sortArrayByParity(int[] A) {
        int s = 0;
        int e = 0;
        while(e < A.length){
            if(A[e]%2 == 0){
                swap(A, s, e);
                s++;e++;
            }else{
                e++;
            }
        }
        return A;
    }
    
    private static void swap(int arr[], int i, int j){
        int temp   = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }
}