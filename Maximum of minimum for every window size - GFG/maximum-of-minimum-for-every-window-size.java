//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
// } Driver Code Ends

class Solution 
{
    static int[] maxOfMin(int[] arr, int n) 
    {
       int[] leftBoundaries = new int[n];
        int[] rightBoundaries = new int[n];
        Arrays.fill(leftBoundaries, -1);
        Arrays.fill(rightBoundaries, n);

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < n; i++) 
        {
            while ((!stack.isEmpty()) && arr[stack.peek()] >= arr[i])
                stack.pop();

            if (stack.isEmpty()) 
                stack.push(i);
            else 
            {
                leftBoundaries[i] = stack.peek();
                stack.push(i);
            }
        }


        stack.clear();

        for (int i = n - 1; i >= 0; i--) 
        {
            while ((!stack.isEmpty()) && arr[stack.peek()] >= arr[i])
                stack.pop();

            if (stack.isEmpty()) 
                stack.push(i);
            else {
                rightBoundaries[i] = stack.peek();
                stack.push(i);
            }
        }

      int[] minIndexWithinWindow = new int[n];
        Arrays.fill(minIndexWithinWindow, 0);
        for (int i = 0; i < n; i++) 
        {
            minIndexWithinWindow[i] = (leftBoundaries[i] == -1) ? rightBoundaries[i] : rightBoundaries[i] - leftBoundaries[i] - 1;
        }

        int[] maxOfMins = new int[n];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) 
        {
            min = Math.min(min, arr[i]);
        }

        for (int i = 0; i < n; i++) 
        {
            int currentElement = arr[i];
            maxOfMins[minIndexWithinWindow[i] - 1] = Math.max(maxOfMins[minIndexWithinWindow[i] - 1], currentElement);
        }

        maxOfMins[n - 1] = min;

        for (int i = n - 2; i >= 0; i--) 
        {
            maxOfMins[i] = Math.max(maxOfMins[i], maxOfMins[i + 1]);
        }

        return maxOfMins;
    }
}