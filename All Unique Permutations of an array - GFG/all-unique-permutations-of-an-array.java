//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void permutation(ArrayList<Integer> arr, int l, int r, Set<ArrayList<Integer>> a){

       if(l == r){

           a.add(new ArrayList<Integer>(arr));

           return ;

       }

       for(int i=l;i<=r;i++){

           arr = interchangeInt(arr, l, i);

           permutation(arr, l+1, r, a);

           arr = interchangeInt(arr, l, i);

       }

   }

   

   static ArrayList<Integer> interchangeInt(ArrayList<Integer> arr, int a, int b){

       int temp = arr.get(a);

       int l = arr.get(b);

       arr.set(a, l);

       arr.set(b, temp);

       return arr;

   }

   

   static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {

       // code here

       Set<ArrayList<Integer>> set = new HashSet<>();

       permutation(arr, 0, n-1, set);

       ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>(set);

       Collections.sort(A, new Comparator<ArrayList<Integer>>(){

           @Override

           public int compare(ArrayList<Integer> a, ArrayList<Integer> b){

               int comp = 0;

               for(int i=0;i<Math.min(a.size(), b.size());i++){

                   comp = Integer.compare(a.get(i), b.get(i));

                   if(comp != 0)

                       return comp;

               }

               return Integer.compare(a.size(), b.size());

           }

       });

       return A;

   }
};