// Time Complexity : O(N)
// Space Complexity : O(N)
class Solution {
    public int largestRectangleArea(int[] h) 
    {
        Stack<Integer> st = new Stack <> ();
        int maxA = 0;
        int n = h.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || h[st.peek()] >= h[i])) {
                int height = h[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }
}