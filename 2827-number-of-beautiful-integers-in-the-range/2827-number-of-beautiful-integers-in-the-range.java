// Time Complexity : O(N)
// Space Complexity : O(N)
class Solution {
    private int solve(int currIndex, boolean tight, int evenDigitCount, int oddDigitCount, int rem, String s, Integer dp[][][][][], int k, boolean allZero){
        
        if(currIndex == s.length()){
            return (evenDigitCount == oddDigitCount && rem == 0)?1:0;
        }
        
        if(dp[currIndex][tight ? 1 : 0][evenDigitCount][oddDigitCount][rem] != null){
          return dp[currIndex][tight ? 1 : 0][evenDigitCount][oddDigitCount][rem];  
        } 
        
        
        int end = tight?(s.charAt(currIndex)-'0'):9;
        int count = 0;
        for(int currDigit = 0; currDigit <= end; currDigit++){
            int newRem = (rem*10 + currDigit)%k;
            boolean newTight = tight && (currDigit == end);
            boolean newAllZero = allZero && (currDigit==0);
            if(currDigit%2 == 0){
                count += solve(currIndex+1, newTight, newAllZero ? evenDigitCount : evenDigitCount+1, oddDigitCount, newRem, s, dp, k,newAllZero);
            }
            else{
                count += solve(currIndex+1, newTight, evenDigitCount, oddDigitCount+1, newRem, s, dp, k,newAllZero);
            }
        }
        
        
        return dp[currIndex][tight ? 1 : 0][evenDigitCount][oddDigitCount][rem] = count;
    }
    
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        String lowString = Integer.toString(low-1);
        Integer dp1[][][][][] = new Integer[lowString.length()][2][11][11][21];
        
        String highString = Integer.toString(high);
        Integer dp2[][][][][] = new Integer[highString.length()][2][11][11][21];
        
        return solve(0, true, 0, 0, 0,highString , dp2, k, true)-solve(0, true, 0, 0, 0, lowString, dp1, k, true);
    }
}