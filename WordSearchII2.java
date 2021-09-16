/**
 * LeetCode 212 Word Search II
 */
class Solution {
    TrieNode root = new TrieNode();
    Set<String> res = new HashSet<>();
    char[][] globalBoard;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    boolean[][] vis = new boolean[13][13];
    int n,m;
    class TrieNode {
        String cur;
        TrieNode[] list = new TrieNode[26];
    }
    void insert(String str) {
        TrieNode p = root;
        for (int i = 0; i < str.length(); i++) {
            int curPos = str.charAt(i) - 'a';
            if (p.list[curPos] == null) {
                p.list[curPos] = new TrieNode();
            }
            p = p.list[curPos];
        }
        p.cur = str;
    }
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) {
            throw new IllegalArgumentException();
        }
        globalBoard = board;
        for (String word : words) {
            insert(word);
        }
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int curPos = board[i][j] - 'a';
                if (root.list[curPos] != null) {
                    vis[i][j] = true;
                    dfs(i,j,root.list[curPos]);
                    vis[i][j] = false;
                }
            }
        }
        return new ArrayList<>(res);
    }

    void dfs(int i,int j,TrieNode node) {
        if (node.cur != null) {
            res.add(node.cur);
        }
        for (int[] d : dirs) {
            int nx = i + d[0],ny = j + d[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny]) {
                continue;
            }
            int cur = globalBoard[nx][ny] - 'a';
            if (node.list[cur] != null) {
                vis[nx][ny] = true;
                dfs(nx,ny,node.list[cur]);
                vis[nx][ny] = false;
            }

        }
    }
}
