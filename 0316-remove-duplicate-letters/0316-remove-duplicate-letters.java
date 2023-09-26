class Solution {
    public String removeDuplicateLetters(String s) {
        boolean visited[] = new boolean[26];
        int lastSeen[] = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            lastSeen[c-'a'] = i;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(visited[c-'a']) {
                continue;
            }
            
            while(!stack.isEmpty() && stack.peek() > c && i< lastSeen[stack.peek()-'a']) {
                visited[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
            visited[c-'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }
}