//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
       int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0 || st.isEmpty()) 
                st.push(asteroids[i]);
            else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) 
                    st.pop();
                
                if (!st.isEmpty() && st.peek() == Math.abs(asteroids[i]))
                    st.pop();
                else {
                    if (st.isEmpty() || st.peek() < 0) 
                        st.push(asteroids[i]);
                
            }
        }
        }
        int[] res = new int[st.size()];
        for (int k = st.size() - 1; k >= 0; k--) 
        {
            res[k] = st.peek();
            st.pop();
        }
    return res;
    }
}
