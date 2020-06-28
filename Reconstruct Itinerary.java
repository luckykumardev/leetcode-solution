class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
        for(int i =0; i <tickets.size(); i++){
            String key   = tickets.get(i).get(0);
            String value = tickets.get(i).get(1);
            if(!hm.containsKey(key)){
                PriorityQueue<String> temp = new PriorityQueue<>();
                hm.put(key, temp);
            }
            hm.get(key).add(value);
        }
        
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", hm, res);
        return res;
    }

    public void dfs(String dep, Map<String, PriorityQueue<String>> hm, LinkedList<String> res) {
        PriorityQueue<String> arrivals = hm.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), hm, res);
        }

        res.addFirst(dep);
    }
}