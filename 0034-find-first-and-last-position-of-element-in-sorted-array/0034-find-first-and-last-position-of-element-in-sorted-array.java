class Solution {
    public int[] searchRange(int[] arr, int x) {
        int[] res = new int[2];
        res[0] = solve(arr,x,true);
        res[1] = solve(arr,x,false);
        return res;
    } 
    public int solve(int arr[],int x,boolean indx)
    {
        int ans = -1;
        int l = 0;
        int r = arr.length - 1;
        
        while(l <= r)
        {
            int mid = l + (r-l)/2;
            if(x < arr[mid])
                r = mid - 1;
            else if(x > arr[mid])
                l = mid + 1;
            else
            {
                ans = mid ;
                if(indx)
                    r = mid - 1;
                else
                    l = mid +1;
            }
        }
        return ans;
    }
}