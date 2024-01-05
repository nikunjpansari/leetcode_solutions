class Solution 
{
    public int lengthOfLIS(int[] arr) 
    {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);

        int l = 1;

        for (int i = 1; i < n; i++) 
        {
            if (arr[i] > ans.get(ans.size() - 1)) 
            {
                ans.add(arr[i]);
                l++;
            } 
            else 
            {
                int indx = binarySearch(ans, arr[i]);
                ans.set(indx, arr[i]);
            }
        }
        return l;
    }
    
    static int binarySearch(ArrayList<Integer> ans, int key) 
    {
        int l = 0;
        int h = ans.size() - 1;
        while (l <= h) 
        {
            int mid = l + (h - l) / 2;
            if (ans.get(mid) == key) 
            return mid;
            else if (ans.get(mid) < key) 
                l = mid + 1;
            else 
                h = mid - 1;
        }
        return h + 1;
    }
}