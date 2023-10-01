//{ Driver Code Starts
import java.util.*;
class Node{
    int data;
    Node next;
    
    Node(int a){
        data = a;
        next = null;
    }
    
}

class LinkedList{
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int x=sc.nextInt();
            Node head=null;
            for(int i=0;i<n;i++)
            {int a=sc.nextInt();
            if(head==null){
                head=new Node(a);
            }
            else
                insert(head,a);
            }
        
            Solve y = new Solve();
            System.out.println(y.countTriplets(head,x));
        }
    }
    public static Node insert(Node head,int a){
        if(head==null){
            return new Node(a);
        }
        head.next=insert(head.next,a);
        return head;
    }
    
}


// } Driver Code Ends


//User function Template for Java

class Solve
{
    static int countTriplets(Node head, int x) 
    { 
      ArrayList<Integer> list = new ArrayList<>();
        
        Node temp = head;
        while(temp != null){
            
            list.add(temp.data);
            temp = temp.next;
            
        }
        Collections.sort(list);
        
        int c = 0;
        for(int i = 0; i < list.size()-2; i++){
            
            int j = i+1;
            int k = list.size()-1;
            while(j < k){
                
                if(list.get(i)+list.get(j)+list.get(k)==x){
                    c++;
                    j++;
                    k--;
                }
                else if(list.get(i)+list.get(j)+list.get(k)<x){
                    
                    j++;
                }else {
                    k--;
                }
                
            }
            
        }
        return c;
    } 
}