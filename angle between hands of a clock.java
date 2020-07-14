class Solution {
    public double angleClock(int hour, int minutes) {
        double hh_angle = (hour*60+minutes)*0.5;
        double mh_angle = minutes*6;
        
        double angle=Math.abs(hh_angle - mh_angle);
        
        if(angle <= 180.0)
            return angle;
        else 
            return 360.0-angle;
        
    }
}