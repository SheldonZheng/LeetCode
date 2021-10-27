/**
 * LeetCode 301 Remove Invalid Parentheses
 */
class Solution {
    Set<String> res = new HashSet<>();
    int n,max,len;
    String s;

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        this.s = s;
        n = s.length();
        int l = 0,r = 0;
        int cl = 0,cr = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cl++;
                l++;
            } else if (c == ')') {
                cr++;
                if (l != 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        len = n - l - r;
        max = Math.min(cl,cr);

        dfs(0,"",l,r,0);
        return new ArrayList<>(res);
    }

    void dfs(int u,String cur,int l, int r,int score) {
        if (l < 0 || r < 0 || score < 0 || score > max) {
            return;
        }
        if (l == 0 && r == 0) {
            if (cur.length() == len) {
                res.add(cur);
            }
        }

        if (u == n) {
            return;
        }
        char c = s.charAt(u);
        if (c == '(') {
            dfs(u + 1,cur + String.valueOf(c),l,r,score + 1);
            dfs(u + 1,cur,l - 1,r,score);
        } else if (c == ')') {
            dfs(u + 1,cur + String.valueOf(c),l,r,score - 1);
            dfs(u + 1,cur,l,r - 1,score);
        } else {
            dfs(u + 1,cur + String.valueOf(c),l,r,score);
        }
    }
}
