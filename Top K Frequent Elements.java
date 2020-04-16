class Solution {
   public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n : nums){
            if(hm.containsKey(n)){
                hm.put(n, hm.get(n)+1);
            }
            else{
                hm.put(n, 1);
            }
        }
        Comparator<Pair> comparator = new Comparator<Pair>(){
            public int compare(Pair n1, Pair n2){
                if(n1.times < n2.times) return 1;
                else return -1;
            }
        };
        PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);
        for(Integer x : hm.keySet()){
            pq.add(new Pair(x, hm.get(x)));
        }
        int x = 0;
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty() && x++ < k){
            result.add(pq.poll().current);
        }
        return result;
    }
    
    class Pair{
        int current;
        int times;
        
        public Pair(int current, int times){
            this.current = current;
            this.times = times;
        }
    }
}