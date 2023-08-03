//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    public static String convert(List<Character> l){
        
       char[] cArray =  new char[l.size()];
       for(int i = 0;i<l.size();i++){
          cArray[i] = l.get(i);

       }
       String s = new String(cArray);
       return s;


    }
    
    public static void solve(int idx1,String[] arr ,List<String> ans,List<Character> ds){

            if(idx1==arr.length){
                ans.add(convert(new ArrayList<>(ds)));
                return ;

            }
            int len = arr[idx1].length();
            for(int i= 0;i<len;i++){
                ds.add(arr[idx1].charAt(i));
                solve(idx1+1,arr, ans, ds);
                ds.remove(ds.size()-1);
            }

 

    }
    
    public static ArrayList<String>  possibleWords2(int[] inputArr,int n,String[] pad){
        
        String[] arr = new String[n];
        int x = 0;
        for(int i :inputArr){
            arr[x++] = pad[i];
            
        }
        
        ArrayList<String> ans = new ArrayList<String>();
        List<Character> ds = new ArrayList<Character>();

        solve(0,arr,ans,ds); 
        return ans;

    }
    
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
      String[] dialPad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
     return possibleWords2(a,N,dialPad);
        
    }
}


