class Solution {
    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] first = new int[intervals.length];
        for( int i = 0 ; i < intervals.length; i++)
        {
            hm.put(intervals[i][0],i);
            first[i] = intervals[i][0];
        }
        Arrays.sort(first);
        int[] ans = new int[intervals.length];
        for( int i  = 0 ; i< intervals.length;i++)
        {
            int key = binarysearch(first,intervals[i][1]);
            if(key==first.length)
                ans[i]=-1;
            else if(key==0)
            {
                if(intervals[i][1] <= first[0])
                    ans[i]=hm.get(first[0]);
                else
                    ans[i]=-1;
            }
            else
                ans[i] = hm.get(first[key]);
        }
        return ans;
    }
    public int binarysearch(int[] arr ,int target)
    {
        int s  =0 ;
        int e = arr.length-1;
        while(s <e)
        {
            int mid = s +(e-s)/2 ;
            if(arr[mid]<target)
                s=mid+1;
            else
                e=mid;
        }
        return s;
    }
}