public class Solution extends VersionControl {
       public int firstBadVersion(int n) {
        int left = 1, right = n;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // to avoid overflow
            if (isBadVersion(mid)) {
                ans = mid; // record mid as current answer
                right = mid - 1; // try to find in the left side
            } else {
                left = mid + 1; // try to find in the right side
            }
        }
        return ans;
    }
}