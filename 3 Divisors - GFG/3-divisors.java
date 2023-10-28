//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        ArrayList<Integer> arr=new ArrayList<Integer>();
        
        while(q!=0){
            long j=query.get(q-1);
            
            int m=0;
            for(int i=1;i<=j;i++){
                long c=i;
                long b=(long) Math.sqrt(i);
                
                if(b*b==c&& isprime(b)){
                    m++;
                    
                }
            }
            arr.add(m);
            q--;
            
        }
        Collections.reverse(arr);
        return arr;
    }
    public static boolean isprime(long a){
        if(a==0 || a==1){
            return false;
        }
        for(long i=2;i<=Math.sqrt(a);i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
}