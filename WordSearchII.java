/**
 * LeetCode 212 Word Search II
 */
class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words == null) {
            return new ArrayList<>();
        }

        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }

        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                find(board,visited,i,j,result,root.root);
            }
        }
        return new ArrayList<>(result);
    }

    private void find(char[][] board, boolean[][] visited, int i, int j, Set<String> result,TrieNode cur) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j]) {
            return;
        }
        cur = cur.get(board[i][j]);
        if (cur == null) {
            return;
        }
        visited[i][j] = true;

        if (cur.isEnd) {
            result.add(cur.val);
        }

        find(board,visited,i + 1,j,result,cur);
        find(board,visited,i - 1,j,result,cur);
        find(board,visited,i,j + 1,result,cur);
        find(board,visited,i,j - 1,result,cur);

        visited[i][j] = false;

        return;
    }
    class Trie {

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch,new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
            node.val = word;
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    return null;
                }
            }
            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }

    class TrieNode {
        private TrieNode[] nexts;

        private String val;

        public TrieNode() {
            nexts = new TrieNode[length];
        }
        private final int length = 26;

        private boolean isEnd = false;

        public boolean containsKey(char ch) {
            return get(ch) != null;
        }
        public TrieNode get(char ch) {
            return nexts[ch - 'a'];
        }
        public void put(char ch, TrieNode node) {
            nexts[ch - 'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }



}
