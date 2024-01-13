class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
        return null;

        ListNode res = new ListNode(0);
        ListNode curr = head;

        while(curr != null)
        {
        ListNode prev = res;
        while(prev.next != null && prev.next.val <= curr.val)
        {
            prev = prev.next;
        }
        ListNode next = curr.next;
        curr.next = prev.next;
        prev.next = curr;
        curr = next;
        }
        return res.next;
    }
}