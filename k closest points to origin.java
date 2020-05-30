class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(points==null){
            return null;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
           public int compare(int[] p1, int[] p2) {
               return (p2[0]*p2[0]+p2[1]*p2[1])-(p1[0]*p1[0]+p1[1]*p1[1]);
           } 
        });
       
        for(int i=0; i<points.length;i++) {
            pq.add(points[i]);
            if(pq.size()>K){
                pq.remove();
            }
        }
        
        int[][] result = new int[K][2];
        int i=0;
        while(!pq.isEmpty()){
            result[i] = pq.remove();
            i++;
        }
        return result;
    }
}