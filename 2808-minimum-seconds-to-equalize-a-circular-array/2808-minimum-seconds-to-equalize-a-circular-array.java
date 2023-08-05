class Solution {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap();
        HashMap<Integer, Integer> dist = new HashMap();
        int n = nums.size();
        
        for(int i = 0; i < 2 * n; i++) {
            int curr = nums.get(i % n);
            
            if(map.containsKey(curr) && map.get(curr) != i) 
            {
                int maxDist = i - map.get(curr);
                if(map.get(curr) > i) 
                maxDist = n + map.get(curr) - i;

                // found larger distance
                if(!dist.containsKey(curr) || maxDist > dist.get(curr))
                    dist.put(curr, maxDist);
            }
            map.put(curr, i);
        }
        
        
        int res = Integer.MAX_VALUE;
        for(int i : dist.keySet()) 
          
            res = Math.min(res, dist.get(i) / 2);
        
        return res;
    }
}