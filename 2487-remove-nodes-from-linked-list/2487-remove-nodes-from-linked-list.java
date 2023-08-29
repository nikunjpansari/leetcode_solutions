/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        
        head = rev(head);
        ListNode node = head;
        
        while(node!=null && node.next!=null)
        {
            if(node.val > node.next.val) 
            node.next = node.next.next;
            else 
            node = node.next;
        }
        
        return rev(head);
    }
    
    ListNode rev(ListNode head){
        ListNode prev = null, next =null;
        
        while(head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}