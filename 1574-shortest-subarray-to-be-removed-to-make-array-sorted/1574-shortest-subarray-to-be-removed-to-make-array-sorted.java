class Solution {
  public int findLengthOfShortestSubarray(int[] arr) {
    int n = arr.length;
    int l = 0;
    while (l < (n - 1) && arr[l] <= arr[l + 1]) {
      l++;
    }

    if (l == n - 1)
      return 0;
    
    int r = n - 1;
    while (r > 0 && arr[r] >= arr[r - 1]) {
      r--;
    }
    int result = Math.min(n - l - 1, r);
    int i = 0;
    while (i <= l && r < n) 
    {
      if (arr[r] >= arr[i]) 
      {
        result = Math.min(result, r - i - 1);
        i++;
      } 
      else 
        r++;
    }

    return result;
  }
}