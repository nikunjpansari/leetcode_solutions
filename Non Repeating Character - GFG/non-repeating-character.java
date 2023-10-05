//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends

class Solution
{
    static char nonrepeatingCharacter(String s)
    {
    int[] frequency = new int[256];
    Arrays.fill(frequency, 0);

    Queue<Character> queue = new LinkedList<>();

    for (int i = 0; i < s.length(); i++) {
        char currentChar = s.charAt(i);
        frequency[currentChar]++;
        queue.add(currentChar);

        while (!queue.isEmpty() && frequency[queue.peek()] > 1) {
            queue.poll();
        }
    }

    while (!queue.isEmpty()) {
        char firstNonRepeating = queue.poll();
        if (frequency[firstNonRepeating] == 1) 
            return firstNonRepeating;
    }

    return '$';
}

    }

