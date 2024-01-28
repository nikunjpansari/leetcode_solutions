class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer,Integer> nm=new HashMap<>();
        for(int i:nums)
        {
            nm.put(i, nm.getOrDefault(i,0)+1);
        }
        Arrays.sort(nums);
        int maxi= nm.containsKey(1) ? nm.get(1)%2 == 0 ? nm.get(1)-1 : 
        nm.get(1) : 1;
        for(int i=0;i<nums.length;i++)
        {
            int count=0;
            int val=nums[i];
            while(nm.containsKey(val) && nm.get(val)>=2 && val!=1)
            {
                count+=2;
                val*=val;
            }
            if(nm.containsKey(val))
                count++;
            else
                count--;
            maxi=Math.max(count,maxi);
        }
        return maxi;
    }
}