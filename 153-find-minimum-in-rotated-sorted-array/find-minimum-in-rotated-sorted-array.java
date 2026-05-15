class Solution {
    public int findMin(int[] arr) {
        int l = 0 ,h = arr.length-1;
        int ans = Integer.MAX_VALUE;
        while(l <= h)
        {
            int mid = (l+h)/2;

            if(arr[l] <= arr[h])
            {
                ans = Math.min(ans,arr[l]);
                break;
            }
            if(arr[l] <= arr[mid])
            {
                ans = Math.min(ans,arr[l]);
                l = mid + 1;
            }
            else
            {
                ans = Math.min(ans,arr[mid]);
                h = mid - 1;
            }
        }
        return ans;
    }
}