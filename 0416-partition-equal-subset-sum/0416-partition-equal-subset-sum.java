class Solution {
   
    static boolean canPartition(int[] arr){
    
        int totSum=0;
        int n = arr.length;
    
    for(int i=0; i<n;i++){
        totSum+= arr[i];
    }
    
    if (totSum%2==1) return false;
    
    else{
        int k = totSum/2;
        boolean prev[]=new boolean[k+1];
    
        prev[0] = true;
        
        if(arr[0]<=k)
            prev[arr[0]] = true;
        
        for(int ind = 1; ind<n; ind++){
            boolean cur[]=new boolean[k+1];
            cur[0] = true;
            for(int target= 1; target<=k; target++){
                boolean notTaken = prev[target];
        
                boolean taken = false;
                    if(arr[ind]<=target)
                        taken = prev[target-arr[ind]];
            
                cur[target]= notTaken||taken;
            }
            prev = cur;
        }
        
        return prev[k];
    } 
}
}