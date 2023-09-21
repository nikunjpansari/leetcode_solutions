//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
       public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t > 0){
            String str = sc.nextLine();
            Solution ob = new Solution();
            if(ob.sentencePalindrome(str))
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    } 
} 
// } Driver Code Ends


class Solution { 

   static boolean sentencePalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    
    while (i <= j) {
        char leftChar = Character.toLowerCase(s.charAt(i));
        char rightChar = Character.toLowerCase(s.charAt(j));

        if (!Character.isLetterOrDigit(leftChar)) {
            i++;
        } else if (!Character.isLetterOrDigit(rightChar)) {
            j--;
        } else if (leftChar != rightChar) {
            return false;
        } else {
            i++;
            j--;
        }
    }
    return true;
}

}