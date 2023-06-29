class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        
        Stack<Integer> result = new Stack<>();
        
        int carry = 0;
        
        while (!stack1.empty() || !stack2.empty() || carry != 0) {
            int val1 = stack1.empty() ? 0 : stack1.pop();
            int val2 = stack2.empty() ? 0 : stack2.pop();
            
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            result.add(sum % 10);
        }
        
        ListNode ans = new ListNode();
        
        ListNode temp = ans;
        while (!result.empty()) {
            temp.next = new ListNode(result.pop());
            temp = temp.next;
        }
        
        return ans.next;
    }
}