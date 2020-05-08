class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double slope = calculate(coordinates[0], coordinates[1]);
        for(int index = 2; index < coordinates.length; index++) {
            if(slope != calculate(coordinates[0], coordinates[index])) {
                return false;
            }
        }
        return true;
    }
    
    private double calculate(int []p1, int []p2) {
        return ((p1[1] - p2[1]) * 1.0) / ((p1[0] - p2[0]) * 1.0);
    }
}