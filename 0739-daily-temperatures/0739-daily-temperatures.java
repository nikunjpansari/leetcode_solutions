// Time Complexity : O(n)
// Space Complexity : O(n)
class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> st = new Stack<>();
        int n = t.length;

        int[] res = new int[n];

        for(int i = n-1 ;i >= 0; i--)
        {
            while(!st.isEmpty() && t[i] >= t[st.peek()])
            st.pop();

            if(!st.isEmpty())
            res[i] = st.peek() - i;

            st.push(i);
        }
        return res;
    }
}