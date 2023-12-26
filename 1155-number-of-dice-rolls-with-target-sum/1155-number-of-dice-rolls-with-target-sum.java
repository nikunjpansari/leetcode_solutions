class Solution {
	final Map<String, Integer> mp = new HashMap<>();
	final int MOD = 1000000007;

	public int numRollsToTarget(int d, int f, int target) 
    { 
		if (target > d * f || target < d) 
        return 0;
		
        if (d == 1) 
        return (target <= f) ? 1 : 0;

		final String key = "" + d + f + target;

		if (! mp.containsKey(key)) 
        {   
			int currentSum = 0;

			for (int i = f; i > 0; i--) 
            {
				currentSum += numRollsToTarget(d - 1, f, target - i);
				currentSum %= MOD;
			} 
			mp.put(key, currentSum);
		} 
		return mp.get(key);
	} 
}