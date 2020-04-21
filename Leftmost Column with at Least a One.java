/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int rows = list.get(0);
        int cols = list.get(1);
        int candidate = -1;
        for (int r = 0, c = cols - 1; r < rows && c >= 0; ) {
            if (binaryMatrix.get(r, c) == 1) {
                candidate = c;
                c--;
            } else {
                r++;
            }
        }
        return candidate;
        
    }
}