//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node head)
    {
       Node start = head ; 
        Node temp = head.next ; 
        Node curr = temp ; 
        while(start.next!=null && curr.next!=null){
            start.next = curr.next ;
            start = curr.next ; 
            curr.next = curr.next.next ; 
            curr = start.next ; 
        }
        start.next = reverse(temp) ; 
    } 
    public static Node reverse(Node head)
    {
       Node p1 = null ,p2 = null;
       while(head != null){
           p2 = head.next;
           head.next = p1;
           p1 = head;
           head = p2;
       }
       return p1;
    }
}
