class Solution {
     Map<String, Integer> dp = new HashMap<>();
    private int solve(List<List<Integer>> offers, int currBuyer){
        
        if(currBuyer >= offers.size()){
            return 0;
        }
        String key = currBuyer+"";
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        
        int ans = solve(offers, currBuyer+1);
        
        int nextAvailableHouse = offers.get(currBuyer).get(1)+1;
        int low = currBuyer+1, high = offers.size()-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(offers.get(mid).get(0) >= nextAvailableHouse) {
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        
        ans = Math.max(ans, offers.get(currBuyer).get(2) + solve(offers, low));
        dp.put(key, ans);
        return ans;
    }
    
    public int maximizeTheProfit(int n, List<List<Integer>> offers)     {
        Collections.sort(offers, (a,b)->{
            if(a.get(0)==b.get(0)){
                return a.get(1)-b.get(1);
            }
            return a.get(0)-b.get(0);
        });
        return solve(offers, 0);
    }
    }