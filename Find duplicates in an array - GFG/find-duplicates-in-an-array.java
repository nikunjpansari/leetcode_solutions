//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends
class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
       HashSet<Integer> list = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for(int element:arr){
            if(!set.add(element)){
                list.add(element);
            }
        }
        ArrayList<Integer> items = new ArrayList<>(list);
        Collections.sort(items);
        if(items.isEmpty()){
            items.add(-1);
        }
        return items;
    }
}
