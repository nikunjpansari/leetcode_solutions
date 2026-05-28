class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            int len = word.length();

            TrieNode curr = root;
            update(curr, len, i);

            for (int j = len - 1; j >= 0; j--) {
                int idx = word.charAt(j) - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }

                curr = curr.children[idx];
                update(curr, len, i);
            }
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            TrieNode curr = root;
            String query = wordsQuery[i];

            for (int j = query.length() - 1; j >= 0; j--) {
                int idx = query.charAt(j) - 'a';

                if (curr.children[idx] == null) {
                    break;
                }

                curr = curr.children[idx];
            }

            ans[i] = curr.bestIdx;
        }

        return ans;
    }

    private void update(TrieNode node, int len, int idx) {
        if (len < node.bestLen || (len == node.bestLen && idx < node.bestIdx)) {
            node.bestLen = len;
            node.bestIdx = idx;
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestLen = Integer.MAX_VALUE;
        int bestIdx = Integer.MAX_VALUE;
    }
}