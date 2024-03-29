/**
 * LeetCode 211 Design Add and Search Words Data Structure
 */
class WordDictionary {
        private Trie root;

        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            root.insert(word);
        }

        public boolean search(String word) {
            return dfs(word,0,root);
        }

        private boolean dfs(String word , int index,Trie node) {
            if (index == word.length()) {
                return node.isEnd();
            }
            char c = word.charAt(index);
            if (Character.isLetter(c)) {
                int cIndex = c - 'a';
                Trie children = node.getChildren()[cIndex];
                if (children != null && dfs(word,index + 1,children)) {
                    return true;
                }
            } else {
                for (int i = 0; i < 26; i++) {
                    Trie children = node.getChildren()[i];
                    if (children != null && dfs(word,index + 1,children)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public Trie[] getChildren() {
            return children;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
