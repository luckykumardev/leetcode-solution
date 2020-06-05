class Solution {
    int[] sum;
    Random random = new Random();
    int max = 0;
    public Solution(int[] w) {
        sum = new int[w.length];
        sum[0] =w[0];
        for (int i = 1; i < w.length; i++)
            sum[i] = sum[i - 1] + w[i];
           
        max = sum[sum.length-1];
    }
    public int pickIndex() {
        int low = 0, high = sum.length - 1;
        int target = 1 + random.nextInt(max);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sum[mid] == target) {
                return mid;
            }
            if (sum[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}