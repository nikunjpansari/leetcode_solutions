class Solution {
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->(a[0]-b[0]));
        int max[]=new int[n];
        max[n-1]=events[n-1][2];
        for(int i=n-2;i>=0;i--)
            max[i]=Math.max(max[i+1],events[i][2]);
        
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int find=events[i][1]+1;
            int pos=binary(find,events);
            if(pos==-1)
                ans=Math.max(ans,events[i][2]);
            else
                ans=Math.max(ans,events[i][2]+max[pos]);
        }
        return ans;
    }
    
    int binary(int num, int e[][])
    {
        int start=0;
        int end=e.length-1;
        int ans=-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(num<=e[mid][0])
            {
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;
    }
}