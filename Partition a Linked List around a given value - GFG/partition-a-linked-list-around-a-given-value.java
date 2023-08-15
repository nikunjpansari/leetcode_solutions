//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
  public static Node partition(Node node, int x) {
    Node small = new Node(0);
    Node equal = new Node(0);
    Node greater = new Node(0);

    Node smallHead = small, equalHead = equal, greaterHead = greater;

    while (node != null) {
        if (node.data < x) {
            // small list
            smallHead.next = node;
            smallHead = smallHead.next;
        } else if (node.data == x) {
            // equal list
            equalHead.next = node;
            equalHead = equalHead.next;
        } else {
            // greater list
            greaterHead.next = node;
            greaterHead = greaterHead.next;
        }
        node = node.next;
    }

    // Connect the three partitions
    greaterHead.next = null;
    equalHead.next = greater.next;
    smallHead.next = equal.next;

    return small.next;
}
}